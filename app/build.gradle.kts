plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
}

android {
    namespace = "com.example.newsreaderpractice"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newsreaderpractice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    dependencies {
        // ViewModel
        implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
        // LiveData
        implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.9.1")
        // Navigation Component
        implementation ("androidx.navigation:navigation-fragment-ktx:2.9.0")
        implementation ("androidx.navigation:navigation-ui-ktx:2.9.0")
        // RecyclerView
        implementation ("androidx.recyclerview:recyclerview:1.4.0")
        // Material Design
        implementation ("com.google.android.material:material:1.6.0")
        implementation ("com.github.bumptech.glide:glide:4.15.1")
        implementation ("com.squareup.retrofit2:retrofit:2.9.0")
        implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation ("com.squareup.okhttp3:logging-interceptor:4.12.0")
        implementation ("androidx.room:room-runtime:2.7.2")
        kapt ("androidx.room:room-compiler:2.7.2")
        implementation ("androidx.room:room-ktx:2.7.2")
        implementation ("androidx.core:core-splashscreen:1.0.1")


    }
}