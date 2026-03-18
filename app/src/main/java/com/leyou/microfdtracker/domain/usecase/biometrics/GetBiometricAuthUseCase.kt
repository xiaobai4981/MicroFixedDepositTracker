package com.leyou.microfdtracker.domain.usecase.biometrics

import com.leyou.microfdtracker.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetBiometricAuthUseCase @Inject constructor(private val repository: PreferencesRepository){
    fun execute():Flow<Boolean> = repository.biometricAuth

}