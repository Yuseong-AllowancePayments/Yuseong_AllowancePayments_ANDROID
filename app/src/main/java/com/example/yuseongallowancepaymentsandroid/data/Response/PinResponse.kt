package com.example.yuseongallowancepaymentsandroid.data.Response

import com.google.gson.annotations.SerializedName

data class PinResponse(
    @SerializedName("access_token") val accessToken: String,
    @SerializedName("refresh_token") val refreshToken: String,
    @SerializedName("access_token_exp") val accessTokenExp: String,
)
