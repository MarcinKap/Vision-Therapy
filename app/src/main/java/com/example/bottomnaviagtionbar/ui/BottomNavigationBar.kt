package com.example.bottomnaviagtionbar.ui

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.bottomnaviagtionbar.BottomNavigationDestination
import com.ramcosta.composedestinations.utils.navGraph

@Composable
fun BottomNavigationBar(
    items: List<BottomNavigationDestination>,
    navController: NavController,
    onClickItem: (BottomNavigationDestination) -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.White,
    elevation: Dp = BottomNavigationDefaults.Elevation,
) {
    val currentNavGraph = navController.currentBackStackEntryAsState().value?.navGraph()

    BottomNavigation(
        modifier = modifier,
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        elevation = elevation,
    ) {
        items.forEach {
            BottomNavigationItem(
                selected = it.screen == currentNavGraph,
                title = it.item.title,
                icon = it.item.icon,
                activeIcon = it.item.activeIcon,
                onClick = { onClickItem(it) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun BottomNavItemPreview() {
    MaterialTheme {
        BottomNavigation(backgroundColor = Color.White) {
            previewBottomNavItemList.forEachIndexed { _, data ->
                BottomNavigationItem(
                    selected = data.selected,
                    icon = data.icon,
                    activeIcon = data.activeIcon,
                    title = data.title,
                    onClick = { },
                )
            }
        }
    }
}
