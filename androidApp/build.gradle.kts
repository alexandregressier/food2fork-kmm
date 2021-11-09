val versionFood2Fork: String by rootProject.extra
val versionCodeFood2Fork: Int by rootProject.extra
val versionJdk: JavaVersion by rootProject.extra
val versionAndroidSdk: Int by rootProject.extra
val versionAndroidSdkMin: Int by rootProject.extra

plugins {
    id("com.android.application")
    kotlin("android")
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
        kotlinCompilerExtensionVersion = "1.1.0-beta02"
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
    implementation("androidx.core:core-ktx:1.7.0")

    // Compose
    implementation("androidx.compose.ui:ui:1.1.0-beta02")
    implementation("androidx.compose.ui:ui-tooling-preview:1.1.0-beta02")

    // Material
    implementation("androidx.compose.material3:material3:1.0.0-alpha01")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    // Activity
    implementation("androidx.activity:activity-compose:1.4.0")

    // Navigation
    implementation("androidx.navigation:navigation-compose:2.4.0-beta02")
}