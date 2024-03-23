import Libs.androidPlatformTestImplementations
import Libs.androidTestImplementations
import Libs.debugImplementations
import Libs.implementations
import Libs.kaptAndroidTests
import Libs.kaptTests
import Libs.kapts
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTargetVer
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtVer
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    platformImplementations(
        listOf(
            Libs.composeBom,
            Libs.okHttpClientBom
        )
    )

    implementations(
        listOf(
            Libs.coreKtx,
            Libs.lifeCycleRuntimeKtx,
            Libs.retrofit,
            Libs.okHttpClient,
            Libs.okHttpInterceptor,
            Libs.sandwich,
            Libs.sandwichForRetrofit,
            Libs.activityCompose,
            Libs.composeUi,
            Libs.composeUiGraphics,
            Libs.composeUiToolingPreview,
            Libs.material3,
        )
    )

    kapts(listOf(Libs.hiltCompiler))
    kaptTests(listOf(Libs.hiltCompiler))

    testImplementations(
        listOf(
            Libs.junit,
            Libs.okHttpMockWebServer,
            Libs.hiltAndroidTest
        )
    )

    androidPlatformTestImplementations(listOf(Libs.composeBom))

    androidTestImplementations(
        listOf(
            Libs.androidxTestJunit,
            Libs.androidxEspressoCore,
            Libs.composeUiTestJunit,
            Libs.hiltAndroidTest
        )
    )

    kaptAndroidTests(
        listOf(
            Libs.hiltCompiler
        )
    )

    debugImplementations(
        listOf(
            Libs.composeUiTooling,
            Libs.composeUiTestManifest
        )
    )

}

kapt {
    correctErrorTypes = true
}