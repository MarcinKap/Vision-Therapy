package com.example.core.database.client

import com.example.core.coroutines.IO
import com.example.core.database.VisionTherapyDatabase
import com.example.core.model.Client
import com.example.core.model.Worker
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

internal class ClientRoomStorage @Inject constructor(
    private val db: VisionTherapyDatabase,
    @IO private val dispatcher: CoroutineDispatcher,
) : ClientStorage {

    override fun getAll() = db.clientDao()
        .getAll()
        .map { it.map(ClientEntity::toClient) }

    override suspend fun save(clients: List<Client>) = with(db) {
        val entities = withContext(dispatcher) { clients.map(Client::toClientEntity) }

        clientDao().insert(entities)
    }
}
