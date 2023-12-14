package com.example.yuseongallowancepaymentsandroid.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("application")
data class ApplicationModel(
    @PrimaryKey val id: Long,
    val name: String,
    val registrationNumber: String,
    val honorNumber: Int, // 보훈 번호
    val acquisitionDate: String, // 보훈 자격 취득일
    val applicationDate: String, // 보훈 수당 신청일
    val moveInDate: String, // 전입일
    val address: String, // 주소
    val depositType: String, // 입금 유형
    val bankName: String, // 은행명
    val accountHolder: String, // 예금주
    val accountNumber: String, // 계좌 번호
)