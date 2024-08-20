pluginManagement {
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
        jcenter()
        // JitPack repositoryni qo'shish
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "SensorGame"
include(":app")
 