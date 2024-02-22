package uz.mlsoft.mobilebankingcompose.domain.impl

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import uz.mlsoft.mobilebankingcompose.data.MyShared
import uz.mlsoft.mobilebankingcompose.data.api.AuthApi
import uz.mlsoft.mobilebankingcompose.data.request.LoginRequest
import uz.mlsoft.mobilebankingcompose.data.request.LoginVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterRequest
import uz.mlsoft.mobilebankingcompose.data.request.RegisterVerifyRequest
import uz.mlsoft.mobilebankingcompose.data.response.LoginResponse
import uz.mlsoft.mobilebankingcompose.data.response.LoginVerifyResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterResponse
import uz.mlsoft.mobilebankingcompose.data.response.RegisterVerifyResponse
import uz.mlsoft.mobilebankingcompose.domain.AuthRepository
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val api: AuthApi,
    private val shared: MyShared
) : AuthRepository {
    override fun loginUser(loginRequest: LoginRequest): Flow<Result<LoginResponse>> = flow {
        val response = api.loginUser(loginRequest);
        if (response.isSuccessful && response.body() != null) {
            shared.token = response.body()?.token
            emit(Result.success(response.body()!!));
        }
    }

    override fun registerUser(registerRequest: RegisterRequest): Flow<Result<RegisterResponse>> =
        flow {
            val response = api.registerUser(registerRequest);
            if (response.isSuccessful && response.body() != null) {
                shared.token = response.body()?.token
                shared.isReg = true;
                emit(Result.success(response.body()!!));
            }
        }

    override fun loginVerify(loginVerifyRequest: LoginVerifyRequest): Flow<Result<LoginVerifyResponse>> =
        flow {
            val response = api.loginVerifyUser(loginVerifyRequest);
            if (response.isSuccessful && response.body() != null) {
                shared.isReg = false
                emit(Result.success(response.body()!!));

            }
        }

    override fun registerVerify(registerVerifyRequest: RegisterVerifyRequest): Flow<Result<RegisterVerifyResponse>> =
        flow {
            val response = api.registerVerifyUser(registerVerifyRequest);
            if (response.isSuccessful && response.body() != null) {
                emit(Result.success(response.body()!!));
            }
        }


}