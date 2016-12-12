package src

import components.dialog.DialogImpl
import components.menuBar.child.MenuBarMessage
import components.menuBar.child.MenuFile
import components.progressBar.*
import src.app.ApplicationImpl
import src.configuration.ConfigurationImpl
import src.configuration.Display
import src.configuration.DisplayImpl
import utils.map.mergeReduce
import java.awt.FlowLayout
import java.util.*
import java.util.concurrent.ExecutionException
import javax.swing.JFrame
import javax.swing.JOptionPane
import javax.swing.SwingUtilities

/**
 * Created by vicboma on 02/12/16.
 */
object Main {

    @JvmStatic fun main(args: Array<String>) {
        SwingUtilities.invokeLater {

            val frame = JFrame()
            val app = ApplicationImpl.create(frame)

            val display = DisplayImpl.create(Display.KFRAME_JAVA, Display.WIDHT, Display.HEIGTH, Display.VISIBLE)

            var textArea = TextAreaImpl.create(TextArea.TEXT)
            val progressBar = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panel = PanelImpl.create(FlowLayout(),progressBar,textArea)

            var textAreaCenter = TextAreaImpl.create(TextArea.KAFKA)
            val progressBarCenter = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panelCenter = PanelImpl.create(FlowLayout(),progressBarCenter,textAreaCenter)

            var textAreaBottom = TextAreaImpl.create(TextArea.LOREMIPSUM)
            val progressBarBottom = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panelBottom = PanelImpl.create(FlowLayout(),progressBarBottom,textAreaBottom)

            val menuFile = MenuBarImpl.Companion.MenuFile()
            val menuMessage = MenuBarImpl.Companion.MenuBarMessage(frame)
            val reduceMap = menuFile.mergeReduce(menuMessage)
            val menuBar = MenuBarImpl.create(reduceMap)

            val statusBar = StatusBarImpl.create(Display.WIDHT)

            val configure = ConfigurationImpl.create(display, ArrayList<Panel>(Arrays.asList(panel, panelCenter, panelBottom)), menuBar, statusBar)

            try {
                    app
                    .startAsync(configure)
                    .get()

            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } finally {

                DialogImpl(frame,Pair("Basic Dialog","Dialog with 2 buttons"), JOptionPane.YES_NO_OPTION)
                        .showConfirmDialog({
                            System.out.println("Pressed Ok button!!!")
                        }, {
                            System.out.println("Pressed Cancel button!!!")
                        })
            }
        }
    }
}