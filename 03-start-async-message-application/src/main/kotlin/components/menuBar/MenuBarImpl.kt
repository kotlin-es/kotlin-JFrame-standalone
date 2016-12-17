package components.progressBar

import components.dialog.message.EnumMessage
import components.dialog.message.MessageImpl
import java.awt.Frame
import java.awt.event.ActionEvent
import java.net.URL
import java.util.*
import java.util.concurrent.CompletableFuture
import javax.swing.ImageIcon
import javax.swing.JMenu
import javax.swing.JMenuBar
import javax.swing.JMenuItem


/**
 * Created by vicboma on 05/12/16.
 */
class MenuBarImpl internal constructor(val frame: Frame) : JMenuBar(), MenuBar {

    companion object {
        fun create(frame: Frame): MenuBar {
            return MenuBarImpl(frame)
        }
    }

    init {
        val createMenuFile = MenuFile()
        val createMenuDialog = JMenu("Dialogs")
        createMenuDialog.isEnabled = false
        val createMenuMessage = MenuMessage()
        addMenu(Arrays.asList(createMenuFile, createMenuMessage, createMenuDialog))
    }

    private fun addMenu(menuList: List<JMenu>) {
        ArrayList(menuList).forEach {
            this.add(it)
        }
    }

    private fun MenuFile(): JMenu {
        val fields = Arrays.asList("New", "Open", "Open Url", "Open Recent", "Close Project", "---", "Power Save Mode")
        val map = object : HashMap<String, (ActionEvent) -> Unit>() {
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
        return createMenu("File", map)
    }

    private fun MenuMessage(): JMenu {
        val map = object : HashMap<String, (ActionEvent) -> Unit>() {
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

        return createMenu("Messages", map)
    }

    private fun createMenu(nameMenu: String, map: Map<String, (ActionEvent) -> Unit>): JMenu {
        val menu = JMenu(nameMenu)

        for (entry in map.entries) {
            when (entry.key) {
                "---" -> menu.addSeparator()
                else -> {
                    val menuItem = JMenuItem(entry.key)
                    menuItem.addActionListener(entry.value)
                    menu.add(menuItem)
                }
            }
        }

        return menu
    }

    private fun clickAction(it: ActionEvent) {
        var item = (it.source as JMenuItem)
        item.text = it.actionCommand.plus("  -  (Clicked!)")
        item.removeActionListener(item.actionListeners.get(0))
    }

    override fun component(): JMenuBar {
        return this
    }
}


