package com.shantanubindhani.expensetracker.domain.usecase.write_datastore

import com.shantanubindhani.expensetracker.domain.repository.DatastoreRepository
import javax.inject.Inject

class EditOnBoardingUseCase @Inject constructor(private val datastoreRepository: DatastoreRepository) {
    suspend operator fun invoke(completed: Boolean) {
        datastoreRepository.writeOnboardingKeyToDataStore(completed)
    }
}