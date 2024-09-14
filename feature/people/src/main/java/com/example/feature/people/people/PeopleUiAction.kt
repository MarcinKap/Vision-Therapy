package com.example.feature.people.people

internal sealed interface PeopleUiAction {
    data object SelectWorkersTab : PeopleUiAction
    data object SelectClientsTab : PeopleUiAction
    data class OpenWorker(val id: String) : PeopleUiAction
}

