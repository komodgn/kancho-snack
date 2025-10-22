// Top-level build file where you can add configuration options common to all sub-projects/modules.
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.jlleitschuh.gradle.ktlint.KtlintExtension

plugins {
    alias(libs.plugins.kotlin.detekt)
    alias(libs.plugins.kotlin.ktlint)

    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false

    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.kotlin.parcelize) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false

    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
}

val excludeModules: String? by project

allprojects {
    if (excludeModules?.split(",")?.contains(project.name) != true) {
        apply {
            plugin(
                rootProject.libs.plugins.kotlin.detekt
                    .get()
                    .pluginId,
            )
            plugin(
                rootProject.libs.plugins.kotlin.ktlint
                    .get()
                    .pluginId,
            )
        }
    }

    afterEvaluate {
        extensions.configure<DetektExtension> {
            parallel = true
            buildUponDefaultConfig = true
            toolVersion = libs.versions.kotlinDetekt.get()
            config.setFrom(files("$rootDir/detekt-config.yml"))
        }

        extensions.configure<KtlintExtension> {
            version.set(
                rootProject.libs.versions.kotlinKtlintSource
                    .get(),
            )
            android.set(true)
            verbose.set(true)
        }
    }
}
