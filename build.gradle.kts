// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Plugins.androidAppVer apply false
    id("org.jetbrains.kotlin.android") version Plugins.kotlinAndroidVer apply false
    kotlin("kapt") version Plugins.kaptVer apply false
    id("com.android.library") version "8.2.0" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}