package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.model.FixedDeposit
import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import javax.inject.Inject

class UpdateFixedDepositUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    suspend fun execute(fixedDeposit: FixedDeposit) {
        repository.updateFixedDeposit(fixedDeposit)
    }
}