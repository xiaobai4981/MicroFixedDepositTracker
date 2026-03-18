package com.leyou.microfdtracker.domain.usecase

import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTotalMaturityAmountUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    fun execute(): Flow<Double> = repository.getTotalMaturityAmount()
}