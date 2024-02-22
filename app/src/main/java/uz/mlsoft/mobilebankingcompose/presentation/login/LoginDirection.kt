package uz.mlsoft.mobilebankingcompose.presentation.login

import uz.mlsoft.mobilebankingcompose.presentation.registration.RegisterScreen
import uz.mlsoft.mobilebankingcompose.presentation.verify.VerifyScreen
import uz.mlsoft.mobilebankingcompose.util.AppNavigator
import javax.inject.Inject

interface LoginDirection {
    suspend fun moveToVerifyScreen()
    suspend fun moveToRegisterScreen()

}

class LoginDirectionImpl @Inject constructor(val appNavigator: AppNavigator) : LoginDirection {
    override suspend fun moveToVerifyScreen() {
        appNavigator.replaceScreen(VerifyScreen())
    }

    override suspend fun moveToRegisterScreen() {
        appNavigator.addScreen(RegisterScreen())
    }

}