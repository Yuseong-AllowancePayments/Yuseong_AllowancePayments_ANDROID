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
    entities = [
        CourtesyApplication::class,
        HonorApplication::class,
        PartnerApplication::class,
    ],
    version = 1,
)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun applicationDao(): ApplicationDao

    companion object {
        private var INSTANCE: ApplicationDatabase? = null

        fun getInstance(context: Context): ApplicationDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ApplicationDatabase::class.java,
                        "application-database"
                    ).fallbackToDestructiveMigration()
                        .build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}