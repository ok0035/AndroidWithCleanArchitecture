import org.gradle.api.artifacts.dsl.DependencyHandler

object Libs {

    const val coreKtx = "androidx.core:core-ktx:1.12.0"

    //Retrofit
    private const val retrofitVer = "2.10.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$retrofitVer"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:$retrofitVer"

    //OkHttpClient
    private const val okHttpClientVer = "4.12.0"
    const val okHttpClientBom = "com.squareup.okhttp3:okhttp-bom:$okHttpClientVer"
    const val okHttpClient = "com.squareup.okhttp3:okhttp"
    const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor"
    const val okHttpMockWebServer = "com.squareup.okhttp3:mockwebserver:$okHttpClientVer"

    //Gson
    const val gson = "com.google.code.gson:gson:2.10.1"

    //Sandwich
    private const val sandwichVer = "2.0.6"
    const val sandwich = "com.github.skydoves:sandwich:$sandwichVer"
    const val sandwichForRetrofit =
        "com.github.skydoves:sandwich-retrofit:$sandwichVer" // For Retrofit

    //Hilt
    const val hiltVer = "2.51"
    const val hilt = "com.google.dagger:hilt-android:$hiltVer"
    const val hiltCompiler = "com.google.dagger:hilt-compiler:$hiltVer"
    const val hiltAndroidTest = "com.google.dagger:hilt-android-testing:$hiltVer"
    const val hiltForCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"

    //Compose
    const val activityCompose = "androidx.activity:activity-compose:1.8.2"
    const val composeBom = "androidx.compose:compose-bom:2023.08.00"
    const val composeUi = "androidx.compose.ui:ui"
    const val composeUiGraphics = "androidx.compose.ui:ui-graphics"
    const val composeUiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
    const val composeUiTestJunit = "androidx.compose.ui:ui-test-junit4"
    const val composeUiTooling = "androidx.compose.ui:ui-tooling"
    const val composeUiTestManifest = "androidx.compose.ui:ui-test-manifest"

    //Image
    const val glide = "com.github.bumptech.glide:glide:4.14.2" // lib + kapt
    const val glideForCompose = "com.github.bumptech.glide:compose:1.0.0-beta01"

    //Test
    const val material3 = "androidx.compose.material3:material3"
    const val junit = "junit:junit:4.13.2"
    const val androidxTestJunit = "androidx.test.ext:junit:1.1.5"
    const val androidxEspressoCore = "androidx.test.espresso:espresso-core:3.5.1"

    //Lifecycle
    private const val lifecycleVer = "2.7.0"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVer"
    const val viewModelForCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVer"
    const val lifecycleForCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVer"
    const val viewModelForSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycleVer"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVer"
    const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVer"
    const val lifecycleService = "androidx.lifecycle:lifecycle-service:$lifecycleVer"

    fun DependencyHandler.kapts(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementations(list: List<Any>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.testImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementations(list: List<Any>) {
        list.forEach { dependency ->
            add("androidTestImplementation", dependency)
        }
    }

    fun DependencyHandler.debugImplementations(list: List<String>) {
        list.forEach { dependency ->
            add("debugImplementation", dependency)
        }
    }

    fun DependencyHandler.kaptAndroidTests(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestAnnotationProcessor", dependency)
        }
    }

    fun DependencyHandler.kaptTests(list: List<String>) {
        list.forEach { dependency ->
            add("kaptTest", dependency)
        }
    }

}