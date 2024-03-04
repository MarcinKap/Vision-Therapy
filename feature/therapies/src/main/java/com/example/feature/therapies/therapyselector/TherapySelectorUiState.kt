package com.example.feature.therapies.therapyselector

import com.example.core.networking.model.NetworkError

data class TherapySelectorUiState(
    val state: TherapiesDataState = TherapiesDataState.Init,
)

sealed class TherapiesDataState {
    data object Init : TherapiesDataState()
    data object Loading : TherapiesDataState()
    data class Error(val error: NetworkError) : TherapiesDataState()
    data class Success(
        val sections: List<TreatmentSection>,
    ) : TherapiesDataState()
}

data class TreatmentSection(
    val id: String,
    val name: String,
    val imageUrl: String,
    val therapeuticExercises: List<TherapeuticExercise>,
)

data class TherapeuticExercise(
    val id: String,
    val name: String,
    val link: String,
    val stage: Int,
)
