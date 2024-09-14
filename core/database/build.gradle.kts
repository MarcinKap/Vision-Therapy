plugins {
    id("com.example.android.library")
    id("com.example.android.hilt")
    id("com.example.ktlint")
    id("com.example.detekt")
    id("org.jetbrains.kotlinx.kover")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.core.database"

    defaultConfig {
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
            arg("room.incremental", "true")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    sourceSets {
        getByName("test").assets.srcDir("$projectDir/schemas")
    }
}

dependencies {
    implementation(projects.core.model)

    // Room
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    implementation(libs.room.paging)
//    implementation(projects.core.time)
//    implementation(projects.core.ktx)
    testImplementation(libs.room.testing)
//    testImplementation(projects.core.testing.time)
    ksp(libs.room.compiler)

    implementation(projects.core.coroutines)
    coreLibraryDesugaring(libs.android.tools.desugar)

    // Testing
    testImplementation(platform(libs.junit.bom))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.vintage)
    testImplementation(platform(libs.kotest.bom))
    testImplementation(libs.kotest.assertions.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.robolectric)
    testImplementation(libs.turbine)
    testImplementation(libs.mockk)
}
