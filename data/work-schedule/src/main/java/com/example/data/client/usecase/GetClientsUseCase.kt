package com.example.data.client.usecase

import com.example.core.model.Client
import com.example.core.model.Worker
import com.example.data.client.repository.ClientRepository
import com.example.data.workschedule.repository.WorkerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetClientsUseCase @Inject constructor(private val clientRepository: ClientRepository) {
    suspend fun invoke(): Flow<List<Client>> {
        return clientRepository.getClients()
    }
}
