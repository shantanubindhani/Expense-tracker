package com.shantanubindhani.expensetracker.domain.usecase.read_datastore

import com.shantanubindhani.expensetracker.domain.repository.DatastoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLimitDurationUseCase @Inject constructor(
    private val datastoreRepository: DatastoreRepository
) {
    suspend operator fun invoke(): Flow<Int> {
        return datastoreRepository.readLimitDurationFromDataStore()
    }
}