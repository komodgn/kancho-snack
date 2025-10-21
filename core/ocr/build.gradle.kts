import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    alias(libs.plugins.snack.android.library)
    alias(libs.plugins.snack.android.retrofit)
    alias(libs.plugins.snack.android.hilt)
}

android {
    namespace = "com.komodgn.snack.core.ocr"

    defaultConfig {
        buildConfigField("String", "CLOUD_VISION_API_KEY", getApiKey("CLOUD_VISION_API_KEY"))
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {

}

fun getApiKey(propertyKey: String) : String {
    return gradleLocalProperties(rootDir, providers).getProperty(propertyKey)
}