package components.progressBar

import javax.swing.JComponent

/**
 * Created by vicboma on 05/12/16.
 */
interface MenuBar {
    fun createSubMenu(parent: MenuBar?, child: JComponent?): MenuBar
    fun createSubMenu(parent: MenuBar?, child: MutableList<JComponent?>): MenuBar
    fun addMenu(menuList: List<Menu>) : MenuBar
    fun addMenu(menu: Menu) : MenuBar
}