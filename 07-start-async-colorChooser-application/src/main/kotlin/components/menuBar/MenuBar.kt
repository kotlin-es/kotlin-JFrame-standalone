package components.progressBar

import components.Component
import java.awt.event.ActionEvent
import javax.swing.JMenu
import javax.swing.JMenuBar

/**
 * Created by vicboma on 05/12/16.
 */
interface MenuBar : Component<JMenuBar> {
    fun addMenu(list : MutableList<JMenu?>) : MenuBar
    fun addMenu(name : JMenu?) : MenuBar
    fun createSubMenu(parent : JMenu?, child : JMenu?) : MenuBar
    fun createSubMenu(parent : JMenu?, child : MutableList<JMenu?>) : MenuBar
    fun createMenu(map : Map<String,Map<String, (ActionEvent)-> Unit>>): JMenu ?
}