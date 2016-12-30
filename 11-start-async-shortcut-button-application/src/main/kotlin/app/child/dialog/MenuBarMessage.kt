package components.menuBar.child.dialog

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.Menu
import components.progressBar.MenuBarImpl
import components.progressBar.MenuImpl
import components.progressBar.MenuItemImpl
import java.awt.event.KeyEvent
import java.net.URL
import java.util.*
import java.util.concurrent.CompletableFuture
import javax.swing.ImageIcon
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuMessage(frame: JFrame): Menu {
    return MenuImpl
            .create("Message")
            .addMenuItem(Arrays.asList(

                    MenuItemImpl.create("Basic", KeyEvent.VK_L, {
                        MessageImpl.create(frame, Pair("Basic", "Basic Message"), EnumDialog.PLAIN_MESSAGE).showDialog()
                    }) ,

                    MenuItemImpl.create("Information", KeyEvent.VK_K, {
                        MessageImpl.create(frame, Pair("Information", "Information Message"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                    }) ,

                    MenuItemImpl.create("Warning", KeyEvent.VK_J, {
                        MessageImpl.create(frame, Pair("Warning", "Warning Message"), EnumDialog.WARNING_MESSAGE).showDialog()
                    }) ,

                    MenuItemImpl.create("Error", KeyEvent.VK_H, {
                        MessageImpl.create(frame, Pair("Error", "Error Message"), EnumDialog.ERROR_MESSAGE).showDialog()
                    }) ,

                    MenuItemImpl.create("Custom", KeyEvent.VK_G, {
                        CompletableFuture.runAsync {
                            MessageImpl.create(frame, Pair("Custom", "Custom Message Download Async Image"), EnumDialog.INFORMATION_MESSAGE, ImageIcon(URL("https://kotlinlang.org/assets/images/open-graph/kotlin_250x250.png"))).showDialog()
                        }
                    })
            ))
}