pluginManagement {

    plugins {
        kotlin("jvm") version "1.5.0" // or kotlin("multiplatform") or any other kotlin plugin
        kotlin("plugin.serialization") version "1.5.0"
    }
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }



    rootProject.name = "EletricCar"
    include(":app")
}
