package com.example.data.workschedule.repository

import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow

interface WorkerRepository {
    suspend fun getWorkers(): Flow<List<Worker>>

    suspend fun saveWorkers(workers: List<Worker>)
}
