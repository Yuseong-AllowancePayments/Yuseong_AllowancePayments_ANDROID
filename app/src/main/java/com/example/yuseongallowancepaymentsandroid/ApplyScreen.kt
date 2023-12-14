package com.example.yuseongallowancepaymentsandroid

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.yuseongallowancepaymentsandroid.navigation.AppNavigationItem

@Composable
fun ApplyScreen(navController: NavController) {
    var selectedButtonIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp), contentAlignment = Alignment.Center
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(
                    text = "참전유공자 명예 수당 지급 신청서 작성",
                    modifier = Modifier.height(height = 50.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Start
                )
                Button(
                    onClick = {
                        navController.navigate(AppNavigationItem.Login.route) { popUpTo(0) }
                    },
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .width(140.dp)
                        .height(50.dp)
                        .background(Color(0xFFF2F0F5))
                        .align(Alignment.BottomEnd),
                    colors = ButtonDefaults.buttonColors(Color(0xFFF2F0F5))
                ) {
                    Text(text = "담당자 로그인", color = Color.Black)
                }
            }
            Spacer(modifier = Modifier.size(20.dp))
            Text(text = "신청하실 수당 유형을 검색해 주세요")
            Spacer(modifier = Modifier.size(60.dp))
            ApplyButtonsRow(selectedButtonIndex) { newIndex ->
                selectedButtonIndex = newIndex
            }
            Spacer(modifier = Modifier.size(50.dp))
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(Color(0xFF0F5EB8)),
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .width(200.dp)
                    .height(42.dp)
                    .align(Alignment.CenterHorizontally)
                    .background(Color(0xFF0F5EB8)),
            ) {
                Text(text = "선택")
            }
        }
    }
}

@Composable
fun ApplyButtonsRow(
    selectedIndex: Int,
    onButtonSelected: (Int) -> Unit,
) {
    val buttonTitles = listOf("참전유공자 명예 수당", "참전유공자 배우자 수당", "보훈 예우 수당")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
    ) {
        buttonTitles.forEachIndexed { index, title ->
            ApplyButton(
                title = title,
                isSelected = index == selectedIndex,
            ) {
                onButtonSelected(index)
            }
        }
    }
}

@Composable
fun ApplyButton(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val borderColor = if (isSelected) Color.Blue else Color.LightGray
    val backgroundColor = if (borderColor == Color.Blue) Color(0xFFE6F2FF) else Color.White
    Button(
        colors = ButtonDefaults.buttonColors(backgroundColor),
        onClick = onClick,
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .size(214.dp, 100.dp)
            .border(
                width = 1.dp, color = borderColor, shape = RoundedCornerShape(8.dp)
            )
            .background(backgroundColor),
    ) {
        Text(
            text = title,
            color = borderColor,
            fontSize = 16.sp
        )
    }
    Spacer(modifier = Modifier.size(20.dp))
}
