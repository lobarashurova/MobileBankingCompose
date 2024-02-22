package uz.mlsoft.mobilebankingcompose.domain

import kotlinx.coroutines.flow.Flow
import uz.mlsoft.mobilebankingcompose.data.request.LoginRequest
import uz.mlsoft.mobilebankingcompose.data.request.LoginVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.response.LoginResponse
import uz.mlsoft.mobilebankingcompose.data.response.LoginVerifyResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterVerifyResponse

interface AuthRepository {
    fun loginUser(loginRequest: LoginRequest): Flow<Result<LoginResponse>>
    fun registerUser(registerRequest: RegisterRequest): Flow<Result<RegisterResponse>>
    fun loginVerify(loginVerifyRequest: LoginVerifyRequest): Flow<Result<LoginVerifyResponse>>
    fun registerVerify(registerVerifyRequest: RegisterVerifyRequest): Flow<Result<RegisterVerifyResponse>>

}