import Libs.androidTestImplementations
import Libs.debugImplementations
import Libs.implementations
import Libs.testImplementations

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.zerosword.resources"
    compileSdk = AppConfig.compileSdkVer

    defaultConfig {
        minSdk = AppConfig.minSdkVer

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtVer
    }

    kotlinOptions {
        jvmTarget = AppConfig.jvmTargetVer
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {

    implementations(
        listOf(
            platform(Libs.composeBom),
            Libs.coreKtx,
            Libs.retrofit,
            Libs.activityCompose,
            Libs.composeUi,
            Libs.composeUiGraphics,
            Libs.composeUiToolingPreview,
            Libs.material3,
        )
    )

    testImplementations(
        listOf(
            Libs.junit,
        )
    )

    androidTestImplementations(
        listOf(
            platform(Libs.composeBom),
            Libs.androidxTestJunit,
            Libs.androidxEspressoCore,
            Libs.composeUiTestJunit,
        )
    )

    debugImplementations(
        listOf(
            Libs.composeUiTooling,
            Libs.composeUiTestManifest
        )
    )

}