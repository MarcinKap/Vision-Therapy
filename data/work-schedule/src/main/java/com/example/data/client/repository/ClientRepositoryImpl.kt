package com.example.data.client.repository

import com.example.core.database.client.ClientStorage
import com.example.core.model.Client
import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class ClientRepositoryImpl @Inject constructor(
    private val clientStorage: ClientStorage,
) : ClientRepository {
    override suspend fun getClients(): Flow<List<Client>> {
        return clientStorage.getAll()
    }

    override suspend fun saveClients(clients: List<Client>) {
        clientStorage.save(clients)
    }
}
