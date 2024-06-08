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

rootProject.name = "KeepBudget"

include(":app")
include(":core:core-common")
include(":core:core-data")
include(":core:core-domain")
include(":feature:feature-transaction")
include(":feature:feature-auth")
include(":feature:feature-statistic")
include(":feature:feature-settings")
