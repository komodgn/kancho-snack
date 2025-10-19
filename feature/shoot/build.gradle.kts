plugins {
    alias(libs.plugins.snack.android.feature)
}

android {
    namespace = "com.komodgn.snack.feature.shoot"
}

dependencies {
    implementation(libs.androidx.camera.core)
    implementation(libs.androidx.camera.view)
    implementation(libs.androidx.camera.camera2)
    implementation(libs.androidx.camera.lifecycle)
}