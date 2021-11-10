val versionGradle by extra("7.3")
val versionFood2Fork by extra("0.1.0")
val versionCodeFood2Fork by extra(1)
val versionJdk by extra(JavaVersion.VERSION_11)
val versionAndroidSdk by extra(31)
val versionAndroidSdkMin by extra(26)
val versioniOSMin by extra("14.1")

plugins {
    kotlin("jvm") apply false
    id("com.android.application") apply false
}

tasks.wrapper {
    gradleVersion = versionGradle
}

val clean by tasks.registering(Delete::class) {
    doLast {
        delete(rootProject.buildDir)
    }
}