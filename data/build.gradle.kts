import Libs.androidTestImplementations
import Libs.implementations
import Libs.kaptAndroidTests
import Libs.kapts
import Libs.testImplementations

plugins {
    kotlin("kapt")
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.zerosword.data"
    compileSdk = AppConfig.compileSdkVer

    defaultConfig {
        minSdk = AppConfig.minSdkVer

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        debug {
            buildConfigField(
                type = "String",
                name = "baseUrl",
                value = "\"https://httpbin.org/\""
            )
        }
        release {
            buildConfigField(
                type = "String",
                name = "baseUrl",
                value = "\"https://httpbin.org/\""
            )

            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = AppConfig.javaVersion
        targetCompatibility = AppConfig.javaVersion
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
            project(":domain"),
            platform(Libs.okHttpClientBom),
            Libs.gson,
            Libs.coreKtx,
            Libs.retrofit,
            Libs.retrofitGsonConverter,
            Libs.okHttpClient,
            Libs.okHttpInterceptor,
            Libs.sandwich,
            Libs.sandwichForRetrofit,
            Libs.hilt
        )
    )
    testImplementations(
        listOf(
            Libs.junit,
            Libs.okHttpMockWebServer,
            Libs.hiltAndroidTest
        )
    )

    kapts(
        listOf(
            Libs.hiltCompiler
        )
    )

    androidTestImplementations(
        listOf(
            Libs.androidxTestJunit,
            Libs.androidxEspressoCore,
            Libs.hiltAndroidTest
        )
    )

    kaptAndroidTests(
        listOf(
            Libs.hiltCompiler
        )
    )

}
