package com.example.yuseongallowancepaymentsandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExcelScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        Title()

    }
}

@Composable
private fun Title() {
    Column(
        modifier = Modifier.padding(start = 30.dp, top = 60.dp, end = 30.dp)
    ) {
        Text(
            text = "참전유공자 명예 수당 지급 대상자 조회",
            color = Color.Black,
            fontSize = 36.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_bold))
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "* 셀을 터치하여 데이터를 바로 수정할 수 있습니다.",
            color = Color.Red,
            fontSize = 16.sp,
            fontFamily = FontFamily(Font(R.font.pretendard_regular)),
        )
        Spacer(modifier = Modifier.height(24.dp))
        TabRoww()
    }
}

@Composable
private fun TabRoww() {
    var state by remember { mutableStateOf(0) }
    val titles = listOf("대상자 현황", "현금 지급", "신규자", "지급중지자")

    Column {
        ScrollableTabRow(
            edgePadding = 0.dp,
            selectedTabIndex = state,
            containerColor = Color.White,
            contentColor = Color(0xFF2F68C2),
        ) {
            titles.forEachIndexed { index, title ->
                val textColor = if (state == index) Color(0xFF2F68C2) else Color.Black
                Tab(
                    selected = state == index,
                    onClick = { state = index },
                    text = {
                        Text(
                            text = title,
                            color = textColor,
                            fontFamily = FontFamily(Font(R.font.pretendard_semi_bold)),
                            fontSize = 20.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    },
                )
            }
        }
    }
}