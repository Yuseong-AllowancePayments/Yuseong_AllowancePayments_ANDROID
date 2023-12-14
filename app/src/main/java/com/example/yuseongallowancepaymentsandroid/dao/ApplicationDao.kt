package com.example.yuseongallowancepaymentsandroid.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.yuseongallowancepaymentsandroid.entity.CourtesyApplication
import com.example.yuseongallowancepaymentsandroid.entity.HonorApplication
import com.example.yuseongallowancepaymentsandroid.entity.PartnerApplication

@Dao
interface ApplicationDao {
    @Insert
    suspend fun honorInsert(courtesyApplication: CourtesyApplication)
    @Insert
    suspend fun partnerInsert(partnerApplication: PartnerApplication)
    @Insert
    suspend fun courtesyInsert(courtesyApplication: CourtesyApplication)
    @Update
    suspend fun honorUpdate(honorApplication: HonorApplication)
    @Update
    suspend fun partnerUpdate(partnerApplication: PartnerApplication)
    @Update
    suspend fun courtesyUpdate(courtesyApplication: CourtesyApplication)
    @Query("select * from courtesyApplication")
    suspend fun getCourtesyApplication(): List<CourtesyApplication>

    @Query("SELECT * FROM COURTESYAPPLICATION") // 테이블의 모든 값을 가져와라
    fun getAll(): List<CourtesyApplication>
}