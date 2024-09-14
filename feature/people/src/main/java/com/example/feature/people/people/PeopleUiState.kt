package com.example.feature.people.people

import com.example.core.model.Client
import com.example.core.model.Worker

data class PeopleUiState(
    val workers: List<Worker> = emptyList(),
    val clients: List<Client> = emptyList(),
    val selectedFilter: PeopleFilter = PeopleFilter.Workers,
)

sealed class PeopleFilter {
    data object Workers : PeopleFilter()
    data object Clients : PeopleFilter()
}
