package com.example.feature.therapies.therapyselector

import androidx.lifecycle.ViewModel
import com.example.core.coroutines.IO
import com.example.feature.therapies.therapyselector.preview.successDownloadedData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TherapySelectorViewModel @Inject constructor(
    @IO private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {

    private val _uiState = MutableStateFlow(TherapySelectorUiState())
    val uiState: StateFlow<TherapySelectorUiState> = _uiState.asStateFlow()

    private val uiStateValue: TherapySelectorUiState
        get() = uiState.value

    private val _navigationEventFlow =
        MutableStateFlow<TherapySelectorNavigationEvent>(TherapySelectorNavigationEvent.Idle)
    val navigationEventFlow: StateFlow<TherapySelectorNavigationEvent> = _navigationEventFlow

    init {
        _uiState.update {
            successDownloadedData
        }
    }

    internal fun onAction(action: TherapySelectorUiAction) {
        when (action) {
            is TherapySelectorUiAction.OpenSelector -> navigateTo(TherapySelectorNavigationEvent.OpenTherapySections)
        }
    }

    private fun navigateTo(event: TherapySelectorNavigationEvent) {
        _navigationEventFlow.value = event
    }

    internal fun onNavigationHandled() {
        navigateTo(TherapySelectorNavigationEvent.Idle)
    }
}
