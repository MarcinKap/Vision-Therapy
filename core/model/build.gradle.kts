plugins {
    id("com.example.android.feature")
    id("com.example.ktlint")
    id("com.example.detekt")
    id("org.jetbrains.kotlinx.kover")
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.core.model"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)

    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testImplementation(platform(libs.kotest.bom))
    testImplementation(libs.kotest.assertions.core)
}
