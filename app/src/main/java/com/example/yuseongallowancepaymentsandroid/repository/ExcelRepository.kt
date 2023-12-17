package com.example.yuseongallowancepaymentsandroid.repository

import androidx.lifecycle.LiveData
import com.example.yuseongallowancepaymentsandroid.dao.ApplicationDao
import com.example.yuseongallowancepaymentsandroid.entity.CourtesyApplication
import com.example.yuseongallowancepaymentsandroid.entity.HonorApplication
import com.example.yuseongallowancepaymentsandroid.entity.PartnerApplication

class ExcelRepository(private val applicationDao: ApplicationDao) {
    val readHonorData : LiveData<List<HonorApplication>> = applicationDao.getHonorApplication()
    val readPartnerData : LiveData<List<PartnerApplication>> = applicationDao.getPartnerApplication()
    val readCourtesyData : LiveData<List<CourtesyApplication>> = applicationDao.getCourtesyApplication()

    suspend fun honorInsert(honorApplication: HonorApplication) {
        applicationDao.honorInsert(honorApplication)
    }

    suspend fun partnerInsert(partnerApplication: PartnerApplication) {
        applicationDao.partnerInsert(partnerApplication)
    }

    suspend fun courtesyInsert(courtesyApplication: CourtesyApplication) {
        applicationDao.courtesyInsert(courtesyApplication)
    }

    suspend fun honorUpdate(honorApplication: HonorApplication) {
        applicationDao.honorUpdate(honorApplication)
    }

    suspend fun partnerUpdate(partnerApplication: PartnerApplication) {
        applicationDao.partnerUpdate(partnerApplication)
    }

    suspend fun courtesyUpdate(courtesyApplication: CourtesyApplication) {
        applicationDao.courtesyUpdate(courtesyApplication)
    }
}