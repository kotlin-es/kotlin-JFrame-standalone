package components.progressBar

import components.Component
import javax.swing.JComponent

/**
 * Created by vicboma on 15/12/16.
 */
interface MenuItem : Component<JComponent> {

    companion object{
        val NONE = -1
    }
}