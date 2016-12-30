package components.progressBar

import javax.swing.JComponent
import javax.swing.JMenu
import javax.swing.JMenuBar


/**
 * Created by vicboma on 05/12/16.
 */
class MenuBarImpl internal constructor(_name : String) : JMenuBar(), MenuBar {

    companion object {
        fun create(name: String): MenuBar {
            return MenuBarImpl(name)
        }

        fun create(): MenuBar {
            return MenuBarImpl("")
        }
    }

    init {
        this.name = _name
    }

    override fun createSubMenu(parent: MenuBar?, child: JComponent?): MenuBar {
        (parent as JMenu).add(child)
        return this
    }

    override fun createSubMenu(parent: MenuBar?, child: MutableList<JComponent?>): MenuBar {
        for (it in child)
            (parent as JMenu).add(it)

        return this
    }

    override fun addMenu(menu: Menu): MenuBar {
        this.add(menu as MenuImpl)
        return this
    }

    override fun addMenu(menuList: List<Menu>): MenuBar {
        for (it in menuList)
            this.addMenu(it)

        return this
    }

}


fun JMenuBar.visibility(opc:Boolean) =  this.components.forEach {
    it.isEnabled = opc
}

