package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.repository.PreferencesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDynamicColorUseCase @Inject constructor(private val repository: PreferencesRepository) {
     fun execute(): Flow<Boolean> {
        return repository.dynamicColor
    }
}