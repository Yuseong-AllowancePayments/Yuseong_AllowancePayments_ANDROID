package com.example.yuseongallowancepaymentsandroid.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HonorApplication(
    @PrimaryKey val registrationNumber: String,
    @ColumnInfo val name: String, // 성명
    @ColumnInfo val birthDate: String, // 주민등록번호
    @ColumnInfo val postAddress: String, // 우편 번호
    @ColumnInfo val roadAddress: String, // 도로명 주소
    @ColumnInfo val administrativeAddress: String, // 행정동
    @ColumnInfo val phone: String, // 전화번호
    @ColumnInfo val bankName: String, // 은행명
    @ColumnInfo val accountNumber: String, // 계좌 번호
    @ColumnInfo val accountType: String, // 예금 종류
    @ColumnInfo val accountOwner: String, // 예금주 성명
    @ColumnInfo val applicationDate: String, // 신청일
    @ColumnInfo val note: String?, // 비고
)