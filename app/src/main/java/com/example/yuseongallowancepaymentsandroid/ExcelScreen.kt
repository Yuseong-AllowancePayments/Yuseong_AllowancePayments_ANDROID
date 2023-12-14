package com.example.yuseongallowancepaymentsandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun ExcelScreen(navController: NavController) {
    var state by remember { mutableIntStateOf(0) }

    val list = listOf(
        listOf(
            "연번", "행정동", "보훈번호", "성명", "주민등록번호",
            "주소", "입금유형", "은행명", "예금주", "계좌번호", "시비",
            "구비", "전입일", "비고",
        ),
        listOf(
            "연번", "행정동", "보훈번호", "성명", "주민등록번호",
            "주소", "입금유형", "시비", "구비", "비고",
        ),
        listOf(
            "연번", "행정동", "보훈번호", "성명", "주민등록번호",
            "주소", "입금유형", "은행명", "예금주", "계좌번호",
            "신규사유", "전입(등록)일", "비고",
        ),
        listOf(
            "연번", "행정동", "보훈번호", "성명", "주민등록번호",
            "주소", "지급방법", "은행명", "예금주", "계좌번호",
            "중단사유", "중단사유 발생일", "비고", "전입지 주소",
        )
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(Color.White)
    ) {
        TopAppBar()
        Row {
            TabRowMenu(
                state = state,
                stateChange = { state = it }
            )
            androidx.compose.material3.Button(
                modifier = Modifier
                    .height(40.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .align(Alignment.CenterVertically)
                    .padding(end = 64.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(0xFF2F68C2))
            ) {
                Text(
                    text = "엑셀파일 출력",
                    fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                )
            }
        }
        Column(modifier = Modifier.horizontalScroll(rememberScrollState())) {
            FieldTitle(list = list[state])
            for (i in 0..30) {
                Row {
                    list[state].forEachIndexed { _, s ->
                        var text by remember { mutableStateOf("") }
                        ExcelBasicTextField(
                            value = text,
                            onValueChange = {
                                text = it
                            },
                            width = (s.length * 40).dp,
                        )
                        Divider(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(1.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TopAppBar() {
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
    }
}

@Composable
private fun TabRowMenu(
    state: Int,
    stateChange: (Int) -> Unit
) {
    val titles = listOf("대상자 현황", "현금 지급", "신규자", "지급중지자")

    ScrollableTabRow(
        modifier = Modifier.width(540.dp),
        edgePadding = 0.dp,
        selectedTabIndex = state,
        containerColor = Color.White,
        contentColor = Color(0xFF2F68C2),
    ) {
        titles.forEachIndexed { index, title ->
            val textColor = if (state == index) Color(0xFF2F68C2) else Color.Black
            Tab(
                selected = state == index,
                onClick = {
                    stateChange(index)
                },
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

@Composable
private fun FieldTitle(list: List<String>) {
    Spacer(modifier = Modifier.height(36.dp))
    Row {
        list.forEachIndexed { index, it ->
            Text(
                modifier = Modifier
                    .background(
                        Color(0xFF2F68C2),
                        RoundedCornerShape(topStart = if (index == 0) 12.dp else 0.dp)
                    )
                    .width((it.length * 40).dp)
                    .height(56.dp)
                    .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
                text = it,
                color = Color.White,
                fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                fontSize = 16.sp,
            )
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
        }
    }
}

@Composable
private fun ExcelBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    width: Dp,
) {
    BasicTextField(value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
        maxLines = 1,
        textStyle = TextStyle(
            fontSize = 16.sp,
            fontFamily = FontFamily(
                Font(R.font.pretendard_regular),
            ),
            color = Color(0xFF262726),
        ),
        decorationBox = { innerTextField ->
            Row(
                modifier = Modifier
                    .background(color = Color.White)
                    .width(width)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E6E5),
                    )
                    .padding(all = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "",
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }
                innerTextField()
            }
        }
    )
}

@Composable
private fun ApplyButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val borderColor = if (isSelected) Color.Blue else Color.LightGray
    val textColor = if (isSelected) Color.Blue else Color.Gray
    val backgroundColor = if (borderColor == Color.Blue) Color(0xFFE6F2FF) else Color.White
    androidx.compose.material3.Button(
        colors = ButtonDefaults.buttonColors(backgroundColor),
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(
                width = 204.dp,
                height = 76.dp,
            )
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(8.dp),
            )
            .background(backgroundColor),
    ) {
        Text(
            text = title,
            color = textColor,
            fontSize = 16.sp,
        )
    }
    Spacer(modifier = Modifier.size(20.dp))
}