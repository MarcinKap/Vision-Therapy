package com.example.feature.therapies.therapyselector.preview

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.example.core.networking.model.NetworkError
import com.example.feature.therapies.therapyselector.TherapiesDataState
import com.example.feature.therapies.therapyselector.TherapySelectorUiState

private val initData = TherapySelectorUiState()
private val loadingData = TherapySelectorUiState(state = TherapiesDataState.Loading)
private val errorData = TherapySelectorUiState(state = TherapiesDataState.Error(NetworkError.ConnectionError))
internal val successDownloadedData = TherapySelectorUiState(
    state = TherapiesDataState.Success(
        sections = listOf(
            firstTreatmentSection,
            secondExampleTreatmentSection,
        ),
    ),
)

internal class TherapySelectorPreviewData : PreviewParameterProvider<TherapySelectorUiState> {
    override val values: Sequence<TherapySelectorUiState> = sequenceOf(
        initData,
        loadingData,
        errorData,
        successDownloadedData,
    )
}
