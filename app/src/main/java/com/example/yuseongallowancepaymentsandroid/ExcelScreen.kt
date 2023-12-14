package com.example.yuseongallowancepaymentsandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
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
fun ExcelScreen(
    navController: NavController,
) {
    var value by remember { mutableStateOf("") }
    var selectedButtonIndex by remember { mutableStateOf(0) }
    val buttonTitles = listOf("참전유공자 명예 수당", "참전유공자 배우자 수당", "보훈 예우 수당")


    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color.White)
        ) {
            MainTopAppBar(
                text = when (selectedButtonIndex) {
                    0 -> buttonTitles[0]
                    1 -> buttonTitles[1]
                    2 -> buttonTitles[2]
                    else -> {}
                } as String + " 지급 대상자 조회"
            )
            Column(modifier = Modifier.horizontalScroll(rememberScrollState())) {
                FieldTitle()
                for (i in 0..20) {
                    Field()
                }
            }
        }
        Box(
            modifier = Modifier.align(Alignment.BottomCenter),
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
                    .padding(
                        horizontal = 20.dp,
                        vertical = 12.dp,
                    )
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(24.dp),
                    )
                    .clip(RoundedCornerShape(24.dp))
                    .background(color = Color(0xFFFCFCFC))
                    .padding(12.dp),
            ) {
                buttonTitles.forEachIndexed { index, title ->
                    ApplyButton(
                        title = title,
                        isSelected = index == selectedButtonIndex,
                    ) {
                        selectedButtonIndex = index
                    }
                }
            }
        }
    }
}

@Composable
private fun MainTopAppBar(
    text: String,
) {
    Column(
        modifier = Modifier.padding(
            start = 30.dp,
            top = 60.dp,
            end = 30.dp,
        ),
    ) {
        Text(
            text = text,
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
        Row {
            TabRowMenu()
            androidx.compose.material3.Button(
                modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .padding(horizontal = 20.dp),
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(0xFF2F68C2)),
            ) {
                Text(
                    modifier = Modifier.align(Alignment.CenterVertically),
                    text = "엑셀파일 출력",
                    fontFamily = FontFamily(Font(R.font.pretendard_medium)),
                )
            }
        }
    }
}

@Composable
private fun TabRowMenu() {
    var state by remember { mutableStateOf(0) }
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

@Composable
private fun Field() {
    var number by remember { mutableStateOf("") }
    var administrativeBuilding by remember { mutableStateOf("") }
    var veteransAffairsNumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var birth by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp)
    ) {
        ExcelBasicTextField(
            value = number,
            onValueChange = { number = it },
            width = 100.dp,
            defaultText = "",
            backgroundColor = Color(0xFFFAFAFA)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        ExcelBasicTextField(
            value = administrativeBuilding,
            onValueChange = { administrativeBuilding = it },
            width = 160.dp,
            defaultText = "",
            backgroundColor = Color.White,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        ExcelBasicTextField(
            value = veteransAffairsNumber,
            onValueChange = { veteransAffairsNumber = it },
            width = 120.dp,
            defaultText = "",
            backgroundColor = Color.White,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        ExcelBasicTextField(
            value = name,
            onValueChange = { name = it },
            width = 100.dp,
            defaultText = "",
            backgroundColor = Color.White,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        ExcelBasicTextField(
            value = birth,
            onValueChange = { birth = it },
            width = 180.dp,
            defaultText = "",
            backgroundColor = Color.White,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        ExcelBasicTextField(
            value = address,
            onValueChange = { address = it },
            width = 400.dp,
            defaultText = "",
            backgroundColor = Color.White,
        )
    }
}

@Composable
private fun FieldTitle() {
    Spacer(modifier = Modifier.height(36.dp))
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp),
    ) {
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2), RoundedCornerShape(topStart = 12.dp))
                .width(100.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
            text = "연번",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2))
                .width(160.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
            text = "행정동",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2))
                .width(120.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
            text = "보훈번호",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2))
                .width(100.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
            text = "성명",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2))
                .width(180.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp)
                .align(Alignment.CenterVertically),
            text = "주민등록번호",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
        Text(
            modifier = Modifier
                .background(Color(0xFF2F68C2))
                .width(400.dp)
                .height(56.dp)
                .padding(start = 20.dp, top = 17.5.dp, bottom = 17.5.dp),
            text = "주소",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.pretendard_medium)),
            fontSize = 16.sp,
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(color = Color.White)
        )
    }
}

@Composable
private fun ExcelBasicTextField(
    value: String,
    onValueChange: (String) -> Unit,
    width: Dp,
    defaultText: String?,
    backgroundColor: Color,
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
                    .background(color = backgroundColor)
                    .width(width)
                    .border(
                        width = 1.dp,
                        color = Color(0xFFE5E6E5),
                    )
                    .padding(all = 16.dp), // inner padding
                verticalAlignment = Alignment.CenterVertically,
            ) {
                if (value.isEmpty()) {
                    Text(
                        text = "$defaultText",
                        fontSize = 16.sp,
                        color = Color.Black,
                    )
                }
                innerTextField()
            }
        })
}

@Composable
private fun ApplyButtonRow(
    selectedIndex: Int,
    onButtonSelected: (Int) -> Unit,
) {

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