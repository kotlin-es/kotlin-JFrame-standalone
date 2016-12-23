package components.menuBar.child

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.*
import java.awt.event.KeyEvent
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarFile(frame: JFrame): Menu {
        return MenuImpl
                .create("File")
                .addMenuItem(RadioItemImpl.create("Open", true))
                .addMenuItem(RadioItemImpl.create("Open Url", false))
                .addMenuItem(RadioItemImpl.create("Open Recent", false))
                .putSeparator()
                .addMenuItem(CheckItemImpl.create("Import Setting", true))
                .addMenuItem(CheckItemImpl.create("Export Setting", false))
                .addMenuItem(CheckItemImpl.create("Setting Repository", true))
                .putSeparator()
                .addMenuItem(MenuItemImpl.create("Exit", KeyEvent.VK_E,{
                    MessageImpl.create(frame, Pair("Exit Message","GoodBye"), EnumDialog.PLAIN_MESSAGE).showDialog()
                    System.exit(0)
                }))
}