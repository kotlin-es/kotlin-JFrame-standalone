package components.menuBar.child

import components.menuBar.child.dialog.MenuInput
import components.menuBar.child.dialog.MenuMessage
import components.progressBar.Menu
import components.progressBar.MenuBarImpl
import components.progressBar.MenuImpl
import menuBar.child.dialog.MenuConfirm
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuDialog(frame: JFrame): Menu {
    return MenuImpl
            .create("Dialog")
            .addMenuItem(MenuBarImpl.MenuMessage(frame))
            .addMenuItem(MenuBarImpl.MenuConfirm(frame))
            .addMenuItem(MenuBarImpl.MenuInput(frame))

}