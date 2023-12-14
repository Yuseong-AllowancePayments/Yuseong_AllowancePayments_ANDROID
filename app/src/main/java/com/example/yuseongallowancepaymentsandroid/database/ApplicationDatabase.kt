package com.example.yuseongallowancepaymentsandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yuseongallowancepaymentsandroid.dao.ApplicationDao
import com.example.yuseongallowancepaymentsandroid.entity.Application


@Database(
    entities = [Application::class],
    version = 1,
)

abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun applicationDao(): ApplicationDao

    companion object {
        private var instance: ApplicationDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ApplicationDatabase? {
            if (instance == null) {
                synchronized(ApplicationDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ApplicationDatabase::class.java,
                        "application-database"
                    ).build()
                }
            }
            return instance
        }
    }
}