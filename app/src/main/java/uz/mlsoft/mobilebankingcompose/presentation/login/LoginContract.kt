package uz.mlsoft.myprivatemaxway.presentation.login

interface LoginContract {
    interface ViewModel {
        fun onEventDispatcher(intent: Intent)
    }


    interface Intent {
        data class LoginUser(val name: String, val password: String):Intent
    }
}