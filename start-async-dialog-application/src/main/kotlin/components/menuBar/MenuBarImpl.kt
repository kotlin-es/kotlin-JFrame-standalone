package components.progressBar

import java.awt.event.ActionEvent
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem


/**
 * Created by vicboma on 05/12/16.
 */
class MenuBarImpl internal constructor(val map : Map<String,Map<String, (ActionEvent)-> Unit>>) : JMenuBar(), MenuBar {

    companion object {
        fun create(map : Map<String,Map<String, (ActionEvent)-> Unit>> ) : MenuBar {
            return MenuBarImpl(map)
        }
    }

    init {
        for(entry in map.entries){
            val menuBarMenu = entry.key
            val menuBarItems = entry.value
            val menuBar = createMenu(menuBarMenu, menuBarItems)
            this.add(menuBar)
        }
    }


    private fun createMenu(nameMenu: String, map: Map<String, (ActionEvent) -> Unit>): JMenu {
        val menu = JMenu(nameMenu)

        for (entry in map.entries) {
            when (entry.key) {
                "---" -> menu.addSeparator()
                else -> {
                    val menuItem = JMenuItem(entry.key)
                    menuItem.addActionListener(entry.value)
                    menu.add(menuItem)
                }
            }
        }

        return menu
    }

    override fun component(): JMenuBar {
        return this
    }
}


