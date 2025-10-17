plugins {
    alias(libs.plugins.snack.android.library)
    alias(libs.plugins.snack.android.library.compose)
}

android {
    namespace = "com.komodgn.snack.core.ui"
}

dependencies {
    implementation(projects.snack.core.designsystem)
}