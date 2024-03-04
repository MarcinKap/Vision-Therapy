package com.example.feature.therapies.therapyselector.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.feature.therapies.therapyselector.TherapeuticExercise
import com.example.feature.therapies.therapyselector.TherapiesDataState
import com.example.feature.therapies.therapyselector.TherapySelectorUiAction
import com.example.feature.therapies.therapyselector.preview.firstExercise

@Composable
internal fun TherapySelectorSuccessContent(
    therapiesData: TherapiesDataState.Success,
    onAction: (TherapySelectorUiAction) -> Unit,
) {
    LazyColumn(
        modifier = Modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        items(items = therapiesData.sections) { section ->
            TherapySection(
                id = section.id,
                name = section.name,
                backgroundImageUrl = section.imageUrl,
                onClick = { onAction(TherapySelectorUiAction.OpenSelector(section.id)) },
            )
        }
    }
}

@Composable
private fun TherapySection(
    id: String,
    name: String,
    backgroundImageUrl: String,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth(),
            model = backgroundImageUrl,
            contentDescription = null,
        )
        Text(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 8.dp)
                .align(Alignment.BottomStart),
            text = name,
            fontSize = 21.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White,
        )
    }
}

@Composable
private fun TherapyExercise(
    therapeuticExercise: TherapeuticExercise,
    onAction: (TherapySelectorUiAction) -> Unit,
) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Blue, shape = RoundedCornerShape(8.dp)),
    ) {
        Text(
            text = therapeuticExercise.name,
        )
    }
}

@Preview
@Composable
private fun TherapyExercisePreview() {
    MaterialTheme {
        TherapyExercise(
            firstExercise,
            onAction = {},
        )
    }
}
