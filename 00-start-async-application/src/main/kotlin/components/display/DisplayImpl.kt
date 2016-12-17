package src.configuration

import java.awt.Component
import java.awt.LayoutManager
import javax.swing.JFrame

/**
 * Created by vicboma on 02/12/16.
 */
class DisplayImpl internal constructor(override var title: String, override val widht: Int?, override val heigth: Int?, override val visible: Boolean?, override val closeOp: Int?, override val layout: LayoutManager?, override val location: Component?) : Display {

    companion object {

        fun create(title: String, widht: Int?, heigth: Int?, visible: Boolean?): Display {
            return DisplayImpl(title, widht, heigth, visible, JFrame.EXIT_ON_CLOSE, null, null)
        }

        fun create(title: String, widht: Int?, heigth: Int?, visible: Boolean?, closeOp: Int?): Display {
            return DisplayImpl(title, widht, heigth, visible, closeOp, null, null)
        }

        fun create(title: String, widht: Int?, heigth: Int?, visible: Boolean?, closeOp: Int?, layout: LayoutManager): Display {
            return DisplayImpl(title, widht, heigth, visible, closeOp, layout, null)
        }

        fun create(title: String, widht: Int?, heigth: Int?, visible: Boolean?, closeOp: Int?, layout: LayoutManager, location: Component): Display {
            return DisplayImpl(title, widht, heigth, visible, closeOp, layout, location)
        }
    }
}
