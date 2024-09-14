package com.example.data.workschedule.usecase

import com.example.core.model.Worker
import com.example.data.workschedule.repository.WorkerRepository
import javax.inject.Inject

class SaveWorkerUseCase @Inject constructor(private val workerRepository: WorkerRepository) {
    suspend fun invoke(workers: List<Worker>) {
        return workerRepository.saveWorkers(workers)
    }
}
