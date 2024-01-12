import com.android.build.gradle.LibraryExtension
import com.example.configureFlavors
import com.example.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidFeatureConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                configureFlavors(this)
                defaultConfig {
                    testInstrumentationRunner = "com.example.core.testing.ui.runner.CompaniesHiltTestRunner"
                }
            }
        }
    }
}
