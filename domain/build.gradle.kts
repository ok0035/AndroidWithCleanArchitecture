import Libs.androidTestImplementations
import Libs.implementations
import Libs.testImplementations

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.zerosword.domain"
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
        sourceCompatibility = JavaVersion.VERSION_19
        targetCompatibility = JavaVersion.VERSION_19
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTargetVer
    }
}

dependencies {

    val impls = listOf(
        Libs.coreKtx,
        Libs.material3
    )

    val testImpls = listOf(
        Libs.junit
    )

    val androidTestImpls = listOf(
        Libs.androidxTestJunit,
        Libs.androidxEspressoCore
    )

    implementations(impls)
    testImplementations(testImpls)
    androidTestImplementations(androidTestImpls)
}