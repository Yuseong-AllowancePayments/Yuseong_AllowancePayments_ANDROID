package com.example.yuseongallowancepaymentsandroid.dao

import androidx.lifecycle.LiveData
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
    suspend fun honorInsert(honorApplication: HonorApplication)
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


    @Query("select * from honorApplication")
    fun getHonorApplication(): LiveData<List<HonorApplication>>
    @Query("select * from partnerApplication")
    fun getPartnerApplication(): LiveData<List<PartnerApplication>>
    @Query("select * from courtesyApplication")
    fun getCourtesyApplication(): LiveData<List<CourtesyApplication>>
}