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

rootProject.name = "Kotlin-Android-Workshop"
include(":app")
include(":01_helloworld")
include(":02_xml_layouts")
include(":03_user_interactions")
include(":04_navigation")
include(":05_data_storage")
include(":06_recyclerview")
include(":07_images_camera")
include(":08_api_integration")
include(":09_location_services")
include(":10_final_project")
