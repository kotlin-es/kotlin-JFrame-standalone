package components.progressBar

import components.Component
import components.Renderable
import javax.swing.JPanel

/**
 * Created by vicboma on 05/12/16.
 */
interface StatusBar : Component<JPanel> , Renderable {
    companion object {
        val TEXT: String = " A status bar is a horizontal window at the bottom of a parent window."
    }
}