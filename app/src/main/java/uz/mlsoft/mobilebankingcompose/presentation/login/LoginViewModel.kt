package uz.mlsoft.mobilebankingcompose.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import uz.mlsoft.mobilebankingcompose.data.request.LoginRequest
import uz.mlsoft.mobilebankingcompose.domain.AuthRepository
import uz.mlsoft.myprivatemaxway.presentation.login.LoginContract
import javax.inject.Inject


@HiltViewModel
class LoginViewModel @Inject constructor(
    val repository: AuthRepository,
    val direction: LoginDirection
) : LoginContract.ViewModel,
    ViewModel() {
    override fun onEventDispatcher(intent: LoginContract.Intent) {
        when (intent) {
            is LoginContract.Intent.LoginUser -> {
                viewModelScope.launch {
                    val response = repository.loginUser(LoginRequest(intent.name, intent.password))
                    response.onEach {
                        it.onSuccess {
                            direction.moveToVerifyScreen()
                        }
                    }.launchIn(viewModelScope)
                }
            }
        }
    }
}
