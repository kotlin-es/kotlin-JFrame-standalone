package components.progressBar

import java.awt.event.ActionEvent
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem



/**
 * Created by vicboma on 05/12/16.
 */
class MenuBarImpl internal constructor() : JMenuBar(), MenuBar {

    companion object {
        fun create() : MenuBar {
            return MenuBarImpl()
        }
    }

    init {

    }

    override fun createMenu(map : Map<String,Map<String, (ActionEvent)-> Unit>>) : JMenu? {
        fun createMenu(nameMenu: String, map: Map<String, (ActionEvent) -> Unit>) : JMenu {
            val menu = JMenu(nameMenu)
            for (entry in map.entries) {
                when {
                    entry.key.subSequence(0, 3) == "---" -> menu.addSeparator()
                    else -> {
                        val menuItem = JMenuItem(entry.key)
                        menuItem.addActionListener(entry.value)
                        menu.add(menuItem)
                    }
                }
            }
            return menu
        }

        var res : JMenu? = null
        for(entry in map.entries){
           val menuBarMenu = entry.key
           val menuBarItems = entry.value
            res = createMenu(menuBarMenu, menuBarItems)
       }

        return res
    }

    override fun addMenu(name : JMenu?) : MenuBar {
        this.add(name)
        return this
    }

    override fun addMenu(list : MutableList<JMenu?>) : MenuBar {
        for( it in list)
            this.addMenu(it)

        return this
    }

    override fun createSubMenu(parent : JMenu?, child : JMenu?) : MenuBar {
        parent?.add(child)
        return this
    }

    override fun createSubMenu(parent : JMenu?, child : MutableList<JMenu?>) : MenuBar {
        for( it in child)
            parent?.add(it)

        return this
    }

    override fun component(): JMenuBar  = this

}


