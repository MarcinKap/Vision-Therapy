pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Vision-Therapy"
include(
    ":app",
    ":core:networking",
    ":core:coroutines",
    ":core:design",
    ":core:testing:compose",
    ":core:testing:endpoints",
    ":core:testing:mockwebserver",
    ":core:testing:screenshots",
    ":core:testing:ui",
    ":data:product",
    ":feature:start",
    ":feature:therapies",
    ":feature:visits",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
