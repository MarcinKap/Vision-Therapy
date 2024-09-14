package com.example.core.database.worker

import androidx.paging.PagingSource
import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow

interface WorkerStorage {
    fun getAll(): List<Worker>

    suspend fun save(workers: List<Worker>)
}
