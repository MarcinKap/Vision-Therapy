package com.example.feature.workschedule.workschedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.coroutines.IO
import com.example.core.model.Worker
import com.example.data.workschedule.usecase.GetWorkersUseCase
import com.example.data.workschedule.usecase.SaveWorkerUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.OffsetDateTime
import javax.inject.Inject

@HiltViewModel
class WorkScheduleViewModel @Inject constructor(
    private val getWorkersUseCase: GetWorkersUseCase,
    private val saveWorkerUseCase: SaveWorkerUseCase,
    @IO private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState = MutableStateFlow(WorkScheduleUiState())
    val uiState: StateFlow<WorkScheduleUiState> = _uiState.asStateFlow()

    private val uiStateValue: WorkScheduleUiState
        get() = uiState.value

    init {
        viewModelScope.launch(ioDispatcher) {
            saveWorkerUseCase.invoke(
                listOf(
                    Worker(
                        id = "1",
                        name = "name",
                        surname = "surname",
                        position = "position",
                        createdAt = OffsetDateTime.now(),
                        startDate = LocalDate.now(),
                        endDate = null,
                        email = "email",
                    ),
                ),
            )
        }

        collectWorkers()
    }

    private fun collectWorkers() {
        viewModelScope.launch(ioDispatcher) {
            getWorkersUseCase.invoke().collect {
                _uiState.value = uiStateValue.copy(workers = it)
            }
        }
    }
}
