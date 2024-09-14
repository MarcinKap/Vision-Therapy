package com.example.bottomnaviagtionbar

import com.example.bottomnaviagtionbar.ui.NavBarItem
import com.ramcosta.composedestinations.spec.NavGraphSpec

data class BottomNavigationDestination(
    val item: NavBarItem,
    val screen: NavGraphSpec,
)
