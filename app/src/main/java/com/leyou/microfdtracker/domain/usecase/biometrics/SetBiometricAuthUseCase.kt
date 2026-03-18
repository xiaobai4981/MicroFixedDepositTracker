package com.leyou.microfdtracker.domain.usecase.biometrics

import com.leyou.microfdtracker.domain.repository.PreferencesRepository
import javax.inject.Inject

class SetBiometricAuthUseCase  @Inject constructor(private val repository: PreferencesRepository) {
    suspend fun execute(enabled:Boolean){
        repository.setBiometricAuth(enabled)
    }
}