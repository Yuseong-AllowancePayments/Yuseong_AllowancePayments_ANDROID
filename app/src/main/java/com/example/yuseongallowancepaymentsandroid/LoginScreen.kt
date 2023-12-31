package com.example.yuseongallowancepaymentsandroid

import android.content.Context
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.yuseongallowancepaymentsandroid.navigation.AppNavigationItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("my_shared_prefs", Context.MODE_PRIVATE)
    val loginViewModel: LoginViewModel = viewModel()
    var pin by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        contentAlignment = Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
        ) {
            Row(Modifier.padding(16.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.img_logo),
                    contentDescription = "logo"
                )
                Text(
                    text = "유성구 보훈수당 관리 서비스",
                    modifier = Modifier
                        .height(height = 50.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.size(50.dp))
            Text(
                text = "담당자 로그인",
                modifier = Modifier
                    .height(height = 50.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp,
                textAlign = TextAlign.Start
            )
            Text(
                text = "관리자 인증 PIN 번호를 입력해주세요.",
                fontSize = 14.sp,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(bottom = 72.dp)
            )
            BasicTextField(
                value = pin,
                onValueChange = {
                    if (pin.length < 4) pin = it
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            ) {
                FlowRow(modifier = Modifier.fillMaxWidth()) {
                    for (i in 0..pin.length - 1) {
                        Box(modifier = Modifier.weight(1f)) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF6B6B6B))
                                    .align(Center)
                            )
                        }
                    }
                    for (i in 0..3 - pin.length) {
                        Box(modifier = Modifier.weight(1f)) {
                            Box(
                                modifier = Modifier
                                    .size(28.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFFBFC0BF))
                                    .align(Center)
                            )
                        }
                    }
                }
            }
            Button(
                onClick = {
                    Log.d("pin", pin)
                    loginViewModel.loginWithPin(pin, sharedPreferences)
                    navController.navigate(AppNavigationItem.Excel.route) { popUpTo(0) }
                },
                colors = ButtonDefaults.buttonColors(Color(0xFF0F5EB8)),
                modifier = Modifier
                    .padding(top = 72.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .background(Color(0xFF0F5EB8)),
            ) {
                Text(text = "로그인")
            }
        }
    }
}