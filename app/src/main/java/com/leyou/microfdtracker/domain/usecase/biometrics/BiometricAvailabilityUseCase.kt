package com.leyou.microfdtracker.domain.usecase.biometrics

import android.content.Context
import com.leyou.microfdtracker.domain.model.biometrics.BiometricCheckResult
import com.leyou.microfdtracker.domain.repository.BiometricAuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BiometricAvailabilityUseCase @Inject constructor (private val context: Context,private val repository: BiometricAuthRepository) {
    fun execute (): Flow<BiometricCheckResult> {
        return repository.checkBiometricsAvailability(context)
    }
}