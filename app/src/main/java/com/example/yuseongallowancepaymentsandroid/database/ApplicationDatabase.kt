package com.example.yuseongallowancepaymentsandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.yuseongallowancepaymentsandroid.dao.ApplicationDao
import com.example.yuseongallowancepaymentsandroid.entity.CourtesyApplication
import com.example.yuseongallowancepaymentsandroid.entity.HonorApplication
import com.example.yuseongallowancepaymentsandroid.entity.PartnerApplication


@Database(
    entities = [CourtesyApplication::class, HonorApplication::class, PartnerApplication::class],
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