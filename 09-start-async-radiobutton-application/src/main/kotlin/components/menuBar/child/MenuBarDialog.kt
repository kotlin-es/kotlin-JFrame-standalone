package components.menuBar.child

import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarDialog(): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Dialog",LinkedHashMap<String, (ActionEvent) -> Unit>())
        }
    }
}