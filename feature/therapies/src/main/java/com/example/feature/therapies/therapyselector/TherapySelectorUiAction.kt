package com.example.feature.therapies.therapyselector

internal sealed interface TherapySelectorUiAction {
    data class OpenSelector(val id: String) : TherapySelectorUiAction
}
