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
class PanelImpl internal constructor( val layoutManager: LayoutManager, override val progressBar: ProgressBar?, override val textArea: TextArea) : JPanel(layoutManager) , Panel {

    companion object {
        fun create(layout: LayoutManager,progressBar: ProgressBar?, textArea: TextArea): Panel {
            return PanelImpl(layout,progressBar, textArea)
        }
    }

    init{
        setBorder(BorderFactory.createTitledBorder(""))
        setAlignmentX(Component.CENTER_ALIGNMENT)
        setLayout(BoxLayout(this, BoxLayout.Y_AXIS))
        add(progressBar?.component()!!)
        add(textArea.component())
    }

    override fun component() : JComponent =  this

}
