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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun PartnerApplicationFormScreen(navController: NavController) {
    MainTopAppBar(title = "참전유공자 배우자 수당 지급 신청서 작성")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, top = 60.dp, end = 30.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        TextField()
        Button(onClick = { /*TODO*/ })
        Spacer(modifier = Modifier.height(30.dp))
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MainTopAppBar(
    title: String
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
                    IconButton(onClick = { *//* do something *//* }) {
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
    var idCard by remember { mutableStateOf("") }
    var veteranNumber by remember { mutableStateOf("") }
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
        )
        CommonTextField(
            value = idCard,
            text = "주민등록번호",
            onValueChange = { idCard = it },
            label = "주민등록번호를 입력해주세요",
        )
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
        CommonTextFieldIcon(
            value = acquisitionDate,
            text = "보훈 자격 취득일",
            onValueChange = { acquisitionDate = it },
            label = "보훈 자격 취득일을 선택해주세요.",
            icon = painterResource(id = R.drawable.ic_calendar),
        )
        CommonTextFieldIcon(
            value = applicationDate,
            text = "보훈 수당 신청일",
            onValueChange = { applicationDate = it },
            label = "보훈 수당 신청일을 선택해주세요.",
            icon = painterResource(id = R.drawable.ic_calendar),
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextFieldIcon(
            value = moveInDate,
            text = "전입일",
            onValueChange = { moveInDate = it },
            label = "전입일을 선택해주세요.",
            icon = painterResource(id = R.drawable.ic_calendar),
        )
    }
    Spacer(modifier = Modifier.height(106.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = address,
            text = "주소",
            onValueChange = { address = it },
            label = "도로명 주소를 입력해주세요.",
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = depositType,
            text = "입금 유형",
            onValueChange = { depositType = it },
            label = "입금 유형을 입력해주세요."
        )
        CommonTextField(
            value = bankName,
            text = "은행명",
            onValueChange = { bankName = it },
            label = "은행명을 입력해주세요.",
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = accountHolder,
            text = "예금주",
            onValueChange = { accountHolder = it },
            "예금주 성명을 입력해주세요.",
        )
        CommonTextField(
            value = accountNumber,
            text = "계좌 번호",
            onValueChange = { accountNumber = it },
            label = "계좌 번호를 입력해주세요.",
        )
    }
    Spacer(modifier = Modifier.height(50.dp))
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CommonTextField(
    value: String,
    text: String,
    onValueChange: (String) -> Unit,
    label: String,
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
            maxLines = 1,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CommonTextFieldIcon(
    value: String,
    text: String,
    onValueChange: (String) -> Unit,
    label: String, icon: Painter,
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
