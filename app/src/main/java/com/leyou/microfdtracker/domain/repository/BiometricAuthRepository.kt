package com.leyou.microfdtracker.domain.repository

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.leyou.microfdtracker.domain.model.biometrics.AuthenticationResult
import com.leyou.microfdtracker.domain.model.biometrics.BiometricCheckResult
import kotlinx.coroutines.flow.Flow

interface BiometricAuthRepository {
    fun authenticateWithBiometrics(activity: FragmentActivity): Flow<AuthenticationResult>
    fun checkBiometricsAvailability(context: Context): Flow<BiometricCheckResult>
}