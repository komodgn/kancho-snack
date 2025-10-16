plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}

gradlePlugin {
    val conventionPluginClasses = listOf(
        "android.application" to "AndroidApplicationConventionPlugin",
    )

    plugins {
        conventionPluginClasses.forEach { conventionPluginClass ->
            val (pluginName, className) = conventionPluginClass
            register(pluginName) {
                id = "snack.$pluginName"
                implementationClass = className
            }
        }
    }
}