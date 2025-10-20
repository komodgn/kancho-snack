import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

internal class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.KOTLIN_JVM)
            }

            configureKotlinJvm()
        }
    }
}