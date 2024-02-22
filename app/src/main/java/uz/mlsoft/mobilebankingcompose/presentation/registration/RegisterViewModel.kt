package uz.mlsoft.mobilebankingcompose.presentation.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.mlsoft.mobilebankingcompose.data.request.RegisterRequest
import uz.mlsoft.mobilebankingcompose.domain.AuthRepository
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    val repository: AuthRepository,
    val direction: RegisterDirection
) : ViewModel(), RegisterContract.ViewModel {
    override fun onEventDispatcher(intent: RegisterContract.Intent) {
        when (intent) {
            is RegisterContract.Intent.RegisterUser -> {
                repository.registerUser(
                    RegisterRequest(
                        intent.name,
                        intent.password,
                        "lobar",
                        "ashurova",
                        "969822000000",
                        0
                    )
                ).onEach {
                    it.onSuccess {
                        direction.moveToVerifyScreen()
                    }
                }.launchIn(viewModelScope)
            }
        }
    }

}