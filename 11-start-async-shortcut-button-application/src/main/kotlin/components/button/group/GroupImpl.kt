package components.progressBar

import javax.swing.AbstractButton

/**
 * Created by vicboma on 05/12/16.
 */
class GroupImpl<T> internal constructor(private val list : List<T>) : javax.swing.ButtonGroup(), Group{

    companion object {
        fun create<T>(list : List<T>): Group {
            return GroupImpl(list)
        }
    }

    init{
        for( it in list){
            this.add(it as AbstractButton)
        }
    }
}
