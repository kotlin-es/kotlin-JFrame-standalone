package menuBar.child.dialog

import components.dialog.confirm.ConfirmImpl
import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.Menu
import components.progressBar.MenuBarImpl
import components.progressBar.MenuImpl
import components.progressBar.MenuItemImpl
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.JFrame
import javax.swing.JOptionPane


/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuConfirm(frame: JFrame): Menu {

    var listButtons = Arrays.asList(

            MenuItemImpl.create("No - Yes", KeyEvent.VK_1, {
                ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nNo - Yes"), JOptionPane.YES_NO_OPTION)
                        .showDialog({
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed Yes button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        }, {
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed No button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        })
            }),

            MenuItemImpl.create("Cancel - No", KeyEvent.VK_2, {
                ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nCancel - Ok"), JOptionPane.OK_CANCEL_OPTION)
                        .showDialog({
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed Ok button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        }, {

                        }, {
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed Cancel button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        })
            }),

            MenuItemImpl.create("Cancel - No - Yes", KeyEvent.VK_3, {
                ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 3 buttons\nCancel - No - Yes"), JOptionPane.YES_NO_CANCEL_OPTION)
                        .showDialog({
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed Yes button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        }, {
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed No button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        }, {
                            MessageImpl.create(frame, Pair("Basic Message", "Pressed Cancel button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                        })
            }))

    return MenuImpl
            .create("Confirm")
            .addMenuItem(listButtons)
            .putSeparator()
            .addMenuItem(
                MenuItemImpl.create("No - Yes Custom Message", KeyEvent.VK_4, {
                    ConfirmImpl(frame, Pair("Custom Confirm Dialog Message", "<html>The magic <span style='color:green'>color</span> </html>"), JOptionPane.YES_NO_OPTION)
                            .showDialog({
                                MessageImpl.create(frame, Pair("Basic Message", "Pressed Yes button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                            }, {
                                MessageImpl.create(frame, Pair("Basic Message", "Pressed No button!!!"), EnumDialog.PLAIN_MESSAGE).showDialog()
                            })
                })
            )
}

