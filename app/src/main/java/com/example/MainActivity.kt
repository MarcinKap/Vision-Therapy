package com.example

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.bottomnaviagtionbar.BottomNavigationDestination
import com.example.bottomnaviagtionbar.NavBarClickController
import com.example.bottomnaviagtionbar.NavBarVisibilityController
import com.example.bottomnaviagtionbar.ui.BottomNavigationBar
import com.example.core.design.shadow.BottomShadow
import com.example.core.design.theme.ExampleTheme
import com.example.feature.calendar.calendar.destinations.CalendarScreenDestination
import com.example.feature.customers.customers.destinations.CustomersScreenDestination
import com.example.feature.tasks.tasks.destinations.TasksScreenDestination
import com.example.feature.therapies.destinations.TherapySelectorScreenDestination
import com.example.feature.visits.visits.destinations.VisitsScreenDestination
import com.example.navigation.AppNavigation
import com.example.navigation.NavGraphs
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.navigation.popBackStack
import com.ramcosta.composedestinations.navigation.popUpTo
import com.ramcosta.composedestinations.utils.currentDestinationFlow
import com.ramcosta.composedestinations.utils.isRouteOnBackStack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.map

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var navController: NavHostController

    private val navBarVisibility: NavBarVisibilityController by lazy {
        NavBarVisibilityController(
            bottomNavigationRoutes = bottomNavigationRoutes,
            routeProvider = { navController.currentDestinationFlow.map { it.route } },
        )
    }

    @OptIn(
        ExperimentalMaterialApi::class,
        ExperimentalMaterialNavigationApi::class,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            CompositionLocalProvider {
                val sheetState = rememberModalBottomSheetState(
                    initialValue = ModalBottomSheetValue.Hidden,
                    skipHalfExpanded = true,
                    confirmValueChange = { newValue ->
                        when (newValue) {
                            ModalBottomSheetValue.Expanded -> true
                            ModalBottomSheetValue.HalfExpanded -> false
                            ModalBottomSheetValue.Hidden -> true
                        }
                    },
                )
                val bottomSheetNavigator = remember { BottomSheetNavigator(sheetState = sheetState) }
                navController = rememberNavController(bottomSheetNavigator)

                ExampleTheme {
                    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                    val currentNavigationItems by rememberUpdatedState(newValue = uiState.navigationBarItems)
                    val isNavBarVisible by navBarVisibility.isVisible().collectAsStateWithLifecycle(false)

                    Scaffold(
                        bottomBar = {
                            AnimatedVisibility(
                                visible = isNavBarVisible,
                                enter = expandVertically(expandFrom = Alignment.Top),
                                exit = shrinkVertically(shrinkTowards = Alignment.Top),
                            ) {
                                BottomNavigationBar(
                                    modifier = Modifier.height(56.dp),
                                    items = uiState.navigationBarItems,
                                    navController = navController,
                                    onClickItem = {
                                        NavBarClickController.onClick(it.item)
                                        navController.navigateToNavBarDestination(
                                            mainNavigationDestination = currentNavigationItems.first(),
                                            targetDestination = it,
                                        )
                                    },
                                )
                            }
                        },
                    ) { padding ->
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(padding),
                        ) {
                            AppNavigation(
                                navController = navController,
                                startRoute = NavGraphs.start,
                            )
                            BottomShadow(isNavBarVisible)
                        }
                    }
                }
            }
        }
    }

    private val bottomNavigationRoutes by lazy {
        listOf(
            CustomersScreenDestination routedIn NavGraphs.customers,
            VisitsScreenDestination routedIn NavGraphs.visits,
            CalendarScreenDestination routedIn NavGraphs.calendar,
            TasksScreenDestination routedIn NavGraphs.tasks,
            TherapySelectorScreenDestination routedIn NavGraphs.therapies,
        ).map { it.route }
    }

    private fun NavHostController.navigateToNavBarDestination(
        mainNavigationDestination: BottomNavigationDestination,
        targetDestination: BottomNavigationDestination,
    ) {
        val isCurrentDestOnBackStack = isRouteOnBackStack(targetDestination.screen)
        if (isCurrentDestOnBackStack) {
            popBackStack(targetDestination.screen.startRoute, inclusive = false)
            return
        }

        navigate(targetDestination.screen) {
            popUpTo(mainNavigationDestination.screen.startRoute) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
