package com.example.bottomnaviagtionbar.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color

object BottomNavigationItemDefaults {
    @Composable
    fun colors(
        selectedIconColor: Color = Color.Magenta.copy(0.5f),
        unselectedIconColor: Color = Color.Black.copy(0.5f),
        selectedTextColor: Color = Color.Magenta.copy(0.5f),
        unselectedTextColor: Color = Color.Black.copy(0.5f),
        selectedContentColor: Color = Color.White,
        unselectedContentColor: Color = Color.White,
    ): BottomNavigationItemColors {
        return remember {
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
    val selectedIconColor: Color,
    val unselectedIconColor: Color,
    val selectedTextColor: Color,
    val unselectedTextColor: Color,
    val selectedContentColor: Color,
    val unselectedContentColor: Color,
) : BottomNavigationItemColors {

    @Composable
    override fun iconColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedIconColor
        } else {
            unselectedIconColor
        }

        return animateColorAsState(targetValue = target)
    }

    @Composable
    override fun textColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedTextColor
        } else {
            unselectedTextColor
        }

        return animateColorAsState(targetValue = target)
    }

    @Composable
    override fun contentColor(state: Boolean): State<Color> {
        val target = if (state) {
            selectedContentColor
        } else {
            unselectedContentColor
        }

        return animateColorAsState(targetValue = target)
    }
}