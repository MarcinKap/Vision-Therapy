package com.example.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import com.example.errors.UnknownNavGraphException
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.DependenciesContainerBuilder
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.spec.Route

@OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialNavigationApi::class)
@Composable
internal fun AppNavigation(
    navController: NavHostController,
    startRoute: Route,
    modifier: Modifier = Modifier,
) {
    DestinationsNavHost(
        engine = rememberAnimatedNavHostEngine(),
        navController = navController,
        navGraph = NavGraphs.root,
        startRoute = startRoute,
        modifier = modifier
            .background(Color.LightGray.copy(0.2f)),
        dependenciesContainerBuilder = {
            dependency(currentNavigator())
        },
    )
}

fun DependenciesContainerBuilder<*>.currentNavigator(): CommonNavGraphNavigator {
    return CommonNavGraphNavigator(
        navBackStackEntry.destination.navGraph(),
        navController,
    )
}

fun NavDestination.navGraph(): NavGraphSpec {
    hierarchy.forEach { destination ->
        NavGraphs.root.nestedNavGraphs.forEach { navGraph ->
            if (destination.route == navGraph.route) {
                return navGraph
            }
        }
    }
    throw UnknownNavGraphException()
}
