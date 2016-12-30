package components.progressBar

import java.awt.Component
import javax.swing.JComponent
import javax.swing.JMenu

/**
 * Created by vicboma on 15/12/16.
 */
class MenuImpl internal constructor(private val _name: String ) : JMenu(_name) , Menu {

    companion object {
        fun create() : Menu {
            return MenuImpl("")
        }

       fun create(name : String) : Menu {
           return MenuImpl(name)
       }
    }

    init{

    }

    override fun addMenuItem(name : Component?) : Menu {
        this.add(name)
        return this
    }

    override fun addMenuItem(name : JComponent?) : Menu {
        this.add(name)
        return this
    }

    override fun addMenuItem(name : MenuItem?) : Menu {
        this.add(name as JComponent)
        return this
    }

    override fun addMenuItem(list : MutableList<MenuItem?>) : Menu {
        for( it in list)
            this.addMenuItem(it)

        return this
    }

    override fun putSeparator() : Menu {
        this.addSeparator()
        return this
    }
}
