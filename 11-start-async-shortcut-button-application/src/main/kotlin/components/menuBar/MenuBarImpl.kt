package components.progressBar

import java.awt.event.ActionEvent
import javax.swing.JComponent
import javax.swing.JMenu
import javax.swing.JMenuBar



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

    override fun createMenu(map : Map<String, Map<String, Map<Int, (ActionEvent)-> Unit>>> ) : JMenu? {
         fun createMenu(nameMenu: String, map: Map<String, Map<Int, (ActionEvent)-> Unit>>) : JMenu? {
             fun createMenu(nameMenu :  String, nameItem :String, map : Map<Int, (ActionEvent)-> Unit>) : JMenu? {
                 val menu = JMenu(nameMenu)
                 for (entry in map.entries) {
                     when {
                         nameItem.subSequence(0, 3) == "---" -> menu.addSeparator()
                         else -> {
                            val menuItem = MenuItemImpl.create(nameItem, entry.key, entry.value)
                            menu.add(menuItem.component())
                         }
                     }
                 }
                 return menu
             }

             var res : JMenu? = null
             for (entry in map.entries){
                 val item = entry.key
                 val map = entry.value
                 res = createMenu(nameMenu,item, map)
             }

             return res
         }

         var res : JMenu? = null
         for(entry in map.entries){
             val menuBarMenu = entry.key
             val menuBarItems = entry.value
             res = createMenu(menuBarMenu, menuBarItems)
         }

         return res
     }

    override fun addMenu(name : JComponent?) : MenuBar {
        this.add(name)
        return this
    }

    override fun addMenu(list : MutableList<JComponent?>) : MenuBar {
        for( it in list)
            this.addMenu(it)

        return this
    }

    override fun createSubMenu<T:JComponent>(parent : JMenu?, child : T?) : MenuBar {
        parent?.add(child)
        return this
    }

    override fun createSubMenu<T:JComponent>(parent : JMenu?, child : MutableList<T?>) : MenuBar {
        for( it in child)
            parent?.add(it)

        return this
    }

    override fun addSeparator(menu : JMenu?) : MenuBar {
        menu?.addSeparator()
        return this
    }

    override fun component(): JMenuBar  = this

}


