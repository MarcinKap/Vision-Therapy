package com.example.core.database.client

import com.example.core.model.Client
import com.example.core.model.Worker
import java.time.OffsetDateTime

internal fun ClientEntity.toClient(): Client {
    return Client(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        email = this.email,
        prescriptionNumber = this.prescriptionNumber,
        lastVisitDate = this.lastVisitDate,
        comments = this.comments,
    )
}

internal fun Client.toClientEntity(): ClientEntity {
    return ClientEntity(
        id = this.id,
        firstName = this.firstName,
        lastName = this.lastName,
        phoneNumber = this.phoneNumber,
        email = this.email,
        prescriptionNumber = this.prescriptionNumber,
        lastVisitDate = this.lastVisitDate,
        comments = this.comments
    )
}
