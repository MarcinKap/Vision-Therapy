package com.example.feature.therapies.therapyselector

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.core.design.appbar.ToolbarLeadingAction
import com.example.core.design.appbar.TopAppBar
import com.example.core.translations.R
import com.example.feature.therapies.therapyselector.ui.TherapySelectorSuccessContent
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TherapySelectorScreen(
    viewModel: TherapySelectorViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val navigationEvent by viewModel.navigationEventFlow.collectAsStateWithLifecycle()

    TherapySelectorContent(
        uiState = uiState,
        onAction = viewModel::onAction,
    )
}

@Composable
private fun TherapySelectorContent(
    uiState: TherapySelectorUiState,
    onAction: (TherapySelectorUiAction) -> Unit,
) {
    Column {
        Header()

        when (uiState.state) {
            TherapiesDataState.Loading, TherapiesDataState.Init -> {} // TODO

            is TherapiesDataState.Error -> {} // TODO

            is TherapiesDataState.Success -> TherapySelectorSuccessContent(
                therapiesData = uiState.state,
                onAction = onAction,
            )
        }
    }
}

@Composable
private fun Header() {
    TopAppBar(
        title = stringResource(id = R.string.therapiesScreen_title),
        navigationAction = ToolbarLeadingAction.Avatar(
            avatarUrl = "",
            onAvatarClicked = {},
        ),
    )
}
