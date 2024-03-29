plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.devtools.ksp")
    kotlin("kapt")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("androidx.room")
}
class RoomSchemaArgProvider(
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    val schemaDir: File
) : CommandLineArgumentProvider {

    override fun asArguments(): Iterable<String> {
        // Note: If you're using KSP, change the line below to return
        // listOf("room.schemaLocation=${schemaDir.path}").
        return listOf("-Aroom.schemaLocation=${schemaDir.path}")
    }
}


room {
    schemaDirectory("$projectDir/schemas")
}
android {
    namespace = "com.example.spoonify"
    compileSdk = 33




    defaultConfig {
        applicationId = "com.example.spoonify"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("string","API_KEY","")
        javaCompileOptions {
            annotationProcessorOptions {
                compilerArgumentProviders(
                    RoomSchemaArgProvider(File(projectDir, "schemas"))
                )
            }
        }


    }
    ksp {
        arg(RoomSchemaArgProvider(File(projectDir, "schemas")))
    }

    buildFeatures {
        dataBinding = true
        viewBinding = true
        buildConfig = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
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
    val lottieVersion = "3.4.0"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    implementation("androidx.viewpager2:viewpager2:1.0.0")

    // Coordinator Layout
    implementation ("androidx.coordinatorlayout:coordinatorlayout:1.1.0")

    // Material Components
    implementation ("com.google.android.material:material:1.8.0")

    // Navigation Component
    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")

    // Room components
    implementation ("androidx.room:room-runtime:2.5.2")
    ksp ("androidx.room:room-compiler:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    androidTestImplementation ("androidx.room:room-testing:2.5.2")

    ksp ("com.android.databinding:compiler:3.2.0-alpha10")
    ksp ("androidx.databinding:databinding-common:4.1.0")

    // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    // Recyclerview
    implementation ("androidx.recyclerview:recyclerview:1.3.1")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    ksp("com.google.dagger:hilt-android-compiler:2.48")



    // Coroutines
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle
    implementation ("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    // Image Loading library Coil
    implementation ("io.coil-kt:coil:0.13.0")

    // Gson
    implementation ("com.google.code.gson:gson:2.8.6")


    // Shimmer
    implementation ("com.facebook.shimmer:shimmer:0.5.0")

    // Jsoup
    implementation ("org.jsoup:jsoup:1.13.1")

    //SplashScreen
    implementation("androidx.core:core-splashscreen:1.0.0")



    //Lottie
    implementation ("com.airbnb.android:lottie:$lottieVersion")
}