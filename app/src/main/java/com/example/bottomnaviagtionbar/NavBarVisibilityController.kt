package com.example.bottomnaviagtionbar

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class NavBarVisibilityController(
    bottomNavigationRoutes: Collection<String>,
    private val routeProvider: () -> Flow<String>,
) : NavBarVisibility {
    private val visibleRoutesFlow = MutableStateFlow(bottomNavigationRoutes.toSet())
    private var currentRoute: String? = null

    fun isVisible(): Flow<Boolean> =
        combine(
            visibleRoutesFlow,
            routeProvider.invoke().onEach { currentRoute = it },
        ) { visibleRoutes, currentRoute -> visibleRoutes.contains(currentRoute) }
            .distinctUntilChanged()

    override fun show() {
        currentRoute?.let { route ->
            visibleRoutesFlow.update { it + route }
        }
    }

    override fun hide() {
        currentRoute?.let { route ->
            visibleRoutesFlow.update { it - route }
        }
    }
}
