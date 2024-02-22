package uz.mlsoft.mobilebankingcompose.data.response

import com.google.gson.annotations.SerializedName

data class LoginVerifyResponse(
    @SerializedName("access-token")
    val accessToken: String,
    @SerializedName("refresh-token")
    val refreshToken: String,
)