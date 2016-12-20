package components.progressBar

import components.Renderable
import java.awt.LayoutManager
import javax.swing.BorderFactory
import javax.swing.BoxLayout
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * Created by vicboma on 05/12/16.
 */
class PanelImpl internal constructor(private val layoutManager: LayoutManager, private val pair: Pair<JComponent,TextArea>) : JPanel(layoutManager) , Panel {

    companion object {
        fun create(layout: LayoutManager,pair: Pair<JComponent,TextArea>): Panel {
            return PanelImpl(layout,pair)
        }
    }

    init{
        setBorder(BorderFactory.createTitledBorder(""))
        setAlignmentX(java.awt.Component.CENTER_ALIGNMENT)
        setLayout(BoxLayout(this, BoxLayout.Y_AXIS))


        this.add(pair.first)
        this.add(pair.second.component())

    }

    override fun asyncUI() {
        (pair.first as Renderable).asyncUI()
        pair.second.asyncUI()
    }

    override fun component() : JPanel = this

}
