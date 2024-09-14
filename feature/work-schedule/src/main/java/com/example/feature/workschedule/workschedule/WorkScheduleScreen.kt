package com.example.feature.workschedule.workschedule

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.design.appbar.ToolbarLeadingAction
import com.example.core.design.appbar.TopAppBar
import com.example.core.model.Worker
import com.ramcosta.composedestinations.annotation.Destination
import com.example.core.translations.R.string as S

@Destination
@Composable
fun WorkScheduleScreen(
    viewModel: WorkScheduleViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    WorkScheduleContent(
        uiState = uiState,
    )
}

@Composable
private fun WorkScheduleContent(
    uiState: WorkScheduleUiState,
) {
    Column {
        TopAppBar(
            title = stringResource(id = S.workScheduleScreen_title),
            navigationAction = ToolbarLeadingAction.Avatar(
                avatarUrl = "",
                onAvatarClicked = {},
            ),
        )
        LazyColumn {
            items(items = uiState.workers) {
                WorkerItem(it)
            }
        }
    }
}

@Composable
private fun WorkerItem(worker: Worker) {
    Column {
        Text(text = worker.id)
        Text(text = worker.name)
        Text(text = worker.surname)
        Text(text = worker.position)
        Text(text = worker.email)
    }
}
