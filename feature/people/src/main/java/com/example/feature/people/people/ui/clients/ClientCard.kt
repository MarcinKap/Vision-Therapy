package com.example.feature.people.people.ui.clients

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.core.design.R
import com.example.core.design.image.Image
import com.example.core.design.image.PainterSource
import com.example.core.design.image.toPainterSource
import com.example.core.design.spacer.HorizontalSpacer
import com.example.core.design.theme.VisionAppTheme
import com.example.core.model.Client
import com.example.core.model.Worker
import com.example.feature.people.people.ui.workers.WorkerCard
import java.time.LocalDate
import java.time.OffsetDateTime

@Composable
internal fun ClientCard(
    client: Client,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 4.dp,
        ),
        onClick = onClick,
    ) {
        Row(
            modifier = Modifier
                .clickable(onClick = onClick)
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .background(color = MaterialTheme.colorScheme.surfaceVariant, shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Image(
                    modifier = Modifier.size(36.dp),
                    painterSource = PainterSource.Async(
                        model = "",
                        placeholder = R.drawable.baseline_person_24.toPainterSource(),
                        error = R.drawable.baseline_person_24.toPainterSource(),
                    ),
                    contentDescription = "",
                )
            }
            HorizontalSpacer(width = 8.dp)
            Text(
                modifier = Modifier.weight(1f),
                text = "${client.firstName} ${client.lastName}",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WorkerCardPreview() {
    VisionAppTheme {
        Box(modifier = Modifier.padding(8.dp)) {
            WorkerCard(
                worker = Worker(
                    id = "1",
                    name = "name",
                    surname = "surname",
                    position = "position",
                    createdAt = OffsetDateTime.now(),
                    startDate = LocalDate.now(),
                    endDate = null,
                    email = "email",
                ),
                onClick = {},
            )
        }
    }
}
