package uz.mlsoft.mobilebankingcompose.presentation.verify

import uz.mlsoft.mobilebankingcompose.presentation.home.HomeScreen
import uz.mlsoft.mobilebankingcompose.presentation.registration.RegisterScreen
import uz.mlsoft.mobilebankingcompose.util.AppNavigator
import javax.inject.Inject


interface VerifyDirection {
    suspend fun moveToVerifyScreen()
    suspend fun moveToRegisterScreen()

}

class VerifyDirectionImpl @Inject constructor(val appNavigator: AppNavigator) : VerifyDirection {
    override suspend fun moveToVerifyScreen() {
        appNavigator.replaceScreen(HomeScreen())
    }

    override suspend fun moveToRegisterScreen() {
        appNavigator.addScreen(RegisterScreen())
    }

}