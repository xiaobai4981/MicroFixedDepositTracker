package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import javax.inject.Inject

class RescheduleAlarmUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    suspend fun execute() {
        repository.rescheduleAlarms()
    }
}