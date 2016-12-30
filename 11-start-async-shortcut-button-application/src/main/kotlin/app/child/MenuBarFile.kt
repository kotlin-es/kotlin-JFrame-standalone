package components.menuBar.child

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.*
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuFile(frame: JFrame): Menu {

    val radioButtonList = Arrays.asList(
            RadioItemImpl.create("Open", true),
            RadioItemImpl.create("Open Url", false),
            RadioItemImpl.create("Open Recent", false)
    )

    val checkButtonList = Arrays.asList(
            CheckItemImpl.create("Import Setting", true),
            CheckItemImpl.create("Export Setting", false),
            CheckItemImpl.create("Setting Repository", true)
    )

    val radioGroup = GroupImpl.create(radioButtonList)

    return MenuImpl
            .create("File")
            .addMenuItem(radioButtonList)
            .putSeparator()
            .addMenuItem(checkButtonList)
            .putSeparator()
            .addMenuItem(MenuItemImpl.create("Exit", KeyEvent.VK_E,{
                MessageImpl.create(frame, Pair("Exit Message","GoodBye"), EnumDialog.PLAIN_MESSAGE).showDialog()
                System.exit(0)
            }))
}