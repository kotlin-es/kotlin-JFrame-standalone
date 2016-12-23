package src.configuration

import components.progressBar.MenuBar
import components.progressBar.MenuBarImpl
import components.progressBar.Panel
import components.progressBar.StatusBar
import java.util.*

/**
 * Created by vicboma on 02/12/16.
 */
interface Configuration {
    val panel: ArrayList<Panel>?
    val display: Display?
    val menuBar: MenuBarImpl?
    val statusBar: StatusBar?
}
