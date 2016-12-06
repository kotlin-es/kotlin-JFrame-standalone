package components.progressBar

import components.Component
import components.Renderable

/**
 * Created by vicboma on 05/12/16.
 */
interface TextArea : Renderable, Component {
    companion object {
        val TEXT = "        Hello World!!!!\n        Asynchronous\n          Application "
    }
}