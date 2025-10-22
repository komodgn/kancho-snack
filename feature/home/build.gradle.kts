plugins {
    alias(libs.plugins.snack.android.feature)
}

android {
    namespace = "com.komodgn.snack.feature.home"
}

ksp {
    arg("circuit.codegen.mode", "hilt")
}

dependencies {
}
