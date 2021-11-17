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
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
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
        val commonMain by getting {
            dependencies {
                // KotlinX
                api(KotlinX.datetime)
                implementation(KotlinX.serialization.core)

                // Ktor Client
                implementation(Ktor.client.core)
                implementation(Ktor.client.serialization)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // Android
        val androidMain by getting {
            dependencies {
                // Ktor Client
                api(Ktor.client.okHttp)

                // SQLDelight
                implementation(Square.sqlDelight.drivers.android)
            }
        }
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
            dependencies {
                // Ktor Client
                implementation(Ktor.client.darwin)

                // SQLDelight
                implementation(Square.sqlDelight.drivers.native)
            }
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

sqldelight {
    database("RecipeDatabase") {
        packageName = "dev.gressier.food2fork.datasource.cache"
        sourceFolders = listOf("sqldelight")
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = "$versionJdk"
    }
}