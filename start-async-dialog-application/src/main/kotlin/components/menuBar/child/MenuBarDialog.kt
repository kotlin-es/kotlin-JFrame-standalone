package components.menuBar.child

import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuDialog(): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : HashMap<String, HashMap<String, (ActionEvent) -> Unit>>() {
        init {
            put("Dialog",
                    object : HashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("New", {  })
                            put("Open", {  })
                            put("Open Url", {  })
                            put("Open Recent", { })
                            put("Close Project", {  })
                            put("---", {})
                            put("Power Save Mode", { })
                        }
                    }
            )
        }
    }
}
