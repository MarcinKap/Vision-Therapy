package com.example.bottomnaviagtionbar.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.R
import com.example.core.design.R.drawable as DS

sealed class NavBarItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    @DrawableRes val activeIcon: Int,
) {
    data object Home : NavBarItem(
        title = R.string.root_home,
        icon = DS.outline_home_24,
        activeIcon = DS.baseline_home_24,
    )

    data object Customers : NavBarItem(
        title = R.string.root_customers,
        icon = DS.outline_person_24,
        activeIcon = DS.baseline_person_24,
    )

    data object Visits : NavBarItem(
        title = R.string.root_visits,
        icon = DS.outline_grid_view_24,
        activeIcon = DS.baseline_grid_view_24,
    )

    data object Calendar : NavBarItem(
        title = R.string.root_work_schedule,
        icon = DS.outline_calendar_today_24,
        activeIcon = DS.baseline_calendar_today_24,
    )

    data object Tasks : NavBarItem(
        title = R.string.root_tasks,
        icon = DS.outline_watch_24,
        activeIcon = DS.baseline_watch_24,
    )
}