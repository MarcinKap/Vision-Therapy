package com.example.feature.therapies.therapysection

import com.example.core.networking.model.NetworkError

data class TherapySectionUiState(
    val sections: TherapiesSectionState = TherapiesSectionState.Init,
)

sealed class TherapiesSectionState {
    data object Init : TherapiesSectionState()
    data object Loading : TherapiesSectionState()
    data class Error(val error: NetworkError) : TherapiesSectionState()
    data class Success(
        val name: String,
        val therapeuticExercises: List<TherapeuticExercise>,
    ) : TherapiesSectionState()
}

data class TherapeuticExercise(
    val id: String,
    val name: String,
    val link: String,
    val stage: Int,
)
