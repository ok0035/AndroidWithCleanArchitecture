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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTargetVer
    }
}

dependencies {

    val platformImpls = listOf(Libs.okHttpClientBom)

    val impls = listOf(
        Libs.coreKtx,
        Libs.material3,
        Libs.retrofit,
        Libs.okHttpClient,
        Libs.okHttpInterceptor,
        Libs.sandwich,
        Libs.sandwichForRetrofit
    )

    val testImpls = listOf(
        Libs.junit,
        Libs.okHttpMockWebServer
    )

    val androidTestImpls = listOf(
        Libs.androidxTestJunit,
        Libs.androidxEspressoCore
    )

    platformImplementations(platformImpls)
    implementations(impls)
    testImplementations(testImpls)
    androidTestImplementations(androidTestImpls)

}