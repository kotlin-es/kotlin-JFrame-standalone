package components.progressBar

import javax.swing.JComponent

/**
 * Created by vicboma on 05/12/16.
 */
class RadioItemImpl internal constructor(private val _name: String, private val _isSelected : Boolean) : javax.swing.JRadioButtonMenuItem(_name) , RadioItem {

    companion object {
        fun create(name: String, isSelected : Boolean): RadioItem {
            return RadioItemImpl(name, isSelected)
        }
    }

    init{
        this.isSelected = _isSelected
    }

    override fun component() : JComponent =  this

}
