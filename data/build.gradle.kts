import Libs.androidTestImplementations
import Libs.implementations
import Libs.platformImplementations
import Libs.testImplementations

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

    platformImplementations(listOf(Libs.okHttpClientBom))
    implementations(
        listOf(
            Libs.coreKtx,
            Libs.material3,
            Libs.retrofit,
            Libs.okHttpClient,
            Libs.okHttpInterceptor,
            Libs.sandwich,
            Libs.sandwichForRetrofit
        )
    )
    testImplementations(
        listOf(
            Libs.junit,
            Libs.okHttpMockWebServer
        )
    )
    androidTestImplementations(
        listOf(
            Libs.androidxTestJunit,
            Libs.androidxEspressoCore
        )
    )

}