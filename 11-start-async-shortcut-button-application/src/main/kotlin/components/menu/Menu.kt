package components.progressBar

import java.awt.Component
import javax.swing.JComponent

/**
 * Created by vicboma on 15/12/16.
 */
interface Menu : MenuItem {
    fun addMenuItem(name: Component?): Menu
    fun addMenuItem(name: JComponent?): Menu
    fun addMenuItem(name: MenuItem?): Menu
    fun addMenuItem(list: MutableList<MenuItem?>): Menu
    fun putSeparator() : Menu
}