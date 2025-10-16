import com.android.build.api.dsl.ApplicationExtension
import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.configureCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.ANDROID_APPLICATION)
                apply(Plugins.KOTLIN_COMPOSE)
            }

            extensions.configure<ApplicationExtension> {
                configureCompose(this)
            }
        }
    }
}