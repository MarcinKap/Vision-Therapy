package com.example.feature.therapies.therapyselector

sealed interface TherapySelectorNavigationEvent {
    data object Idle : TherapySelectorNavigationEvent
    data object OpenTherapySections : TherapySelectorNavigationEvent
}
