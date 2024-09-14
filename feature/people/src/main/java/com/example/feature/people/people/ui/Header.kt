package com.example.feature.people.people.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.design.appbar.ToolbarLeadingAction
import com.example.core.design.appbar.TopAppBar
import com.example.core.design.theme.VisionAppTheme
import com.example.core.translations.R.string as S
import com.example.feature.people.people.PeopleFilter
import com.example.feature.people.people.PeopleUiAction
import com.example.feature.people.people.PeopleUiState

@Composable
internal fun Header(
    uiState: PeopleUiState,
    onClick: (PeopleUiAction) -> Unit,
) {
    TopAppBar(
        title = stringResource(id = S.peopleScreen_title),
        navigationAction = ToolbarLeadingAction.Avatar(
            avatarUrl = "",
            onAvatarClicked = {},
        ),
        content = {
            PeopleTabSelector(
                uiState = uiState,
                onClick = onClick,
            )
        },
    )
}

@Composable
private fun PeopleTabSelector(
    uiState: PeopleUiState,
    onClick: (PeopleUiAction) -> Unit,
) {
    Row {
        PeopleTab(
            title = stringResource(id = S.peopleScreen_selectorTab_workers),
            isSelected = uiState.selectedFilter is PeopleFilter.Workers,
            onClick = { onClick(PeopleUiAction.SelectWorkersTab) },
        )
        PeopleTab(
            title = stringResource(id = S.peopleScreen_selectorTab_clients),
            isSelected = uiState.selectedFilter is PeopleFilter.Clients,
            onClick = { onClick(PeopleUiAction.SelectClientsTab) },
        )
    }
}

@Composable
private fun RowScope.PeopleTab(
    title: String,
    isSelected: Boolean,
    onClick: () -> Unit,
) {
    val (color, textColor) = if (isSelected) {
        Pair(
            MaterialTheme.colorScheme.primary,
            MaterialTheme.colorScheme.primary,
        )
    } else {
        Pair(
            Color.Transparent,
            MaterialTheme.colorScheme.onBackground,
        )
    }

    Column(
        modifier = Modifier
            .height(48.dp)
            .clickable(onClick = onClick)
            .weight(1f),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(modifier = Modifier.weight(1f)) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = title,
                color = textColor,
                fontSize = 20.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
            )
        }
        AnimatedVisibility(visible = isSelected) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(color = color),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun HeaderPreview() {
    VisionAppTheme {
        Header(
            uiState = PeopleUiState(),
            onClick = {},
        )
    }
}