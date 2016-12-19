package components.menuBar.child.dialog

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.net.URL
import java.util.*
import java.util.concurrent.CompletableFuture
import javax.swing.ImageIcon
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarMessage(frame: JFrame): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Message",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("Basic", {
                                MessageImpl.create(frame, Pair("Basic", "Basic Message"), EnumDialog.PLAIN_MESSAGE).showDialog()
                            })
                            put("Information", {
                                MessageImpl.create(frame, Pair("Information", "Information Message"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                            })
                            put("Warning", {
                                MessageImpl.create(frame, Pair("Warning", "Warning Message"), EnumDialog.WARNING_MESSAGE).showDialog()
                            })
                            put("Error", {
                                MessageImpl.create(frame, Pair("Error", "Error Message"), EnumDialog.ERROR_MESSAGE).showDialog()
                            })
                            put("Custom", {
                                CompletableFuture.runAsync {
                                    MessageImpl.create(frame, Pair("Custom", "Custom Message Download Async Image"), EnumDialog.INFORMATION_MESSAGE, ImageIcon(URL("https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"))).showDialog()
                                }
                            })
                        }
                    }
            )
        }
    }
}
