package com.example.yuseongallowancepaymentsandroid.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PartnerApplication(
    @PrimaryKey val affairsNumber: String, // 보훈 번호
    @ColumnInfo val applicantName: String, // 신청인 성명
    @ColumnInfo val applicantBirthDate: String, // 신청인 주민번호
    @ColumnInfo val applicantPostAddress: String, // 신청인 우편번호
    @ColumnInfo val applicantRoadAddress: String, // 신청인 도로명 주소
    @ColumnInfo val administrativeAddress: String, // 행정동
    @ColumnInfo val veteranName: String, // 참전유공자 성명
    @ColumnInfo val veteranBirthDate: String, // 참전유공자 주민번호
    @ColumnInfo val veteranDeathDate: String, // 참전유공자 사망일자
    @ColumnInfo val warName: String, // 참전유공자 구분
    @ColumnInfo val bankName: String, // 은행명
    @ColumnInfo val accountNumber: String, // 계좌번호
    @ColumnInfo val accountName: String, // 예금주 성명
    @ColumnInfo val applicationDate: String, // 신청일
    @ColumnInfo val note: String, // 비고
)