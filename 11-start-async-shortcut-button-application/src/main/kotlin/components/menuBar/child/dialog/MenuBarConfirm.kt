package menuBar.child.dialog

import components.dialog.confirm.ConfirmImpl
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
    return MenuImpl
            .create("Confirm")
            .addMenuItem(Arrays.asList(

                    MenuItemImpl.create("No - Yes", KeyEvent.VK_N, {
                        ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nNo - Yes"), JOptionPane.YES_NO_OPTION)
                                .showDialog({
                                    System.out.println("Pressed Yes button!!!")
                                }, {
                                    System.out.println("Pressed No button!!!")
                                })
                    }),

                    MenuItemImpl.create("Cancel - No", KeyEvent.VK_C, {
                        ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nCancel - Ok"), JOptionPane.OK_CANCEL_OPTION)
                                .showDialog({
                                    System.out.println("Pressed Ok button!!!")
                                }, {

                                }, {
                                    System.out.println("Pressed Cancel button!!!")
                                })
                    }),

                    MenuItemImpl.create("Cancel - No - Yes", KeyEvent.VK_C, {
                        ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 3 buttons\nCancel - No - Yes"), JOptionPane.YES_NO_CANCEL_OPTION)
                                .showDialog({
                                    System.out.println("Pressed Yes button!!!")
                                }, {
                                    System.out.println("Pressed No button!!!")
                                }, {
                                    System.out.println("Pressed Cancel button!!!")
                                })
                    }))
            )
            .putSeparator()
            .addMenuItem(
                MenuItemImpl.create("No - Yes Custom Message", KeyEvent.VK_N, {
                    ConfirmImpl(frame, Pair("Custom Confirm Dialog Message", "<html>The magic <span style='color:green'>color</span> </html>"), JOptionPane.YES_NO_OPTION)
                            .showDialog({
                                System.out.println("Pressed Yes button!!!")
                            }, {
                                System.out.println("Pressed No button!!!")
                            })
                })
            )
}

