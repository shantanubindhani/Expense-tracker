package com.shantanubindhani.expensetracker.domain.usecase.write_datastore

import com.shantanubindhani.expensetracker.domain.repository.DatastoreRepository
import javax.inject.Inject

class EraseDatastoreUseCase @Inject constructor(private val datastoreRepository: DatastoreRepository) {
    suspend operator fun invoke() {
        datastoreRepository.eraseDataStore()
    }
}