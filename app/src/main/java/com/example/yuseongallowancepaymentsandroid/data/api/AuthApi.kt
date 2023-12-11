package com.example.yuseongallowancepaymentsandroid.data.api

import com.example.yuseongallowancepaymentsandroid.data.Request.PinRequest
import com.example.yuseongallowancepaymentsandroid.data.Response.PinResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {

    @POST("auth/token")
    suspend fun loginWithPin(
        @Body pinRequest: PinRequest
    ): PinResponse
}