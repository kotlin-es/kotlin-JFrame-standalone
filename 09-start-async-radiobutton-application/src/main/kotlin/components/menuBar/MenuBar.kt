package components.progressBar

import components.Component
import java.awt.event.ActionEvent
import javax.swing.JComponent
import javax.swing.JMenu
import javax.swing.JMenuBar

/**
 * Created by vicboma on 05/12/16.
 */
interface MenuBar : Component<JMenuBar> {
    fun addMenu(list: MutableList<JComponent?>): MenuBar
    fun addMenu(name: JComponent?): MenuBar
    fun createSubMenu(parent: JMenu?, child: JComponent?): MenuBar
    fun createSubMenu(parent: JMenu?, child: MutableList<JComponent?>): MenuBar
    fun createMenu(map: Map<String, Map<String, (ActionEvent) -> Unit>>): JMenu ?
    fun addSeparator(menu: JMenu?): MenuBar
}