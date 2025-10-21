import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.implementation
import com.komodgn.snack.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal class KotlinLibrarySerializationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.KOTLINX_SERIALIZATION)
            }

            dependencies {
                implementation(libs.kotlinx.serialization.json)
            }
        }
    }
}