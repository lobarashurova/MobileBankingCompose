package uz.mlsoft.mobilebankingcompose.presentation.verify

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.mlsoft.mobilebankingcompose.domain.AuthRepository
import javax.inject.Inject

@HiltViewModel
class VerifyViewModel @Inject constructor(
    val repository: AuthRepository
) : VerifyContract.ViewModel, ViewModel() {
    override fun onEventDispatcher(intent: VerifyContract.Intent) {
        when (intent) {

        }
    }

}