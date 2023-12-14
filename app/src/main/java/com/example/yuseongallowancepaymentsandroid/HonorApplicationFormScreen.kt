package com.example.yuseongallowancepaymentsandroid

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun HonorApplicationFormScreen(
    navController: NavController,
) {
    var name by remember { mutableStateOf("") }
    var idCard by remember { mutableStateOf("") }
    var honorNumber by remember { mutableStateOf("") }
    var acquisitionDate by remember { mutableStateOf("") }
    var applicationDate by remember { mutableStateOf("") }
    var moveInDate by remember { mutableStateOf("") }
    // var moveOutDate by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    // var administrativeBuilding by remember { mutableStateOf("") }
    var depositType by remember { mutableStateOf("") }
    var bankName by remember { mutableStateOf("") }
    var accountHolder by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    // var cityBudget by remember { mutableStateOf("") }
    // var districtBudget by remember { mutableStateOf("") }
    // var retroactivePaymentMatter by remember { mutableStateOf("") }

    MainTopAppBar(
        title = "참전유공자 명예 수당 지급 신청서 작성",
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 60.dp, end = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        TextField()
        Button(onClick = { })
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar(
    title: String,
) {
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
                        text = title,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                    )
                },
                /*navigationIcon = {
                    IconButton(onClick = onClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },*/
                scrollBehavior = scrollBehavior,
            )
        },
    ) {

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
private fun TextField() {
    var name by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf("") }
    var veteranNumber by remember { mutableStateOf("") }
    var acquisitionDate by remember { mutableStateOf("") }
    var applicationDate by remember { mutableStateOf("") }
    var moveInDate by remember { mutableStateOf("") }
    // var moveOutDate by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }
    // var administrativeBuilding by remember { mutableStateOf("") }
    var depositType by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var accountHolder by remember { mutableStateOf("") }
    var accountNumber by remember { mutableStateOf("") }
    // var cityBudget by remember { mutableStateOf("") }
    // var districtBudget by remember { mutableStateOf("") }
    // var retroactivePaymentMatter by remember { mutableStateOf("") }

    Spacer(modifier = Modifier.height(30.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = name,
            text = "성명",
            onValueChange = { name = it },
            label = "성명을 입력해주세요",
            width = 400.dp,
        )
        CommonTextField(
            value = birth,
            text = "생년월일",
            onValueChange = { birth = it },
            label = "생년월일을 입력해주세요. 예)2023-01-01",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = birth,
            text = "주민등록번호",
            onValueChange = { birth = it },
            label = "주민등록번호를 입력해주세요",
            width = 400.dp,
        )
        CommonTextField(
            value = birth,
            text = "참전등록번호",
            onValueChange = { birth = it },
            label = "참전등록번호를 입력해주세요.",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Text(
        text = "우편번호",
        fontSize = 16.sp,
        color = Color.Black,
        fontFamily = FontFamily(Font(R.font.pretendard_medium))
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Column {
            OutlinedTextField(
                modifier = Modifier.width(400.dp),
                value = accountNumber,
                onValueChange = { accountNumber = it },
                label = { Text(text = "우편번호 찾기 버튼을 눌러주세요.") },
                shape = RoundedCornerShape(8.dp),
                maxLines = 1,
            )
        }
        androidx.compose.material3.Button(
            colors = ButtonDefaults.buttonColors(Color.White),
            onClick = {},
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .width(160.dp)
                .border(
                    width = 1.dp,
                    shape = RoundedCornerShape(8.dp),
                    color = Color.Black,
                ),
        ) {
            Text(
                text = "우편번호 찾기",
                color = Color.Black,
                fontSize = 16.sp,
            )
        }
    }
    Spacer(modifier = Modifier.height(40.dp))
    CommonFilledTextField(
        value = address,
        text = "상세 주소",
        onValueChange = { address = it },
        label = "우편 번호 찾기 후 상세 주소를 입력해주세요.",
    )
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = phone,
            text = "전화번호",
            onValueChange = { phone = it },
            label = "전화번호를 입력해주세요.",
            width = 400.dp,
        )
        CommonTextField(
            value = accountHolder,
            text = "예금주 성명",
            onValueChange = { accountHolder = it },
            label = "예금주 성명을 입력해주세요",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = accountHolder,
            text = "은행명",
            onValueChange = { accountHolder = it },
            label = "금융 기관을 입력해주세요.",
            width = 400.dp,
        )
        CommonTextField(
            value = accountNumber,
            text = "계좌 번호",
            onValueChange = { accountNumber = it },
            label = "예금 종류를 입력해주세요.",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(50.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonFilledTextField(
            value = accountNumber,
            text = "전입일",
            onValueChange = { accountNumber = it },
            label = "전입일과 지역을 입력해주세요. 예)2023-01-01(대전 서구)",
        )
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CommonTextFieldIcon(
    value: String,
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
    icon: Painter,
) {
    Column {
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color.Black,
            fontFamily = FontFamily(Font(R.font.pretendard_medium))
        )
        OutlinedTextField(
            modifier = Modifier.width(330.dp),
            value = value,
            onValueChange = onValueChange,
            label = { Text(text = label) },
            shape = RoundedCornerShape(8.dp),
            trailingIcon = {
                Icon(
                    modifier = Modifier.size(24.dp),
                    painter = icon,
                    contentDescription = null,
                )
            },
            maxLines = 1,
        )
    }
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
