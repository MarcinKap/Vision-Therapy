package com.example

import com.example.bottomnaviagtionbar.BottomNavigationDestination

data class MainActivityUiState(
    val navigationBarItems: List<BottomNavigationDestination> = emptyList(),
)
