plugins {
    alias(libs.plugins.snack.android.application)
    alias(libs.plugins.snack.android.application.compose)
}

android {
    namespace = "com.komodgn.myapplication"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.core.ui)

    implementation(projects.feature.home)
    implementation(projects.feature.shop)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}