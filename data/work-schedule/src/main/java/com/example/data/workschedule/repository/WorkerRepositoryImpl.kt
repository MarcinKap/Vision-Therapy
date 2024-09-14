package com.example.data.workschedule.repository

import com.example.core.database.worker.WorkerStorage
import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class WorkerRepositoryImpl @Inject constructor(
    private val workerStorage: WorkerStorage,
) : WorkerRepository {
    override suspend fun getWorkers(): Flow<List<Worker>> {
        return workerStorage.getAll()
    }

    override suspend fun saveWorkers(workers: List<Worker>) {
        workerStorage.save(workers)
    }
}
