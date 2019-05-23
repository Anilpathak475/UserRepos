package com.github.user

import android.util.Log
import androidx.annotation.WorkerThread
import com.github.user.database.Repo
import com.github.user.database.RepoDatabase

object DataManager {

    @WorkerThread
    fun saveRepoes(wishes: List<Repo>) {
        val db = RepoDatabase.get()
        deleteAllRepos()
        db.wishDao().insert(wishes)
        Log.d("Size in databse", "" + getRepos().size)
    }

    @WorkerThread
    fun getRepos(): List<Repo> {
        return RepoDatabase.get().wishDao().getAll()
    }

    @WorkerThread
    private fun deleteAllRepos() {
        return RepoDatabase.get().wishDao().deleteAll()
    }

}