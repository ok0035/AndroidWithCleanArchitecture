import org.gradle.api.artifacts.dsl.DependencyHandler

object Libs {

    const val kaptPluginVer = "1.9.23"
    const val coreKtx = "androidx.core:core-ktx:1.12.0"
    const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.7.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:2.10.0"
    const val activityCompose = "androidx.activity:activity-compose:1.8.2"
    const val composeBom = "androidx.compose:compose-bom:2023.08.00"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val material3 = "androidx.compose.material3:material3"
    const val junit = "junit:junit:4.13.2"
    const val androidxTestJunit = "androidx.test.ext:junit:1.1.5"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:3.5.1"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementations(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.platformImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", platform(dependency))
        }
    }

    fun DependencyHandler.testImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestImplementation", dependency)
        }
    }

    fun DependencyHandler.androidPlatformTestImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestImplementation", platform(dependency))
        }
    }

    fun DependencyHandler.debugImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }

}