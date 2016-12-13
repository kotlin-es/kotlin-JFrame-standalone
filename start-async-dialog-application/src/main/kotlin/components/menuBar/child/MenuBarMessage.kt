package components.menuBar.child

import components.message.EnumMessage
import components.message.MessageImpl
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
public fun MenuBarImpl.Companion.MenuBarMessage(frame : JFrame): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Messages",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("Basic", { MessageImpl.create(frame, Pair("Basic", "Basic Message"), EnumMessage.PLAIN_MESSAGE) })
                            put("Information", { MessageImpl.create(frame, Pair("Information", "Information Message"), EnumMessage.INFORMATION_MESSAGE) })
                            put("Warning", { MessageImpl.create(frame, Pair("Warning", "Warning Message"), EnumMessage.WARNING_MESSAGE) })
                            put("Error", { MessageImpl.create(frame, Pair("Error", "Error Message"), EnumMessage.ERROR_MESSAGE) })
                            put("Custom", {
                                CompletableFuture.runAsync {
                                    MessageImpl.create(frame, Pair("Custom", "Custom Message Download Async Image"), EnumMessage.INFORMATION_MESSAGE, ImageIcon(URL("https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png")))
                                }})
                        }
                    }
            )
        }
    }
}
