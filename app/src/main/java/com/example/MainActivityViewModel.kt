package com.example

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bottomnaviagtionbar.NavigationElementComposer
import com.example.core.coroutines.IO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class MainActivityViewModel @Inject constructor(
    private val bottomNavigationElementComposer: NavigationElementComposer,
    @IO private val ioDispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val _uiState = MutableStateFlow(MainActivityUiState())
    val uiState: StateFlow<MainActivityUiState> = _uiState.asStateFlow()

    init {
        fetchNavigationItems()
    }

    private fun fetchNavigationItems() = viewModelScope.launch {
        bottomNavigationElementComposer.composeAll()
            .flowOn(ioDispatcher)
            .collectLatest { destinations ->
                _uiState.update { state ->
                    state.copy(navigationBarItems = destinations)
                }
            }
    }
}
