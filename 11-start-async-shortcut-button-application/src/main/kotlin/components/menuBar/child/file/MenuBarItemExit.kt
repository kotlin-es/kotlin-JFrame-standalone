package components.menuBar.child.file

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.MenuItemImpl
import java.awt.event.KeyEvent
import javax.swing.JComponent
import javax.swing.JFrame

/**
 * Created by vicboma on 21/12/16.
 */
public fun MenuItemImpl.Companion.MenuBarFileItemExit(frame: JFrame): JComponent {
    return MenuItemImpl.create("Exit", KeyEvent.VK_E,{
        MessageImpl.create(frame, Pair("Exit Message","GoodBye"), EnumDialog.PLAIN_MESSAGE).showDialog()
        System.exit(0)
    }).component()
}