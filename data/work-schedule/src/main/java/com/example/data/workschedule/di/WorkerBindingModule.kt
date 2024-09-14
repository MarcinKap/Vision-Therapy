package com.example.data.workschedule.di

import com.example.data.workschedule.repository.WorkerRepository
import com.example.data.workschedule.repository.WorkerRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
internal interface WorkerBindingModule {

    @Binds
    fun bindWorkersRepository(
        implementation: WorkerRepositoryImpl,
    ): WorkerRepository
}
