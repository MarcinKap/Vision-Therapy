package com.example.core.database

import androidx.room.TypeConverter
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.OffsetDateTime

internal object Converters {

    @TypeConverter
    fun offsetDateTimeToString(dateTime: OffsetDateTime): String =
        dateTime.toString()

    @TypeConverter
    fun stringToOffsetDateTime(dateTimeString: String): OffsetDateTime =
        OffsetDateTime.parse(dateTimeString)

    @TypeConverter
    fun localDateToString(date: LocalDate): String =
        date.toString()

    @TypeConverter
    fun stringToLocalDate(dateString: String): LocalDate =
        LocalDate.parse(dateString)

    @TypeConverter
    fun localDateTimeToString(dateTime: LocalDateTime): String =
        dateTime.toString()

    @TypeConverter
    fun stringToLocalDateTime(dateTimeString: String): LocalDateTime =
        LocalDateTime.parse(dateTimeString)

    @TypeConverter
    fun localTimeToString(time: LocalTime): String =
        time.toString()

    @TypeConverter
    fun stringToLocalTime(timeString: String): LocalTime =
        LocalTime.parse(timeString)

    @TypeConverter
    fun listToString(list: List<String>): String =
        list.joinToString(separator = SEPARATOR)

    @TypeConverter
    fun stringToList(string: String): List<String> =
        string.split(SEPARATOR)

    private const val SEPARATOR = "||"
}