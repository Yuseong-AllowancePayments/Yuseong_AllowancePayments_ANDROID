package com.example.yuseongallowancepaymentsandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("courtesyApplication")
data class CourtesyApplicationModel(
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

@Entity("honorApplication")
data class HonorApplicationModel(
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

@Entity("partnerApplication")
data class PartnerApplicationModel(
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