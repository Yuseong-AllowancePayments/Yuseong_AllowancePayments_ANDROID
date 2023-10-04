package com.example.yuseongallowancepaymentsandroid

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var accountId by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(40.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.width(500.dp)) {
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
                    fontSize = 30.sp,
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
            Column {
                Spacer(modifier = Modifier.size(40.dp))
                Text(text = "아이디")
                OutlinedTextField(
                    value = accountId,
                    onValueChange = { accountId = it },
                    label = { Text(text = "아이디를 입력해주세요.") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.size(20.dp))
                Text(text = "비밀번호")
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text(text = "비밀번호를 입력해주세요.") },
                    modifier = Modifier.fillMaxWidth(),
                    visualTransformation = if (showPassword) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }, trailingIcon = {
                        if (showPassword) {
                            IconButton(onClick = { showPassword = false }) {
                                Icon(imageVector = Icons.Filled.Visibility, contentDescription = "visibility")
                            }
                        } else {
                            IconButton(onClick = { showPassword = true }) {
                                Icon(imageVector = Icons.Filled.VisibilityOff, contentDescription = "visibility")
                            }
                        }
                    }
                )
                Spacer(modifier = Modifier.size(40.dp))
                Button(
                    onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(Color(0xFF0F5EB8)),
                    modifier = Modifier
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
}