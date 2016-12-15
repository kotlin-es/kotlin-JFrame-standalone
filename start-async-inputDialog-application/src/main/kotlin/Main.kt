package src

import components.menuBar.child.MenuBarConfirm
import components.menuBar.child.MenuBarFile
import components.menuBar.child.MenuBarInput
import components.menuBar.child.MenuBarMessage
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

            val statusBar = StatusBarImpl.create(Display.WIDHT)

            val menuFile = MenuBarImpl.Companion.MenuBarFile()
            val menuMessage = MenuBarImpl.Companion.MenuBarMessage(frame)
            val menuConfirm = MenuBarImpl.Companion.MenuBarConfirm(frame)
            val menuInput = MenuBarImpl.Companion.MenuBarInput(frame)


            val reduceMap = menuFile.mergeReduce(menuMessage.mergeReduce(menuConfirm.mergeReduce(menuInput)))
            val menuBar = MenuBarImpl.create(reduceMap)


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


            }
        }
    }
}