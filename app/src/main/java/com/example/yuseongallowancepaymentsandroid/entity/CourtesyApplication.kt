package com.example.yuseongallowancepaymentsandroid.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity
data class CourtesyApplication(
    @PrimaryKey val affairsNumber: String, // 보훈번호
    @ColumnInfo val veteranType: String, // 보훈대상자 구분
    @ColumnInfo val applicantName: String, // 신청인 성명
    @ColumnInfo val birthDate: String, // 신청인 생년월일
    @ColumnInfo val gender: String, // 신청인 성별
    @ColumnInfo val postAddress: String, // 신청인 우편 번호
    @ColumnInfo val roadAddress: String, // 신청인 도로명 주소
    @ColumnInfo val administrativeAddress: String, // 행정동
    @ColumnInfo val phoneNum: String, // 신청인 전화번호(연락처)
    @ColumnInfo val bankName: String, // 은행명
    @ColumnInfo val accountOwner: String, // 예금주 성명
    @ColumnInfo val accountNumber: String, // 계좌번호
    @ColumnInfo val applicationDate: String, // 신청일
    @ColumnInfo val note: String?, // 비고
)