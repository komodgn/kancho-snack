import com.android.build.api.dsl.ApplicationExtension
import com.komodgn.snack.convention.Plugins
import com.komodgn.snack.convention.configureKotlinAndroid
import com.komodgn.snack.convention.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.run {
                apply(Plugins.ANDROID_APPLICATION)
                apply(Plugins.KOTLIN_ANDROID)
            }

            extensions.configure<ApplicationExtension> {
                defaultConfig {
                    applicationId = libs.versions.applicationId.toString()
                    targetSdk = libs.versions.targetSdk.get().toInt()
                    versionCode = libs.versions.versionCode.get().toInt()
                    versionName = libs.versions.versionName.toString()
                }

                configureKotlinAndroid(this)
            }
        }
    }
}