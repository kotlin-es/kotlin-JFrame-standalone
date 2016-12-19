package components.progressBar

import javax.swing.AbstractButton
import javax.swing.ButtonGroup
import javax.swing.JComponent

/**
 * Created by vicboma on 05/12/16.
 */
class GroupImpl internal constructor(private val list : MutableList<JComponent>) : javax.swing.ButtonGroup(), Group{

    companion object {
        fun create(list : MutableList<JComponent>): Group {
            return GroupImpl(list)
        }
    }

    init{
        for( it in list){
            this.add(it as AbstractButton)
        }
    }


    override fun component() : ButtonGroup =  this

}
