package com.github.user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.user.database.Repo
import com.github.user.network.errorhandler.RepoErrorHandler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_wish.view.*
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private val wishAdapter by lazy { RepoAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        wishRecyclerView.let {
            it.layoutManager = LinearLayoutManager(this)
            it.adapter = wishAdapter
        }

        applyStateListeners()
        if (!networkStatus) {
            Toast.makeText(
                this@MainActivity,
                "No Internet Available! Showing records saved in device if any.",
                Toast.LENGTH_LONG
            ).show()

        }
        viewModel.loadRepos()
    }

    private fun applyStateListeners() {
        viewModel.exception.observe(this, Observer { errorHandler(it) })
        viewModel.wishes.observe(this, Observer { setData(it) })
    }

    private fun setData(words: List<Repo>) {
        wishAdapter.wishes = words
        wishAdapter.notifyDataSetChanged()
        progressBar.gone()
        wishRecyclerView.visible()
    }

    private fun errorHandler(exception: Exception) {
        when (exception) {
            is RepoErrorHandler.ErrorConfig.NetworkException -> {
                Toast.makeText(this@MainActivity, exception.message, Toast.LENGTH_LONG).show()
            }
            is RepoErrorHandler.ErrorConfig.AlbumException -> {
                Toast.makeText(this@MainActivity, exception.message, Toast.LENGTH_LONG).show()
            }
            else -> Toast.makeText(this@MainActivity, "Oops! Something went wrong.", Toast.LENGTH_LONG).show()
        }
        progressBar.gone()

    }

    class RepoAdapter :
        RecyclerView.Adapter<RepoAdapter.RepoViewHolder>(), AutoUpdatableAdapter {

        var wishes: List<Repo> by Delegates.observable(emptyList()) { prop, old, new ->
            autoNotify(old, new) { o, n -> o.id == n.id }
        }

        override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): RepoViewHolder {
            val layoutInflater =
                viewGroup.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val convertView = layoutInflater.inflate(R.layout.item_wish, viewGroup, false)
            return RepoViewHolder(convertView)
        }

        override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
            holder.bind(wishes[position])
        }

        override fun getItemCount(): Int {
            return wishes.size
        }

        inner class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            fun bind(repo: Repo) {
                itemView.repoName.text = repo.name
                itemView.repoForks.text = repo.forks.toString()
                itemView.repoLanguage.text = repo.language
                itemView.repoDesc.text = repo.description
                itemView.repoType.text = if (repo.private) "Private" else "Public"
            }
        }
    }
}
