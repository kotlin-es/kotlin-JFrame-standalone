package components.progressBar

import components.Component
import java.awt.Color
import javax.swing.JColorChooser

/**
 * Created by vicboma on 15/12/16.
 */
interface  FileChooser : Component<javax.swing.JFileChooser> {
    fun showDialog(callback: (str: String) -> Unit)
}