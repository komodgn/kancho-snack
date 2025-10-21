rootProject.name = "snack"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
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

include(":app")

include(":core:designsystem")
include(":core:ui")
include(":core:model")

include(":feature:home")
include(":feature:shop")
include(":feature:main")
include(":feature:shoot")
include(":feature:screens")
include(":core:common")
include(":feature:webview")
include(":core:ocr")
