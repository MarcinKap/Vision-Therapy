package com.example.core.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core.database.VisionTherapyDatabase.Companion.DB_VERSION

@Database(
    version = DB_VERSION,
    exportSchema = true,
    entities = [
    ]
)
internal abstract class VisionTherapyDatabase : RoomDatabase() {



    companion object {
        const val DB_VERSION = 13
    }
}