package com.example.bottomnaviagtionbar.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

object BottomNavigationItemDefaults {
    @Composable
    fun colors(
        selectedIconColor: Color = MaterialTheme.colorScheme.primary,
        unselectedIconColor: Color = MaterialTheme.colorScheme.onSurface,
        selectedTextColor: Color = MaterialTheme.colorScheme.primary,
        unselectedTextColor: Color = MaterialTheme.colorScheme.onSurface,
        selectedContentColor: Color = Color.White,
        unselectedContentColor: Color = Color.White,
    ): BottomNavigationItemColors {
        return remember(
            selectedIconColor,
            unselectedIconColor,
            selectedTextColor,
            unselectedTextColor,
            selectedContentColor,
            unselectedContentColor,
        ) {
            DefaultBottomNavigationItemColors(
                selectedIconColor,
                unselectedIconColor,
                selectedTextColor,
                unselectedTextColor,
                selectedContentColor,
                unselectedContentColor,
            )
        }
    }
}

internal class DefaultBottomNavigationItemColors(
    private val selectedIconColor: Color,
    private val unselectedIconColor: Color,
    private val selectedTextColor: Color,
    private val unselectedTextColor: Color,
    private val selectedContentColor: Color,
    private val unselectedContentColor: Color,
) : BottomNavigationItemColors {

    @Composable
    override fun iconColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedIconColor
        } else {
            unselectedIconColor
        }

        return animateColorAsState(targetValue = target, label = "iconColor")
    }

    @Composable
    override fun textColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedTextColor
        } else {
            unselectedTextColor
        }

        return animateColorAsState(targetValue = target, label = "textColor")
    }

    @Composable
    override fun contentColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedContentColor
        } else {
            unselectedContentColor
        }

        return animateColorAsState(targetValue = target, label = "contentColor")
    }
}
