package components.progressBar

import java.util.*
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem

/**
 * Created by vicboma on 05/12/16.
 */
class MenuBarImpl internal constructor() : JMenuBar(), MenuBar {

    companion object {
        fun create(): MenuBar {
            return MenuBarImpl()
        }
    }

    init{
        val fields = ArrayList<String>(Arrays.asList("New","Open","Open Url","Open Recent","Close Project","---", "Power Save Mode"))
        val menu = createMenu("File", fields)
        this.add(menu)
    }

    private fun createMenu(nameMenu: String, menuItemList: ArrayList<String>) : JMenu {
        val menu = JMenu(nameMenu)

        for(it in menuItemList){
            when (it) {
                "---" -> menu.addSeparator()
                else  -> {
                    val menuItem = JMenuItem(it)
                    menu.add(menuItem)
                }
            }
        }
        return menu
    }

    override fun component() : JMenuBar {
        return this
    }
}
