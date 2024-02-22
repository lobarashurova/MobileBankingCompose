package uz.mlsoft.mobilebankingcompose.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.mlsoft.mobilebankingcompose.data.request.LoginRequest
import uz.mlsoft.mobilebankingcompose.data.request.LoginVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.response.LoginResponse
import uz.mlsoft.mobilebankingcompose.data.response.LoginVerifyResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterVerifyResponse

interface AuthApi {
    @POST("auth/sign-in")
    suspend fun loginUser(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("auth/sign-up")
    suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

    @POST("auth/sign-in/verify")
    suspend fun loginVerifyUser(@Body loginVerifyRequest: LoginVerifyRequest): Response<LoginVerifyResponse>

    @POST("auth/sign-up/verify")
    suspend fun registerVerifyUser(@Body registerVerifyRequest: RegisterVerifyRequest): Response<RegisterVerifyResponse>
}