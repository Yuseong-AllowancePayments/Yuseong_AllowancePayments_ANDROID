package com.example.yuseongallowancepaymentsandroid

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun CourtesyApplicationFormScreen(navController: NavController) {
    MainTopAppBar(title = "보훈 예우 수당 지급 신청서 작성")
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
                    IconButton(onClick = { */
                /* do something */
                /* }) {
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
            text = "보훈대상자 구분",
            onValueChange = { name = it },
            label = "구분을 입력해주세요",
            width = 400.dp,
        )
        CommonTextField(
            value = idCard,
            text = "보훈 번호",
            onValueChange = { idCard = it },
            label = "보훈 번호를 입력해주세요",
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
            value = acquisitionDate,
            text = "신청인의 성명",
            onValueChange = { acquisitionDate = it },
            label = "신청인의 성명을 입력해주세요",
            width = 400.dp,
        )
        CommonTextField(
            value = applicationDate,
            text = "신청인 생년월일",
            onValueChange = { applicationDate = it },
            label = "신청인의 생년월일을 입력해주세요. 예)2023-01-01",
            width = 400.dp
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = address,
            text = "신청인 주민등록번호",
            onValueChange = { address = it },
            label = "신청인의 주민등록번호를 입력해주세요.",
            width = 400.dp,
        )
        CommonTextField(
            value = moveInDate,
            text = "신청인 성별",
            onValueChange = { moveInDate = it },
            label = "신청인의 성별을 입력해주세요.",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = address,
            text = "신청인 전화번호",
            onValueChange = { address = it },
            label = "신청인의 전화번호를 입력해주세요.",
            width = 400.dp,
        )
        CommonTextField(
            value = accountHolder,
            text = "은행명",
            onValueChange = { accountHolder = it },
            label = "은행명을 입력해주세요.",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = accountNumber,
            text = "예금주",
            onValueChange = { accountNumber = it },
            label = "예금주 성명을 입력해주세요.",
            width = 400.dp,
        )
        CommonTextField(
            value = accountNumber,
            text = "계좌번호",
            onValueChange = { accountNumber = it },
            label = "계좌번호를 입력해주세요.",
            width = 400.dp,
        )
    }
    Spacer(modifier = Modifier.height(40.dp))
    CommonFilledTextField(
        value = accountNumber,
        text = "전입일",
        onValueChange = { accountNumber = it },
        label = "전입일과 지역을 입력해주세요. 예)2023-01-01(대전 서구)",
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = "아래는 보훈 대상자가 유족일 경우에만 입력해주세요",
    )
    Spacer(modifier = Modifier.height(20.dp))
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        CommonTextField(
            value = accountNumber,
            text = "가족 관계",
            onValueChange = { accountNumber = it },
            label = "보훈 대상자와의 가족 관계를 입력해주세요. 예) 자녀",
            width = 400.dp,
        )
        CommonTextField(
            value = accountNumber,
            text = "선순위 유족 여부",
            onValueChange = { accountNumber = it },
            label = "선순위 유족 여부를 입력해주세요. 예) 예",
            width = 400.dp,
        )
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
