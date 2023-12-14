package com.example.yuseongallowancepaymentsandroid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yuseongallowancepaymentsandroid.entity.Application

@Dao
interface ApplicationDao {
    @Insert
    suspend fun insert(application: Application)

    @Update
    suspend fun update(application: Application)

    @Query("select * from application")
    suspend fun getApplication(): List<Application>

    @Query("SELECT * FROM APPLICATION") // 테이블의 모든 값을 가져와라
    fun getAll(): List<Application>
}