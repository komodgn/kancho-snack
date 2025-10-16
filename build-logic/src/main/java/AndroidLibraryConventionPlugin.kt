import com.android.build.gradle.LibraryExtension
import com.komodgn.snack.convention.ExtensionType
import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.configureBuildTypes
import com.komodgn.snack.convention.configureKotlinAndroid
import com.komodgn.snack.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import kotlin.text.toInt

internal class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.ANDROID_APPLICATION)
                apply(Plugins.KOTLIN_ANDROID)
            }

            extensions.configure<LibraryExtension> {
                defaultConfig.apply {
                    targetSdk = libs.versions.targetSdk.get().toInt()
                }

                configureKotlinAndroid(this)

                configureBuildTypes(
                    commonExtension = this,
                    extensionType = ExtensionType.LIBRARY
                )
            }
        }
    }
}