package com.example.navigation

import androidx.navigation.NavController
import com.example.feature.start.startscreen.StartNavigator
import com.ramcosta.composedestinations.navigation.navigate
import com.ramcosta.composedestinations.spec.NavGraphSpec
import com.ramcosta.composedestinations.utils.startDestination

@Suppress("TooManyFunctions")
class CommonNavGraphNavigator(
    private val navGraph: NavGraphSpec,
    private val navController: NavController,
) :
    StartNavigator {
    override fun showMainScreen() {
        navController.navigate(NavGraphs.therapies) {
            popUpTo(navGraph.startDestination.route) {
                inclusive = true
            }
        }
    }
}
