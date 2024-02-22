package uz.mlsoft.mobilebankingcompose.presentation.registration

import uz.mlsoft.mobilebankingcompose.presentation.home.HomeScreen
import uz.mlsoft.mobilebankingcompose.util.AppNavigator
import javax.inject.Inject


interface RegisterDirection {
    suspend fun moveToVerifyScreen()
    suspend fun moveToRegisterScreen()

}

class RegisterDirectionImpl @Inject constructor(val appNavigator: AppNavigator) : RegisterDirection {
    override suspend fun moveToVerifyScreen() {
        appNavigator.replaceScreen(HomeScreen())
    }

    override suspend fun moveToRegisterScreen() {
        appNavigator.addScreen(RegisterScreen())
    }

}