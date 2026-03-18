package com.leyou.microfdtracker.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.leyou.microfdtracker.presentation.theme.FDTrackerTheme
import com.leyou.microfdtracker.presentation.ui.add.AddFixedDepositViewModel
import com.leyou.microfdtracker.presentation.ui.settings.ThemeViewModel
import androidx.fragment.app.FragmentActivity
import com.leyou.microfdtracker.domain.model.biometrics.BiometricAuthState

@AndroidEntryPoint
class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        actionBar?.hide()
        val shortcutId = intent.getStringExtra("shortcut_id")
        val fdID = intent.getIntExtra("fdID", -1)
        setContent {
            val viewModel: ThemeViewModel = hiltViewModel()
            val biometricViewModel: BiometricViewModel = hiltViewModel()

            val dynamicColor by viewModel.dynamicColor.collectAsState()
            val darkMode by viewModel.darkMode.collectAsState()

            val hasAuthenticated by biometricViewModel.hasAuthenticated.collectAsState()
            val biometricAuthState by biometricViewModel
                .biometricAuthState
                .collectAsState(BiometricAuthState.LOADING)
            val biometricAuthResult by biometricViewModel.authResult.collectAsState()

            LaunchedEffect(biometricAuthState) {

                if (biometricAuthState == BiometricAuthState.ENABLED) {
                    biometricViewModel.authenticate(this@MainActivity)
                }
            }

            biometricViewModel.handleBiometricAuth(biometricAuthResult, this)

            FDTrackerTheme(
                darkTheme = darkMode, dynamicColor = dynamicColor
            ) {
                FixedDepositApp(shortcutId, hasAuthenticated, fdID)
            }


        }
    }
}

@Composable
fun AddFixedDeposit(viewModel: AddFixedDepositViewModel = hiltViewModel()) {
    val context = LocalContext.current as MainActivity
    LaunchedEffect(key1 = Unit) {
        val intent = context.intent
        val shortcutId = intent.getStringExtra("shortcut_id")
        Log.d("myapp", "shortcutId id is $shortcutId")
    }
//    LaunchedEffect(key1 = Unit) {
//        val intent = context.intent
//        val fdID = intent.getIntExtra("fdID", -1)
//        Log.d("myapp", "From FD Notification, id is $fdID")
//    }
//    LaunchedEffect(key1 = Unit) {
//        val calendar =  Calendar.getInstance()
//        calendar.add(Calendar.SECOND, 20)
//        Log.d("myapp", "${Calendar.getInstance().time} Future Time is ${calendar.time}")
//        viewModel.addFixedDeposit(
//            FixedDeposit(
//                0,
//                5500.0,
//                19,
//                6.1,
//                Date(),
//                calendar.time,
//                "remind me"
//            )
//        )
//    }
}