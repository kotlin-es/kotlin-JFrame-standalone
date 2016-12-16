package components.progressBar

import java.awt.Color
import javax.swing.JColorChooser



/**
 * Created by vicboma on 05/12/16.
 */
class ColorChooserImpl internal constructor() : JColorChooser(), ColorChooser {

    companion object {
        fun create() : ColorChooser {
            return ColorChooserImpl()
        }
    }

    init {

    }

    override fun showDialog(callback: (color: Color) -> Unit) {
        val color = JColorChooser.showDialog(null, "Choose a Color", Color.black);
        callback.invoke(color)
    }

    override fun component(): JColorChooser  = this

}


