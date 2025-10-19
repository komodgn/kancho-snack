plugins {
    alias(libs.plugins.snack.android.library)
    alias(libs.plugins.kotlin.parcelize)
}

android {
    namespace = "com.komodgn.snack.feature.screens"
}

dependencies {
    api(libs.circuit.runtime)
}