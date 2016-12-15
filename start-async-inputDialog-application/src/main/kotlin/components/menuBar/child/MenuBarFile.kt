package components.menuBar.child

import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.JMenuItem

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarFile(): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("File",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("New", { clickAction (it) })
                            put("Open", { clickAction (it) })
                            put("Open Url", { clickAction (it) })
                            put("Open Recent", { clickAction (it) })
                            put("Close Project", { clickAction (it) })
                            put("---", { clickAction (it) })
                            put("Power Save Mode", { })
                        }
                    }
            )
        }
    }
}


private fun clickAction(it: ActionEvent) {
    var item = (it.source as JMenuItem)
    item.text = it.actionCommand.plus("  -  (Clicked!)")
    item.removeActionListener(item.actionListeners.get(0))
}