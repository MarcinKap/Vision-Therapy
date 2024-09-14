package com.example.data.client.di

import com.example.data.client.repository.ClientRepository
import com.example.data.client.repository.ClientRepositoryImpl
import com.example.data.workschedule.repository.WorkerRepository
import com.example.data.workschedule.repository.WorkerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface ClientBindingModule {
    @Binds
    fun bindClientRepository(
        implementation: ClientRepositoryImpl,
    ): ClientRepository
}