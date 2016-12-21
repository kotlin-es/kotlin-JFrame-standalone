package components.menuBar.child.dialog

import components.dialog.confirm.ConfirmImpl
import components.progressBar.MenuBarImpl
import components.progressBar.MenuItem
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import java.util.*
import javax.swing.JFrame
import javax.swing.JOptionPane

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarConfirm(frame: JFrame): Map<String, Map<String, Map<Int, (ActionEvent) -> Unit>>> {
    return object : LinkedHashMap<String, Map<String, Map<Int, (ActionEvent) -> Unit>>> () {
        init {
            put("Confirm",
                object : LinkedHashMap<String, Map<Int, (ActionEvent) -> Unit>>() {
                    init {
                        put("No - Yes", object : LinkedHashMap<Int, (ActionEvent) -> Unit>() {
                            init {
                                put(KeyEvent.VK_N, {
                                        ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nNo - Yes"), JOptionPane.YES_NO_OPTION)
                                                .showDialog({
                                                    System.out.println("Pressed Yes button!!!")
                                                }, {
                                                    System.out.println("Pressed No button!!!")
                                                })
                                        }
                                    )
                                }

                            }
                        )

                        put("Cancel - No", object : LinkedHashMap<Int, (ActionEvent) -> Unit>() {
                            init {
                                put(KeyEvent.VK_C, {
                                        ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 2 buttons\nCancel - Ok"), JOptionPane.OK_CANCEL_OPTION)
                                                .showDialog({
                                                    System.out.println("Pressed Ok button!!!")
                                                }, {

                                                }, {
                                                    System.out.println("Pressed Cancel button!!!")
                                                })
                                        }
                                    )

                                }
                            }
                        )

                        put("Cancel - No - Yes", object : LinkedHashMap<Int, (ActionEvent) -> Unit>() {
                            init {
                                put(KeyEvent.VK_C, {
                                    ConfirmImpl(frame, Pair("Basic Confirm Dialog", "Dialog with 3 buttons\nCancel - No - Yes"), JOptionPane.YES_NO_CANCEL_OPTION)
                                                .showDialog({
                                                    System.out.println("Pressed Yes button!!!")
                                                }, {
                                                    System.out.println("Pressed No button!!!")
                                                }, {
                                                    System.out.println("Pressed Cancel button!!!")
                                                })
                                        }
                                    )

                                }
                            }
                        )


                        put("----", object : LinkedHashMap<Int, (ActionEvent) -> Unit>() {
                            init {
                                put(MenuItem.NONE, {})
                            }
                        })

                        put("No - Yes Custom Message", object : LinkedHashMap<Int, (ActionEvent) -> Unit>() {
                            init {
                                put(KeyEvent.VK_C, {
                                        ConfirmImpl(frame, Pair("Custom Confirm Dialog Message", "<html>The magic <span style='color:green'>color</span> </html>"), JOptionPane.YES_NO_OPTION)
                                                .showDialog({
                                                    System.out.println("Pressed Yes button!!!")
                                                }, {
                                                    System.out.println("Pressed No button!!!")
                                                })
                                        }
                                    )

                                }
                            }
                        )
                    }
                }
            )
        }
    }
}

