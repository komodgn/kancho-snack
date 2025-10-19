import com.komodgn.snack.convention.implementation
import com.komodgn.snack.convention.implementationProject
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply("snack.android.library")
                apply("snack.android.library.compose")
                apply("snack.android.hilt")
            }

            dependencies {
                implementationProject(":core:designsystem")
                implementationProject(":core:ui")
            }
        }
    }
}