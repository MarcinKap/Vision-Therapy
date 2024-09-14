package com.example.data.client.usecase

import com.example.core.model.Client
import com.example.data.client.repository.ClientRepository
import javax.inject.Inject

class SaveClientsUseCase @Inject constructor(private val clientRepository: ClientRepository) {
    suspend fun invoke(workers: List<Client>) {
        return clientRepository.saveClients(workers)
    }
}
