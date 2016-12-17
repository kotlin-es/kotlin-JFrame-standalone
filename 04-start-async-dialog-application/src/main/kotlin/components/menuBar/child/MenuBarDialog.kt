package components.menuBar.child

import components.dialog.DialogImpl
import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.JFrame
import javax.swing.JOptionPane

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuDialog(frame : JFrame): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("Dialogs",
                    object : LinkedHashMap<String, (ActionEvent) -> Unit>() {
                        init {
                            put("No - Yes", {
                              //  CompletableFuture.runAsync {
                                    DialogImpl(frame, Pair("Basic Dialog", "Dialog with 2 buttons\nNo - Yes"), JOptionPane.YES_NO_OPTION)
                                            .showConfirmDialog({
                                                System.out.println("Pressed Yes button!!!")
                                            }, {
                                                System.out.println("Pressed No button!!!")
                                            })
                              //  }
                            })

                            put("Cancel - No", {
                             //   CompletableFuture.runAsync {
                                    DialogImpl(frame, Pair("Basic Dialog", "Dialog with 2 buttons\nCancel - Ok"), JOptionPane.OK_CANCEL_OPTION)
                                            .showConfirmDialog({
                                                System.out.println("Pressed Ok button!!!")
                                            }, {

                                            }, {
                                                System.out.println("Pressed Cancel button!!!")
                                            })
                            //    }
                            })

                            put("Cancel - No - Yes", {
                             //   CompletableFuture.runAsync {
                                    DialogImpl(frame, Pair("Basic Dialog", "Dialog with 3 buttons\nCancel - No - Yes"), JOptionPane.YES_NO_CANCEL_OPTION)
                                            .showConfirmDialog({
                                                System.out.println("Pressed Yes button!!!")
                                            }, {
                                                System.out.println("Pressed No button!!!")
                                            }, {
                                                System.out.println("Pressed Cancel button!!!")
                                            })
                            //     }
                            })

                            put("----", {})

                            put("No - Yes Custom Message", {
                                //   CompletableFuture.runAsync {
                                DialogImpl(frame, Pair("Custom Dialog Message","<html>The magic <span style='color:green'>color</span> </html>"), JOptionPane.YES_NO_OPTION)
                                        .showConfirmDialog({
                                            System.out.println("Pressed Yes button!!!")
                                        }, {
                                            System.out.println("Pressed No button!!!")
                                        })
                                //     }
                            })

                        }
                    }
            )
        }
    }
}

