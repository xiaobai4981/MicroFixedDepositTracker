package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import javax.inject.Inject

class DeleteAllFixedDepositsUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    suspend fun execute() {
        repository.deleteAllFixedDeposits()
    }
}