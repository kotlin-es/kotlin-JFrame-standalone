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
    fun createSubMenu<T:JComponent>(parent: JMenu?, child: T?): MenuBar
    fun createSubMenu<T:JComponent>(parent: JMenu?, child: MutableList<T?>): MenuBar
    fun createMenu(map : Map<String, Map<String, Map<Int, (ActionEvent)-> Unit>>> ) : JMenu?
    fun addSeparator(menu: JMenu?): MenuBar
}