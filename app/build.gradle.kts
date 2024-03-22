import Libs.androidPlatformTestImplementations
import Libs.androidTestImplementations
import Libs.debugImplementations
import Libs.implementations
import Libs.platformImplementations
import Libs.testImplementations

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
}

android {
    namespace = "com.zerosword.template"
    compileSdk = AppConfig.compileSdkVer

    defaultConfig {
        applicationId = "com.zerosword.template"
        minSdk = AppConfig.minSdkVer
        targetSdk = AppConfig.targetSdkVer
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val platformImpls = listOf(
        Libs.composeBom
    )

    val impls = listOf(
        Libs.coreKtx,
        Libs.lifeCycleRuntimeKtx,
        Libs.retrofit,
        Libs.activityCompose,
        Libs.composeUi,
        Libs.composeUiGraphics,
        Libs.composeUiToolingPreview,
        Libs.material3,
    )

    val testImpls= listOf(Libs.junit)

    val androidPlatformImpls = listOf(Libs.composeBom)
    val androidTestImpls = listOf(
        Libs.androidxTestJunit,
        Libs.androidxEspressoCore,
        Libs.composeUiTestJunit
    )

    val debugImpls = listOf(
        Libs.composeUiTooling,
        Libs.composeUiTestManifest
    )

    platformImplementations(platformImpls)
    implementations(impls)
    testImplementations(testImpls)
    androidPlatformTestImplementations(androidPlatformImpls)
    androidTestImplementations(androidTestImpls)
    debugImplementations(debugImpls)

}