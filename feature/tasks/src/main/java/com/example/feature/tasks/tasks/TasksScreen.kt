package com.example.feature.tasks.tasks

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.core.design.appbar.ToolbarLeadingAction
import com.example.core.design.appbar.TopAppBar
import com.example.core.translations.R
import com.ramcosta.composedestinations.annotation.Destination

@Destination
@Composable
fun TasksScreen() {
    TasksContent()
}

@Composable
private fun TasksContent() {
    Column {
        TopAppBar(
            title = stringResource(id = R.string.tasksScreen_title),
            navigationAction = ToolbarLeadingAction.Avatar(
                avatarUrl = "",
                onAvatarClicked = {},
            ),
        )
    }
}
