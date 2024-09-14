package com.example.feature.people.people.ui.clients

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.design.theme.VisionAppTheme
import com.example.core.model.Client
import com.example.core.model.Worker
import com.example.feature.people.people.PeopleUiAction
import com.example.feature.people.people.ui.workers.WorkersList
import java.time.LocalDate
import java.time.OffsetDateTime

@Composable
internal fun ClientsList(
    clients: List<Client>,
    onClick: (PeopleUiAction) -> Unit,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            vertical = 8.dp,
            horizontal = 16.dp,
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(
            items = clients,
            key = { _, worker -> worker.id },
        ) { _, it ->
            ClientCard(
                client = it,
                onClick = { onClick(PeopleUiAction.OpenWorker(it.id)) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WorkerCardPreview() {
    VisionAppTheme {
        WorkersList(
            workers = listOf(
                Worker(
                    id = "1",
                    name = "name",
                    surname = "surname",
                    position = "position",
                    createdAt = OffsetDateTime.now(),
                    startDate = LocalDate.now(),
                    endDate = null,
                    email = "email",
                ),
            ),
            onClick = {},
        )
    }
}
