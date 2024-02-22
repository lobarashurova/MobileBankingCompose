package uz.mlsoft.mobilebankingcompose.data.response

import com.google.gson.annotations.SerializedName

data class RegisterVerifyResponse(
    @SerializedName("access-token")
    val accessToken: String,
    @SerializedName("refresh-token")
    val refreshToken: String,
)