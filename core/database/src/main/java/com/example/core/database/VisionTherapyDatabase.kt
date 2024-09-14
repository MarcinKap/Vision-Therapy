package com.example.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core.database.VisionTherapyDatabase.Companion.DB_VERSION
import com.example.core.database.client.ClientDao
import com.example.core.database.client.ClientEntity
import com.example.core.database.worker.WorkerDao
import com.example.core.database.worker.WorkerEntity

@Database(
    version = DB_VERSION,
    exportSchema = true,
    entities = [
        WorkerEntity::class,
        ClientEntity::class,
    ],
)
@TypeConverters(Converters::class)
internal abstract class VisionTherapyDatabase : RoomDatabase() {

    abstract fun workerDao(): WorkerDao

    abstract fun clientDao(): ClientDao

    companion object {
        const val DB_VERSION = 1
    }
}
