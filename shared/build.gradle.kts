import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val versionFood2Fork: String by rootProject.extra
val versionJdk: JavaVersion by rootProject.extra
val versionAndroidSdk: Int by rootProject.extra
val versionAndroidSdkMin: Int by rootProject.extra
val versioniOSMin: String by rootProject.extra

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    kotlin("native.cocoapods")
}

version = versionFood2Fork

kotlin {
    android()
    iosX64()
    iosArm64()

    cocoapods {
        summary = "Food2Fork"
        homepage = "https://github.com/alexandregressier/food2fork-kmm"
        ios.deploymentTarget = versioniOSMin
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }

    sourceSets {
        // Common
        val commonMain by getting
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // Android
        val androidMain by getting
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation(Testing.junit4)
            }
        }

        // iOS
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = versionAndroidSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        minSdk = versionAndroidSdkMin
        targetSdk = versionAndroidSdk
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "$versionJdk"
    }
}