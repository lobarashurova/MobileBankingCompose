package uz.mlsoft.mobilebankingcompose.presentation.verify

interface VerifyContract {
    interface ViewModel {
        fun onEventDispatcher(intent: Intent)
    }


    interface Intent {
        data class VerifyRegisteruser(val code: String) : Intent
    }
}