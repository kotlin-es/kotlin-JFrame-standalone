package components.menuBar.child

import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.*
import java.awt.Color
import java.awt.event.KeyEvent
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuChooser(frame : JFrame): Menu {
    return MenuImpl
            .create("Chooser")
            .addMenuItem(MenuItemImpl.create("Color", KeyEvent.VK_C,{
                ColorChooserImpl.create("Choose a Color", Color.black).showDialog {
                    MessageImpl.create(frame, Pair("Basic Message","Selected color : ".plus(it)), EnumDialog.PLAIN_MESSAGE).showDialog()
                }
            }))
            .addMenuItem(MenuItemImpl.create("File", KeyEvent.VK_F, {
                FileChooserImpl.create(frame).showDialog({
                    MessageImpl.create(frame, Pair("Basic Message", "Selected : ".plus(it)), EnumDialog.PLAIN_MESSAGE).showDialog()
                })
            })
            )
}