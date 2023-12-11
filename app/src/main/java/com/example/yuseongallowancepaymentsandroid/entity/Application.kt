package com.example.yuseongallowancepaymentsandroid.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Application(
    @ColumnInfo val name: String, // 성명
    @PrimaryKey val registrationNumber: String, // 주민등록번호
    @ColumnInfo val honorNumber: Int, // 보훈 번호
    @ColumnInfo val acquisitionDate: String, // 보훈 자격 취득일
    @ColumnInfo val applicationDate: String, // 보훈 수당 신청일
    @ColumnInfo val moveInDate: String, // 전입일
    @ColumnInfo val address: String, // 주소
    @ColumnInfo val depositType: String, // 입금 유형
    @ColumnInfo val bankName: String, // 은행명
    @ColumnInfo val accountHolder: String, // 예금주
    @ColumnInfo val accountNumber: String, // 계좌 번호
)