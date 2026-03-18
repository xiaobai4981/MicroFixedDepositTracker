package com.leyou.microfdtracker.data.repository

import android.content.Context
import androidx.fragment.app.FragmentActivity
import com.leyou.microfdtracker.data.biometrics.BiometricAuthenticator
import com.leyou.microfdtracker.data.biometrics.BiometricChecker
import com.leyou.microfdtracker.domain.model.biometrics.AuthenticationResult
import com.leyou.microfdtracker.domain.model.biometrics.BiometricCheckResult
import com.leyou.microfdtracker.domain.repository.BiometricAuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class BiometricAuthRepositoryImpl @Inject constructor (
    private val biometricChecker: BiometricChecker,
    private val biometricAuthenticator: BiometricAuthenticator
) : BiometricAuthRepository {

    override fun authenticateWithBiometrics(activity: FragmentActivity): Flow<AuthenticationResult> {
        return biometricAuthenticator.authenticate(activity)
    }

    override fun checkBiometricsAvailability(context: Context): Flow<BiometricCheckResult> = flow {
        emit(biometricChecker.checkAvailability(context))
    }
}