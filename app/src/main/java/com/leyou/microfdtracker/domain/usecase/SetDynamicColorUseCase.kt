package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.repository.PreferencesRepository
import javax.inject.Inject

class SetDynamicColorUseCase @Inject constructor(private val repository: PreferencesRepository) {
    suspend fun execute(enabled: Boolean) {
        repository.setDynamicColor(enabled)
    }
}