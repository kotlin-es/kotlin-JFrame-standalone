package components.progressBar

import javax.swing.AbstractButton
import javax.swing.ButtonGroup

/**
 * Created by vicboma on 05/12/16.
 */
class GroupImpl<T> internal constructor(private val list : MutableList<T>) : javax.swing.ButtonGroup(), Group{

    companion object {
        fun create<T>(list : MutableList<T>): Group {
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
