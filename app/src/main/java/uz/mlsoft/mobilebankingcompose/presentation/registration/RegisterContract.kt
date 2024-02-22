package uz.mlsoft.mobilebankingcompose.presentation.registration

interface RegisterContract {
    interface ViewModel {
        fun onEventDispatcher(intent: Intent)
    }


    interface Intent {
        data class RegisterUser(val name: String, val password: String) :Intent
    }
}