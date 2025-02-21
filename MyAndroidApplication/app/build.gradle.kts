plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.myandroidapplication"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.myandroidapplication"
        minSdk = 35
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    implementation("io.reactivex.rxjava2:rxjava:2.1.0")
    implementation("io.reactivex.rxjava2:rxandroid:2.0.1")
    implementation("com.jakewharton.rxbinding2:rxbinding:2.0.0")
}