package com.example.core.database.client

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.core.database.client.ClientEntity.Companion.TABLE_NAME
import java.time.LocalDate

@Entity(tableName = TABLE_NAME)
data class ClientEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: String,
    @ColumnInfo(name = "first_name")
    val firstName: String,
    @ColumnInfo(name = "last_name")
    val lastName: String,
    @ColumnInfo(name = "phone_number")
    val phoneNumber: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "prescription_number")
    val prescriptionNumber: String,
    @ColumnInfo(name = "last_visit_date")
    val lastVisitDate: LocalDate,
    @ColumnInfo(name = "comments")
    val comments: String? = null,
) {
    companion object {
        const val TABLE_NAME = "clients"
    }
}
