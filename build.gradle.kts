// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Plugins.androidAppVer apply false
    id("org.jetbrains.kotlin.android") version Plugins.kotlinAndroidVer apply false
    id("com.android.library") version Plugins.androidAppVer apply false
    id("com.google.dagger.hilt.android") version Libs.hiltVer apply false
    kotlin("kapt") version Plugins.kaptVer apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
