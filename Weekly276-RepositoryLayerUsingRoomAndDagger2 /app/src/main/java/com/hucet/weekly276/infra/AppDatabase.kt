package com.hucet.weekly276.infra

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.hucet.weekly276.dao.FeedDao
import com.hucet.weekly276.dao.UserDao
import com.hucet.weekly276.domain.FeedDish
import com.hucet.weekly276.domain.UserDish

/**
 * Created by tyler on 2017. 10. 1..
 */
@Database(entities = arrayOf(FeedDish::class, UserDish::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun feedObject(): FeedDao

    abstract fun userObject(): UserDao


    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInMemoryDatabase(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "user-database")
                        //                    Room.inMemoryDatabaseBuilder(context.getApplicationContext(), AppDatabase.class)
                        // To simplify the codelab, allow queries on the main thread.
                        // Don't do this on a real app! See PersistenceBasicSample for an example.
                        .allowMainThreadQueries()
                        .build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}