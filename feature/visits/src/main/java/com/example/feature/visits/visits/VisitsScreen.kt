package com.example.feature.visits.visits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.core.design.appbar.ToolbarLeadingAction
import com.example.core.design.appbar.TopAppBar
import com.ramcosta.composedestinations.annotation.Destination
import com.example.core.translations.R.string as S

@Destination
@Composable
fun VisitsScreen() {

    VisitsContent()
}

@Composable
private fun VisitsContent() {
    Column {
        TopAppBar(
            title = stringResource(id = S.visitsScreen_title),
            navigationAction = ToolbarLeadingAction.Avatar(
                avatarUrl = "",
                onAvatarClicked = {},
            ),
        )
    }
}
