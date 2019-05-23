package com.github.user.database


import androidx.annotation.WorkerThread
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.user.WishApplication

@Database(entities = [Repo::class], version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {

    abstract fun wishDao(): Wishes

    companion object {

        private var INSTANCE: RepoDatabase? = null

        @WorkerThread
        fun get(): RepoDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(WishApplication.applicationContext(), RepoDatabase::class.java, "users")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!
        }

    }
}
