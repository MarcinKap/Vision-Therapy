package com.example.core.model

import java.time.LocalDate

data class Client(
    val id: String,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String,
    val email: String,
    val prescriptionNumber: String,
    val lastVisitDate: LocalDate,
    val comments: String? = null,
)
