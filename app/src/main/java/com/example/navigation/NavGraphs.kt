package com.example.navigation

import com.example.feature.customers.customers.destinations.CustomersScreenDestination
import com.example.feature.start.startscreen.composable.destinations.StartScreenDestination
import com.example.feature.tasks.tasks.destinations.TasksScreenDestination
import com.example.feature.therapies.destinations.TherapySelectorScreenDestination
import com.example.feature.visits.visits.destinations.VisitsScreenDestination
import com.example.feature.workschedule.workschedule.destinations.WorkScheduleScreenDestination
import com.ramcosta.composedestinations.dynamic.routedIn
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object NavGraphs {
    val start = object : NavGraphSpec {
        override val route = "start"

        override val startRoute = StartScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            StartScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val therapies = object : NavGraphSpec {
        override val route = "therapies"

        override val startRoute = TherapySelectorScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            TherapySelectorScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val customers = object : NavGraphSpec {
        override val route = "customers"

        override val startRoute = CustomersScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            CustomersScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val visits = object : NavGraphSpec {
        override val route = "visits"

        override val startRoute = VisitsScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            VisitsScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val workSchedule = object : NavGraphSpec {
        override val route = "work-schedule"

        override val startRoute = WorkScheduleScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            WorkScheduleScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val tasks = object : NavGraphSpec {
        override val route = "tasks"

        override val startRoute = TasksScreenDestination routedIn this

        override val destinationsByRoute = listOf<DestinationSpec<*>>(
            TasksScreenDestination,
        ).routedIn(this)
            .associateBy { it.route }
    }

    val root = object : NavGraphSpec {
        override val route = "root"
        override val startRoute = start
        override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

        override val nestedNavGraphs = listOf(
            start,
            customers,
            visits,
            workSchedule,
            tasks,
            therapies,
        )
    }
}
