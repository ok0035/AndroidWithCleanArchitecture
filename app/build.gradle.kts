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

    val platformImpls = listOf(
        Libs.composeBom,
        Libs.okHttpClientBom
    )

    val impls = listOf(
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

    val testImpls= listOf(
        Libs.junit,
        Libs.okHttpMockWebServer
    )

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