package com.example.core.model

import java.time.LocalDate
import java.time.OffsetDateTime

data class Worker(
    val id: String,
    val name: String,
    val surname: String,
    val position: String,
    val createdAt: OffsetDateTime,
    val startDate: LocalDate,
    val endDate: LocalDate?,
    val email: String,
)