package components.menuBar.child

import components.dialog.confirm.InputImpl
import components.dialog.message.EnumDialog
import components.dialog.message.MessageImpl
import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.JFrame

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarInput(frame: JFrame): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Input",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("Basic", {
                                InputImpl.create(frame, Pair("Basic", "Basic Input"), EnumDialog.PLAIN_MESSAGE).showDialog({
                                    MessageImpl.create(frame, Pair("Basic Message","$it"), EnumDialog.PLAIN_MESSAGE).showDialog()
                                })
                            })
                            put("Information", {
                                InputImpl.create(frame, Pair("Information", "Information Input"), EnumDialog.INFORMATION_MESSAGE).showDialog({
                                    MessageImpl.create(frame, Pair("Information Message","$it"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                                })
                            })
                            put("Warning", {
                                InputImpl.create(frame, Pair("Warning", "Warning Input"), EnumDialog.WARNING_MESSAGE).showDialog({
                                    MessageImpl.create(frame, Pair("Warning Message","$it"), EnumDialog.WARNING_MESSAGE).showDialog()
                                })
                            })
                            put("Error", {
                                InputImpl.create(frame, Pair("Error", "Error Input"), EnumDialog.ERROR_MESSAGE).showDialog({
                                    MessageImpl.create(frame, Pair("Error Message","$it"), EnumDialog.ERROR_MESSAGE).showDialog()
                                })
                            })
                            put("Custom", {
                                val theDays = Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday" ) as MutableList<Object>
                                InputImpl.create( frame, Pair("Today is: ", "Custom Input"), EnumDialog.INFORMATION_MESSAGE, null, ArrayList(theDays), theDays[0]).showDialog({
                                    MessageImpl.create(frame, Pair("Custom Message","$it"), EnumDialog.INFORMATION_MESSAGE).showDialog()
                                })
                            })
                        }
                    }
            )
        }
    }
}
