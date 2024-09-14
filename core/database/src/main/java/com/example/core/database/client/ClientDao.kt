package com.example.core.database.client

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.core.database.worker.WorkerEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface ClientDao {

    @Transaction
    @Query(FILTERED_CLIENTS)
    fun getAll(): Flow<List<ClientEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clients: List<ClientEntity>)

    companion object {
        private const val CLIENTS = ClientEntity.TABLE_NAME

        private const val FILTERED_CLIENTS =
            """
        SELECT *
        FROM $CLIENTS
        ORDER BY
        id COLLATE UNICODE DESC
        """
    }
}