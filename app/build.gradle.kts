import Libs.androidTestImplementations
import Libs.debugImplementations
import Libs.implementations
import Libs.kaptAndroidTests
import Libs.kaptTests
import Libs.kapts
import Libs.testImplementations

plugins {
    kotlin("kapt")
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
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
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTargetVer
    }
    buildFeatures {
        compose = true
        buildConfig = true
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

kapt {
    correctErrorTypes = true
}

dependencies {

    implementations(
        listOf(
            project(":data"),
            project(":domain"),
            project(":feature-main"),
            project(":resources"),
            platform(Libs.composeBom),
            platform(Libs.okHttpClientBom),
            Libs.coreKtx,
            Libs.lifecycleRuntimeKtx,
            Libs.lifecycleForCompose,
            Libs.lifecycleService,
            Libs.viewModel,
            Libs.viewModelForCompose,
            Libs.viewModelForSavedState,
            Libs.retrofit,
            Libs.retrofitGsonConverter,
            Libs.okHttpClient,
            Libs.okHttpInterceptor,
            Libs.sandwich,
            Libs.sandwichForRetrofit,
            Libs.activityCompose,
            Libs.composeUi,
            Libs.composeUiGraphics,
            Libs.composeUiToolingPreview,
            Libs.material3,
            Libs.glide,
            Libs.glideForCompose,
            Libs.hilt
        )
    )

    kapts(
        listOf(
            Libs.hiltCompiler,
            Libs.lifecycleCompiler,
            Libs.glide
        )
    )
    kaptTests(listOf(Libs.hiltCompiler))

    testImplementations(
        listOf(
            Libs.junit,
            Libs.okHttpMockWebServer,
            Libs.hiltAndroidTest
        )
    )

    androidTestImplementations(
        listOf(
            platform(Libs.composeBom),
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


