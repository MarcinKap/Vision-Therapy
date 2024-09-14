package com.example.feature.workschedule.workschedule

import com.example.core.model.Worker

data class WorkScheduleUiState(
    val workers: List<Worker> = emptyList(),
)
