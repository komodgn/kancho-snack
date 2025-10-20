plugins {
    alias(libs.plugins.snack.android.feature)
}

android {
    namespace = "com.komodgn.snack.feature.webview"
}

ksp {
    arg("circuit.codegen.mode", "hilt")
}

dependencies {

}