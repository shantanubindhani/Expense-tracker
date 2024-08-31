package com.shantanubindhani.expensetracker.domain.usecase.read_datastore

import com.shantanubindhani.expensetracker.domain.repository.DatastoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLimitKeyUseCase @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) {
    suspend operator fun invoke(): Flow<Boolean> {
        return datastoreRepository.readLimitKeyFromDataStore()
    }
}