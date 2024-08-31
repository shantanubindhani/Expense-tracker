package com.shantanubindhani.expensetracker.domain.usecase.read_database

import com.shantanubindhani.expensetracker.data.local.entity.TransactionDto
import com.shantanubindhani.expensetracker.domain.repository.TransactionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastMonthTransaction @Inject constructor(
    private val transactionRepository: TransactionRepository
) {
    operator fun invoke(transactionType: String) : Flow<List<TransactionDto>> {
        return transactionRepository.getLastMonthTransaction(transactionType)
    }
}