package com.example.feature.people.people

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.design.theme.VisionAppTheme
import com.example.feature.people.people.ui.Header
import com.example.feature.people.people.ui.clients.ClientsList
import com.example.feature.people.people.ui.workers.WorkersList
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun PeopleScreen(
    viewModel: PeopleViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    PeopleContent(
        uiState = uiState,
        onClick = viewModel::onAction,
    )
}

@Composable
private fun PeopleContent(
    uiState: PeopleUiState,
    onClick: (PeopleUiAction) -> Unit,
) {
    Column {
        Header(
            uiState = uiState,
            onClick = onClick,
        )
        PeopleList(
            uiState = uiState,
            onClick = onClick,
        )
    }
}

@Composable
private fun PeopleList(
    uiState: PeopleUiState,
    onClick: (PeopleUiAction) -> Unit,
) {
    when (uiState.selectedFilter) {
        PeopleFilter.Clients -> {
            ClientsList(
                clients = uiState.clients,
                onClick = onClick,
            )
        }

        PeopleFilter.Workers -> {
            WorkersList(
                workers = uiState.workers,
                onClick = onClick,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PeopleContentPreview() {
    VisionAppTheme {
        PeopleContent(
            uiState = PeopleUiState(),
            onClick = {},
        )
    }
}
