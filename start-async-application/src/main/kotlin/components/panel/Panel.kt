package components.progressBar

import components.Component

/**
 * Created by vicboma on 05/12/16.
 */
interface Panel : Component {
    val progressBar : ProgressBar?
    val textArea : TextArea?
}