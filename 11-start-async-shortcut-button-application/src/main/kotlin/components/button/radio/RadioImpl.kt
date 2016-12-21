package components.progressBar

import java.awt.Component
import java.awt.LayoutManager
import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Created by vicboma on 05/12/16.
 */
class RadioImpl internal constructor() : javax.swing.JRadioButton() , Radio{

    companion object {
        fun create(): Radio {
            return RadioImpl()
        }
    }

    init{

    }

    override fun component() : JComponent =  this

}
