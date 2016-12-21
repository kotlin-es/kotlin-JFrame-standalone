package src.configuration

import components.progressBar.MenuBar
import components.progressBar.Panel
import components.progressBar.StatusBar
import java.util.*

/**
 * Created by vicboma on 02/12/16.
 */
class ConfigurationImpl internal constructor(override val display: Display, override val panel: ArrayList<Panel>, override val menuBar: MenuBar, override val statusBar: StatusBar) : Configuration {

    companion object {

        fun create(display: Display, panel: ArrayList<Panel>, menuBar: MenuBar, statusBar: StatusBar): Configuration {
            return ConfigurationImpl(display, panel, menuBar,statusBar)
        }
    }
}

