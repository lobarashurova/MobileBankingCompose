package uz.mlsoft.mobilebankingcompose.data.request

data class RegisterVerifyRequest(
    val token: String,
    val code: String
)