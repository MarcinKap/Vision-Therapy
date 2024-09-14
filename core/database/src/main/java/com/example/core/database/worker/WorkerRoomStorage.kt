package com.example.core.database.worker

import com.example.core.coroutines.IO
import com.example.core.database.VisionTherapyDatabase
import com.example.core.model.Worker
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class WorkerRoomStorage @Inject constructor(
    private val db: VisionTherapyDatabase,
    @IO private val dispatcher: CoroutineDispatcher,
) : WorkerStorage {

    override fun getAll() = db.workerDao()
        .getAll()
        .map { it.map(WorkerEntity::toWorker) }

    override suspend fun save(workers: List<Worker>) = with(db) {
        val entities = withContext(dispatcher) { workers.map(Worker::toWorkerEntity) }

        workerDao().insert(entities)
    }
}
