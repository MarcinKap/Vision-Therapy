package com.example.bottomnaviagtionbar

import com.example.bottomnaviagtionbar.ui.NavBarItem
import kotlinx.coroutines.flow.MutableSharedFlow

object NavBarClickController {
    private val clicksFlow = MutableSharedFlow<NavBarItem>(extraBufferCapacity = 1)

    fun onClick(item: NavBarItem) {
        clicksFlow.tryEmit(item)
    }

    suspend fun collect(collector: (NavBarItem) -> Unit) {
        clicksFlow.collect { collector(it) }
    }
}
