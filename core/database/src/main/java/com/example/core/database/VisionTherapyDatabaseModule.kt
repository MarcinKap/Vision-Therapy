package com.example.core.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Suppress("SpreadOperator")
@Module
@InstallIn(SingletonComponent::class)
internal object VisionTherapyDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): VisionTherapyDatabase =
        Room.databaseBuilder(context, VisionTherapyDatabase::class.java, "companies-db.db")
            .fallbackToDestructiveMigration()
            .build()
}
