import com.komodgn.snack.convention.api
import com.komodgn.snack.convention.implementation
import com.komodgn.snack.convention.implementationProject
import com.komodgn.snack.convention.ksp
import com.komodgn.snack.convention.libs
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
                implementationProject(":core:common")
                implementationProject(":core:designsystem")
                implementationProject(":core:ui")
                implementationProject(":core:model")
                implementationProject(":feature:screens")

                implementation(libs.bundles.circuit)
                api(libs.circuit.codegen.annotation)
                ksp(libs.circuit.codegen.ksp)
            }
        }
    }
}