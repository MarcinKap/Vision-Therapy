package com.example.core.database.worker

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.OffsetDateTime

@Entity(
    tableName = WorkerEntity.TABLE_NAME,
)
internal data class WorkerEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("surname")
    val surname: String,
    @ColumnInfo("position")
    val position: String,
    @ColumnInfo("created_at")
    val createdAt: OffsetDateTime?,
    @ColumnInfo("start_date")
    val startDate: LocalDate,
    @ColumnInfo("end_date")
    val endDate: LocalDate?,
    @ColumnInfo("email")
    val email: String?,
) {
    companion object {
        const val TABLE_NAME = "workers"
    }
}
