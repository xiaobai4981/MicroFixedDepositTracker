package com.leyou.microfdtracker.data.local.mapper

import com.leyou.microfdtracker.data.local.entity.FixedDepositEntity
import com.leyou.microfdtracker.domain.model.FixedDeposit

fun FixedDeposit.toEntity(): FixedDepositEntity {
    return FixedDepositEntity(
        id = this.id,
        bankName = this.bankName,
        principalAmount = this.principalAmount,
        maturityAmount = this.maturityAmount,
        tenure = this.tenure,
        interestRate = this.interestRate,
        startDate = this.startDate,
        maturityDate = this.maturityDate,
        createdAt = this.createdAt,
        notes = this.notes
    )
}

fun FixedDepositEntity.toDomain(): FixedDeposit {
    return FixedDeposit(
        id = this.id,
        bankName = this.bankName,
        principalAmount = this.principalAmount,
        maturityAmount = this.maturityAmount,
        tenure = this.tenure,
        interestRate = this.interestRate,
        startDate = this.startDate,
        maturityDate = this.maturityDate,
        createdAt = this.createdAt,
        notes = this.notes
    )
}