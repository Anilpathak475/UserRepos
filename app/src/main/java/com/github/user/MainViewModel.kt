package com.github.user


import android.app.Application
import androidx.annotation.UiThread
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.github.user.database.Repo
import com.github.user.network.model.Wrapper
import com.github.user.network.request.RepoRequest
import com.github.user.network.requesthandler.Kobserver


class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _exception = MutableLiveData<java.lang.Exception>()
    val exception: LiveData<java.lang.Exception> get() = _exception

    private val _wishes = MutableLiveData<List<Repo>>()
    val wishes: LiveData<List<Repo>> get() = _wishes
    @UiThread
    fun loadRepos(): LiveData<List<Repo>> {
        Coroutines.ioThenMain({
            DataManager.getRepos()
        }) {
            when {
                it!!.isNullOrEmpty() -> remoteLoadRepos()
                else -> {
                    _wishes.value = it
                    remoteLoadRepos()
                }
            }
        }
        return wishes
    }

    private fun remoteLoadRepos() {
        reposApi().observeForever(object : Kobserver<List<Repo>>(),
            Observer<Wrapper<List<Repo>>> {
            override fun onSuccess(data: List<Repo>) {
                Coroutines.ioThenMain({
                    DataManager.saveRepoes(data)
                }) {
                    _wishes.value = data
                }
            }

            override fun onException(exception: Exception) {
                super.onException(exception)
                this@MainViewModel._exception.value = exception
            }
        })
    }

    private fun reposApi(): LiveData<Wrapper<List<Repo>>> {
        return RepoRequest().doRequest()
    }
}