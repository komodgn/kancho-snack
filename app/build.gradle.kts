import java.util.Properties

plugins {
    alias(libs.plugins.snack.android.application)
    alias(libs.plugins.snack.android.application.compose)
    alias(libs.plugins.snack.android.hilt)
}

android {
    namespace = "com.komodgn.myapplication"

    signingConfigs {
        create("release") {
            val propertiesFile = rootProject.file("keystore.properties")
            val properties = Properties()
            properties.load(propertiesFile.inputStream())
            storeFile = rootProject.file(properties["storeFile"] as String)
            keyAlias = properties["keyAlias"] as String
            keyPassword = properties["keyPassword"] as String
            storePassword = properties["storePassword"] as String
        }
    }
}

ksp {
    arg("circuit.codegen.mode", "hilt")
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)
    implementation(projects.core.model)
    implementation(projects.core.ocr)

    implementation(projects.feature.main)
    implementation(projects.feature.webview)
    implementation(projects.feature.screens)
    implementation(projects.feature.home)
    implementation(projects.feature.shoot)
    implementation(projects.feature.shop)

    implementation(libs.bundles.circuit)

    api(libs.circuit.codegen.annotation)
    ksp(libs.circuit.codegen.ksp)
}
