package components.menuBar.child

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.ColorChooserImpl
import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarChooser(frame : JFrame): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Chooser",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("Color", { ColorChooserImpl.create().showDialog {
                                MessageImpl.create(frame, Pair("Basic Message","Selected color : ".plus(it)), EnumDialog.PLAIN_MESSAGE).showDialog()
                            } })
                        }
                    }
            )
        }
    }
}