package src.configuration

import components.progressBar.Panel

/**
 * Created by vicboma on 02/12/16.
 */
class ConfigurationImpl internal constructor(override val display: Display, override val panel: Panel) : Configuration {

    companion object {

        fun create(display: Display, panel: Panel): Configuration {
            return ConfigurationImpl(display, panel)
        }
    }
}
