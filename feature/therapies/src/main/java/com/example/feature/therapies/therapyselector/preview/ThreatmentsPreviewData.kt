package com.example.feature.therapies.therapyselector.preview

import com.example.feature.therapies.therapyselector.TherapeuticExercise
import com.example.feature.therapies.therapyselector.TreatmentSection

val firstExercise = TherapeuticExercise(
    id = "first exercise",
    name = "first exercise",
    link = "",
    stage = 1,
)

private val secondExercise = TherapeuticExercise(
    id = "second exercise",
    name = "second exercise",
    link = "",
    stage = 2,
)

private val thirdExercise = TherapeuticExercise(
    id = "third exercise",
    name = "third exercise",
    link = "",
    stage = 3,
)

internal val firstTreatmentSection = TreatmentSection(
    id = "first TreatmentSection",
    name = "first TreatmentSection",
    imageUrl = "https://picsum.photos/id/62/1280/440",
    therapeuticExercises = listOf(
        firstExercise,
        secondExercise,
        thirdExercise,
    ),
)

internal val secondExampleTreatmentSection = TreatmentSection(
    id = "secondTreatmentSection",
    name = "second TreatmentSection",
    imageUrl = "https://picsum.photos/id/83/1280/440",
    therapeuticExercises = listOf(
        firstExercise,
        secondExercise,
        thirdExercise,
    ),
)
