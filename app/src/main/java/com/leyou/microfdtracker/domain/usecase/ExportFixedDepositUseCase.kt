package com.leyou.microfdtracker.domain.usecase

import android.util.Log
import com.leyou.microfdtracker.domain.repository.FixedDepositRepository
import com.leyou.microfdtracker.utils.DateUtils.toDateString
import kotlinx.coroutines.flow.firstOrNull
import javax.inject.Inject

class ExportFixedDepositUseCase @Inject constructor(private val repository: FixedDepositRepository) {
    suspend fun execute(): String {
        val fixedDeposits = repository.getAllFixedDeposits()
        val totalInvestedAmount = repository.getTotalInvestedAmount().firstOrNull()
        val totalMaturityAmount = repository.getTotalMaturityAmount().firstOrNull()
        val header = "Sr. No, ID, Bank Name, Principal Amount, Maturity Amount, Interest Rate, Start Date, Maturity Date, Notes, CreatedAt"
        val csvData = fixedDeposits.firstOrNull()?.mapIndexed { index, fd ->
            "${index + 1}, ${fd.id}, ${fd.bankName}, ${fd.principalAmount}, ${fd.maturityAmount}, ${fd.interestRate}, \"${fd.startDate.time.toDateString()}\", \"${fd.maturityDate.time.toDateString()}\", ${fd.notes}, \"${fd.createdAt.time.toDateString()}\""
        }?.joinToString(separator = "\n")
        val footer = "Invested Amount:, RS. $totalInvestedAmount, Maturity Amount:, RS. $totalMaturityAmount"
        Log.d("myapp", "CSV: $csvData")
        return "$header\n${csvData ?: ""}\n\n$footer"
    }
}