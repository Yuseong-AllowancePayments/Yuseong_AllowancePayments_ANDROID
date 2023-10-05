package com.example.yuseongallowancepaymentsandroid

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ApplicationFormScreen() {
    TopAppBar()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 60.dp, end = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        OverTextField()
        UnderTextField()
        Button(onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun TopAppBar() {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),

        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Color.Black,
                ),
                title = {
                    Text(
                        "참전유공자 명예 수당 지급 신청서 작성", maxLines = 1, overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior,
            )
        },
    ){

    }

    /*Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, top = 60.dp, end = 30.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier
                .size(36.dp)
                .padding(end = 7.dp),
            painter = painterResource(id = R.drawable.ic_back),
            contentDescription = null,
        )
        Text(
            text = "보훈 뭐시기 뭐시기",
            fontSize = 30.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.pretendard_bold)),
        )
    }*/
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun OverTextField() {
    var name by remember { mutableStateOf("") }
    var idCard by remember { mutableStateOf("") }
    var veteranNumber by remember { mutableStateOf("") }
    var acquisitionDate by remember { mutableStateOf("") }
    var applicationDate by remember { mutableStateOf("") }
    var moveInDate by remember { mutableStateOf("") }
    // var moveOutDate by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(30.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "성명",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = name,
                onValueChange = { name = it },
                label = { Text(text = "성명을 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = "주민등록번호",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = idCard,
                onValueChange = { idCard = it },
                label = { Text(text = "주민등록번호를 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
    Text(
        text = "보훈 번호",
        fontSize = 16.sp,
        color = Color.Black,
        fontFamily = FontFamily(Font(R.font.pretendard_medium)),
    )
    OutlinedTextField(
        modifier = Modifier.width(330.dp),
        value = veteranNumber,
        onValueChange = { veteranNumber = it },
        label = { Text(text = "보훈 번호를 입력해주세요.") },
        shape = RoundedCornerShape(8.dp),
        maxLines = 1,
    )
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "보훈 자격 취득일",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = acquisitionDate,
                onValueChange = { acquisitionDate = it },
                label = { Text(text = "보훈 자격 취득일을 선택해주세요.") },
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null
                    )
                },
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = "보훈 수당 신청일",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = applicationDate,
                onValueChange = { applicationDate = it },
                label = { Text(text = "보훈 수당 신청일을 선택해주세요.") },
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null,
                    )
                },
                maxLines = 1,
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "전입일",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = moveInDate,
                onValueChange = { moveInDate = it },
                label = { Text(text = "전입일을 선택해주세요.") },
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null
                    )
                },
                maxLines = 1,
            )
        }/*Column {
            Text(
                text = "전출일",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            )
            OutlinedTextField(
                value = moveOutDate,
                onValueChange = { moveOutDate = it },
                label = { Text(text = "전출일을 선택해주세요.") },
                shape = RoundedCornerShape(8.dp),
                trailingIcon = {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.ic_calendar),
                        contentDescription = null,
                    )
                },
                maxLines = 1,
            )
        }*/
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun UnderTextField() {
    var address by remember { mutableStateOf("") }
    // var administrativeBuilding by remember { mutableStateOf("") }
    var depositType by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var accountHolder by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    // var cityBudget by remember { mutableStateOf("") }
    // var districtBudget by remember { mutableStateOf("") }
    // var retroactivePaymentMatter by remember { mutableStateOf("") }


    Spacer(modifier = Modifier.height(106.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "주소",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = address,
                onValueChange = { address = it },
                label = { Text(text = "도로명 주소를 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }/*Column {
            Text(
                text = "행정동",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                value = administrativeBuilding,
                onValueChange = { administrativeBuilding = it },
                label = { Text(text = "주소를 입력하시면 자동 입력됩니다.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }*/
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "입금 유형",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = depositType,
                onValueChange = { depositType = it },
                label = { Text(text = "입금 유형을 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = "은행명",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = bankName,
                onValueChange = { bankName = it },
                label = { Text(text = "은행명을 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Text(
                text = "예금주",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = accountHolder,
                onValueChange = { accountHolder = it },
                label = { Text(text = "예금주 성명을 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
        Column {
            Text(
                text = "계좌 번호",
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.pretendard_medium))
            )
            OutlinedTextField(
                modifier = Modifier.width(330.dp),
                value = accountNumber,
                onValueChange = { accountNumber = it },
                label = { Text(text = "계좌번호를 입력해주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@Composable
private fun Button(
    onClick: () -> Unit,
) {
    val backgroundColor = Color(0xFF2F68C2)

    androidx.compose.material3.Button(
        colors = ButtonDefaults.buttonColors(backgroundColor),
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .fillMaxWidth()
            .background(backgroundColor),
    ) {
        Text(
            text = "작성완료",
            color = Color.White,
            fontSize = 16.sp,
        )
    }
}