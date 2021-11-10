pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            with (requested) {
                when (id.id) {
                    "dagger.hilt.android.plugin" ->
                        useModule("com.google.dagger:hilt-android-gradle-plugin:$version")
                }
            }
        }
    }
}

plugins {
    id("de.fayard.refreshVersions") version "0.23.0"
}

refreshVersions {
    rejectVersionIf {
        candidate.stabilityLevel.isLessStableThan(current.stabilityLevel)
    }
}

//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}
gradle.rootProject {
    allprojects.forEach {
        it.repositories {
            google()
            mavenCentral()
        }
    }
}

rootProject.name = "food2fork"
include(
    ":shared",
    ":androidApp",
)