package uz.mlsoft.mobilebankingcompose.data.request

data class LoginVerifyRequest(
    val token: String,
    val code: String
)