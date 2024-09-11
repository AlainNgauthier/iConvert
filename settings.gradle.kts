pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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
}

rootProject.name = "Iconvert"
include(":app")
include("service:common")
include(":service:user_settings")
include(":service:user_settings_impl")
include(":service:rates_repository")
include(":service:rates_repository_impl")
include(":service:use_case")
include(":service:retrofit")
