package com.example.core.database.worker

import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow

interface WorkerStorage {
    fun getAll(): Flow<List<Worker>>

    suspend fun save(workers: List<Worker>)
}
