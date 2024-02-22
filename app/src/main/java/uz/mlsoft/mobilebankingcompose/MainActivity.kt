package uz.mlsoft.mobilebankingcompose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.mlsoft.mobilebankingcompose.presentation.login.LoginScreen
import uz.mlsoft.mobilebankingcompose.ui.theme.MobileBankingComposeTheme
import uz.mlsoft.mobilebankingcompose.util.AppNavigationHandler
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var navigationHandler: AppNavigationHandler

    @SuppressLint("CoroutineCreationDuringComposition", "FlowOperatorInvokedInComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileBankingComposeTheme {
                Navigator(screen = LoginScreen()) { navigate ->
                    LaunchedEffect(key1 = navigate) {
                        navigationHandler.uiNavigator
                            .onEach { it(navigate) }
                            .collect()
                    }
                    CurrentScreen()
                }
            }
        }
    }
}
