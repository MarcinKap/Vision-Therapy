package com.example.data.workschedule.usecase

import com.example.core.model.Worker
import com.example.data.workschedule.repository.WorkerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetWorkersUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    suspend fun invoke(): Flow<List<Worker>> {
        return workerRepository.getWorkers()
    }
}
