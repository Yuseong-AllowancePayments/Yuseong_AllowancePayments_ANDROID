package com.example.yuseongallowancepaymentsandroid.data.Request

import com.google.gson.annotations.SerializedName

data class PinRequest(
    @SerializedName("pin") val pin: String,
)
