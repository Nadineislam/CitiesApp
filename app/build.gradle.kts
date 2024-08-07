plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id ("dagger.hilt.android.plugin")

}

android {
    namespace = "com.example.citiesapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.citiesapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField ("String", "GOOGLE_MAPS_API_KEY", "\"AIzaSyA46DOJoRfQD3bGsZy-C5RQXcW5Qv_bhk8\"")

    }


    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            resValue ("string", "google_maps_api_key", "\"AIzaSyA46DOJoRfQD3bGsZy-C5RQXcW5Qv_bhk8\"")
        }
        release {
            resValue ("string", "google_maps_api_key", "\"AIzaSyA46DOJoRfQD3bGsZy-C5RQXcW5Qv_bhk8\"")
        }
    }


    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
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

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation("androidx.activity:activity-compose:1.9.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    implementation("com.google.code.gson:gson:2.10.1")

    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.4")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.8.4")

    // Jetpack Compose Navigation
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    //Google maps
    implementation ("com.google.android.gms:play-services-maps:19.0.0")
    implementation ("com.google.maps.android:maps-compose:2.7.0")

    //Dagger hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-android-compiler:2.48")
    kapt ("androidx.hilt:hilt-compiler:1.2.0")



}