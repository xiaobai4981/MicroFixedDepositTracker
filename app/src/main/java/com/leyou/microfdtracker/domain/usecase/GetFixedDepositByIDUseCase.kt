package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.model.FixedDeposit
import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFixedDepositByIDUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    fun execute(id: Int): Flow<FixedDeposit?> = repository.getFixedDepositById(id)
}