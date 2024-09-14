package com.example.core.database.client

import com.example.core.model.Client
import com.example.core.model.Worker
import kotlinx.coroutines.flow.Flow

interface ClientStorage {
    fun getAll(): Flow<List<Client>>

    suspend fun save(clients: List<Client>)
}
