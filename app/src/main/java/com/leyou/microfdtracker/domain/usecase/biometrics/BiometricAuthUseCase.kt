package com.leyou.microfdtracker.domain.usecase.biometrics

import androidx.fragment.app.FragmentActivity
import com.leyou.microfdtracker.domain.model.biometrics.AuthenticationResult
import com.leyou.microfdtracker.domain.repository.BiometricAuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class BiometricAuthUseCase @Inject constructor (private val repository: BiometricAuthRepository) {
    fun execute(context:FragmentActivity): Flow<AuthenticationResult> {
        return repository.authenticateWithBiometrics(context)
    }
}