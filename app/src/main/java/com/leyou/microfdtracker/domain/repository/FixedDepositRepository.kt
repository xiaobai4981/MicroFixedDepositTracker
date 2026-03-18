package com.leyou.microfdtracker.domain.repository

import com.leyou.microfdtracker.domain.model.FixedDeposit
import kotlinx.coroutines.flow.Flow

interface FixedDepositRepository {
    suspend fun addFixedDeposit(fixedDeposit: FixedDeposit): Long
    fun getFixedDepositById(id: Int): Flow<FixedDeposit?>
    fun getAllFixedDeposits(): Flow<List<FixedDeposit>>
    suspend fun updateFixedDeposit(fixedDeposit: FixedDeposit)
    fun getTotalInvestedAmount(): Flow<Double>
    fun getTotalMaturityAmount(): Flow<Double>
    suspend fun deleteFixedDeposit(id: Int)

    suspend fun deleteAllFixedDeposits()

    suspend fun rescheduleAlarms()
}