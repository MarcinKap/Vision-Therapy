package com.example.bottomnaviagtionbar

import com.example.navigation.NavGraphs
import com.example.bottomnaviagtionbar.ui.NavBarItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

internal interface NavigationElementComposer {
    fun composeAll(): Flow<List<BottomNavigationDestination>>
    fun composeFirstElement(): Flow<BottomNavigationDestination>
    fun composeSecondElement(): Flow<BottomNavigationDestination?>
    fun composeThirdElement(): Flow<BottomNavigationDestination?>
    fun composeFourthElement(): Flow<BottomNavigationDestination?>
    fun composeFifthElement(): Flow<BottomNavigationDestination?>
}

internal class BottomNavigationElementComposer @Inject constructor() : NavigationElementComposer {

    override fun composeAll(): Flow<List<BottomNavigationDestination>> =
        combine(
            composeFirstElement(),
            composeSecondElement(),
            composeThirdElement(),
            composeFourthElement(),
            composeFifthElement(),
        ) { first, second, third, fourth, fifth ->
            listOfNotNull(first, second, third, fourth, fifth)
        }

    override fun composeFirstElement(): Flow<BottomNavigationDestination> = flowOf(
        BottomNavigationDestination(
            item = NavBarItem.Home,
            screen = NavGraphs.therapies,
        ),
    )

    override fun composeSecondElement(): Flow<BottomNavigationDestination?> = flowOf(
        BottomNavigationDestination(
            item = NavBarItem.Customers,
            screen = NavGraphs.people,
        ),
    )

    override fun composeThirdElement(): Flow<BottomNavigationDestination?> = flowOf(
        BottomNavigationDestination(
            item = NavBarItem.Visits,
            screen = NavGraphs.visits,
        ),
    )

    override fun composeFourthElement(): Flow<BottomNavigationDestination?> = flowOf(
        BottomNavigationDestination(
            item = NavBarItem.Calendar,
            screen = NavGraphs.workSchedule,
        ),
    )

    override fun composeFifthElement(): Flow<BottomNavigationDestination?> = flowOf(
        BottomNavigationDestination(
            item = NavBarItem.Tasks,
            screen = NavGraphs.tasks,
        ),
    )
}
