package com.example.core.database

import com.example.core.database.client.ClientRoomStorage
import com.example.core.database.client.ClientStorage
import com.example.core.database.worker.WorkerRoomStorage
import com.example.core.database.worker.WorkerStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal interface StorageModule {

    @Binds
    fun bindWorkerStorage(storage: WorkerRoomStorage): WorkerStorage

    @Binds
    fun bindClientStorage(storage: ClientRoomStorage): ClientStorage
}
