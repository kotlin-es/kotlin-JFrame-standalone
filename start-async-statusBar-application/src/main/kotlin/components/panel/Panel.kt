package components.progressBar

import components.Component
import javax.swing.JComponent

/**
 * Created by vicboma on 05/12/16.
 */
interface Panel : Component<JComponent> {
    val progressBar : ProgressBar?
    val textArea : TextArea?
}