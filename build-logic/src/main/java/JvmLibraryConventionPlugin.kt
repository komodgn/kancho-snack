import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.configureKotlinJvm
import com.komodgn.snack.convention.detektPlugins
import com.komodgn.snack.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.KOTLIN_JVM)
            }

            configureKotlinJvm()

            dependencies {
                detektPlugins(libs.detekt.formatting)
            }
        }
    }
}
