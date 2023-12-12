package com.example.yuseongallowancepaymentsandroid

import android.content.ContentValues.TAG
import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.yuseongallowancepaymentsandroid.data.Request.PinRequest
import com.example.yuseongallowancepaymentsandroid.data.api.ApiProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var token = ""
    fun loginWithPin(pin: String, sharedPreferences: SharedPreferences) {
        CoroutineScope(Dispatchers.IO).launch {
            kotlin.runCatching {
                ApiProvider.authApi().loginWithPin(
                    pinRequest = PinRequest(pin = pin)
                )
            }.onSuccess {
                token = it.accessToken
                sharedPreferences
                    .edit()
                    .putString("token", token)
                    .apply()
                Log.d("token", token)
            }.onFailure {
                Log.d(TAG, it.toString())
            }
        }
    }
}