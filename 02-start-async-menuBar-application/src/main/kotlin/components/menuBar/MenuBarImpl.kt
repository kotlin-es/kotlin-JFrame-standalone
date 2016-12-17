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
        val createMenuFile = MenuFile()
        val createMenuDialog = createMenu("Dialogs")
        createMenuDialog.isEnabled = false
        addMenu(createMenuDialog, createMenuFile)
    }

    private fun addMenu(createMenuDialog: JMenu, createMenuFile: JMenu) {
        val menuList = ArrayList<JMenu>(Arrays.asList(createMenuFile, createMenuDialog))
        menuList.forEach {
            this.add(it)
        }
    }

    private fun MenuFile(): JMenu {
        val fields = ArrayList<String>(Arrays.asList("New", "Open", "Open Url", "Open Recent", "Close Project", "---", "Power Save Mode"))
        val createMenuFile = createMenu("File", fields)
        return createMenuFile
    }

    private fun createMenu(nameMenu: String) : JMenu {
        return createMenu(nameMenu,null)
    }

    private fun createMenu(nameMenu: String, menuItemList: ArrayList<String>?) : JMenu {
        val menu = JMenu(nameMenu)

        if(menuItemList == null)
            return menu

        for(it in menuItemList){
            when (it) {
                "---" -> menu.addSeparator()
                else  -> {
                    val menuItem = JMenuItem(it)
                    menuItem.addActionListener {
                        var item = (it.source as JMenuItem)
                        item.text = it.actionCommand.plus("  -  (Clicked!)")
                        item.removeActionListener(item.actionListeners.get(0))
                    }
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


