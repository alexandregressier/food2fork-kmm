import de.fayard.refreshVersions.core.versionFor

val versionFood2Fork: String by rootProject.extra
val versionCodeFood2Fork: Int by rootProject.extra
val versionJdk: JavaVersion by rootProject.extra
val versionAndroidSdk: Int by rootProject.extra
val versionAndroidSdkMin: Int by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = versionAndroidSdk

    defaultConfig {
        applicationId = "dev.gressier.food2fork.android"
        minSdk = versionAndroidSdkMin
        targetSdk = versionAndroidSdk
        versionCode = versionCodeFood2Fork
        versionName = versionFood2Fork
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = versionJdk
        targetCompatibility = sourceCompatibility
    }
    kotlinOptions {
        jvmTarget = "${compileOptions.sourceCompatibility}"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = versionFor(AndroidX.compose.ui)
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // KMM
    implementation(project(":shared"))

    // Core
    implementation(AndroidX.core.ktx)

    // Compose
    implementation(AndroidX.compose.ui)
    implementation(AndroidX.compose.ui.toolingPreview)

    // Material
    implementation("androidx.compose.material3:material3:_")

    // Lifecycle
    implementation(AndroidX.lifecycle.runtimeKtx)
    implementation(AndroidX.lifecycle.viewModelCompose)

    // Activity
    implementation(AndroidX.activity.compose)

    // Hilt
    implementation(Google.dagger.hilt.android)
    kapt(Google.dagger.hilt.compiler)

    // Navigation
    implementation(AndroidX.navigation.compose)
    implementation(AndroidX.hilt.navigationCompose)
}

kapt {
    correctErrorTypes = true
}