package com.komodgn.snack.convention

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionType: ExtensionType
) {
    commonExtension.run {
        buildFeatures {
            buildConfig = true
        }
    }

    when (extensionType) {
        ExtensionType.APPLICATION -> {
            extensions.configure<ApplicationExtension> {
                buildTypes {
                    debug { configureDebugBuildType() }
                    create("staging") { configureStagingBuildType() }
                    release { configureReleaseBuildType(commonExtension, extensionType) }
                }
            }
        }

        ExtensionType.LIBRARY -> {
            extensions.configure<LibraryExtension> {
                buildTypes {
                    debug { configureDebugBuildType() }
                    create("staging") { configureStagingBuildType() }
                    release { configureReleaseBuildType(commonExtension, extensionType) }
                }
            }
        }
    }
}

private fun BuildType.configureDebugBuildType() {
    buildConfigField("String", "BASE_URL", "\"DEBUG_API_URL\"")
}

private fun BuildType.configureStagingBuildType() {
    buildConfigField("String", "BASE_URL", "\"STAGING_API_URL\"")
}

private fun BuildType.configureReleaseBuildType(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
    extensionType: ExtensionType
) {
    buildConfigField("String", "BASE_URL", "\"RELEASE_API_URL\"")

    isMinifyEnabled = true

    if (extensionType == ExtensionType.APPLICATION) {
        isShrinkResources = true
    }

    proguardFiles(
        commonExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro"
    )
}
