package components.menuBar.child.dialog

import components.dialog.confirm.InputImpl
import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.Menu
import components.progressBar.MenuBarImpl
import components.progressBar.MenuImpl
import components.progressBar.MenuItemImpl
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuInput(frame: JFrame): Menu {
    val listButtons = Arrays.asList(

            MenuItemImpl.create("Basic", KeyEvent.VK_P, {
                InputImpl.create(frame, Pair("Basic", "Basic Input"), EnumDialog.PLAIN_MESSAGE).showDialog({
                    MessageImpl.create(frame, Pair("Basic Message", "$it"), EnumDialog.PLAIN_MESSAGE).showDialog()
                })
            }),

            MenuItemImpl.create("Information", KeyEvent.VK_O,{
                InputImpl.create(frame, Pair("Information", "Information Input"), EnumDialog.INFORMATION_MESSAGE).showDialog({
                    MessageImpl.create(frame, Pair("Information Message", "$it"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                })
            }),

            MenuItemImpl.create("Warning", KeyEvent.VK_U, {
                InputImpl.create(frame, Pair("Warning", "Warning Input"), EnumDialog.WARNING_MESSAGE).showDialog({
                    MessageImpl.create(frame, Pair("Warning Message", "$it"), EnumDialog.WARNING_MESSAGE).showDialog()
                })
            }),

            MenuItemImpl.create("Error", KeyEvent.VK_I ,{
                InputImpl.create(frame, Pair("Error", "Error Input"), EnumDialog.ERROR_MESSAGE).showDialog({
                    MessageImpl.create(frame, Pair("Error Message", "$it"), EnumDialog.ERROR_MESSAGE).showDialog()
                })
            }),

            MenuItemImpl.create("Custom", KeyEvent.VK_Y , {
                val theDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday") as MutableList<Object>
                InputImpl.create(frame, Pair("Today is: ", "Custom Input"), EnumDialog.INFORMATION_MESSAGE, null, ArrayList(theDays), theDays[0]).showDialog({
                    MessageImpl.create(frame, Pair("Custom Message", "$it"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                })
            })
    )

    return MenuImpl
            .create("Input")
            .addMenuItem(listButtons)
}
