package com.example.data.client.repository

import com.example.core.model.Client
import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow

interface ClientRepository {
    suspend fun getClients(): Flow<List<Client>>

    suspend fun saveClients(clients: List<Client>)
}
