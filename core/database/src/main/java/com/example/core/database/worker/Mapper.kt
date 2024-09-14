package com.example.core.database.worker

import com.example.core.model.Worker
import java.time.OffsetDateTime

internal fun WorkerEntity.toWorker(): Worker {
    return Worker(
        id = this.id,
        name = this.name,
        surname = this.surname,
        position = this.position,
        createdAt = this.createdAt ?: OffsetDateTime.now(),
        startDate = this.startDate,
        endDate = this.endDate,
        email = this.email ?: "",
    )
}

internal fun Worker.toWorkerEntity(): WorkerEntity {
    return WorkerEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        position = this.position,
        createdAt = this.createdAt,
        startDate = this.startDate,
        endDate = this.endDate,
        email = this.email.takeIf { it.isNotEmpty() },
    )
}
