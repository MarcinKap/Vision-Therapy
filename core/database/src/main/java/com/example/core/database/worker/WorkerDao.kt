package com.example.core.database.worker

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
internal interface WorkerDao {

    @Transaction
    @Query(FILTERED_WORKERS)
    fun getAll(): Flow<List<WorkerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(workers: List<WorkerEntity>)

    companion object {
        private const val WORKERS = WorkerEntity.TABLE_NAME

        private const val FILTERED_WORKERS =
            """
        SELECT *
        FROM $WORKERS
        ORDER BY
        id COLLATE UNICODE DESC
        """
    }
}
