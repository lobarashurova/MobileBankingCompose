package uz.mlsoft.mobilebankingcompose.data.request

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    val phone: String,
    val password: String,
    @SerializedName("first-name")
    val firstName: String,
    @SerializedName("last-name")
    val lastName: String,
    @SerializedName("born-date")
    val bornDate: String,
    val gender: Int
)