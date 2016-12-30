package src

import components.menuBar.child.MenuChooser
import components.menuBar.child.MenuDialog
import components.menuBar.child.MenuFile
import components.progressBar.*
import src.app.ApplicationImpl
import src.configuration.ConfigurationImpl
import src.configuration.Display
import src.configuration.DisplayImpl
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

            //Frame
            val frame = JFrame()
            //Application
            val app = ApplicationImpl.create(frame)
            //Display
            val display = DisplayImpl.create(Display.KFRAME_JAVA, Display.WIDHT, Display.HEIGTH, Display.VISIBLE)


            //Top Panel
            var textArea = TextAreaImpl.create(TextArea.TEXT)
            val progressBar = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panel = PanelImpl.create(FlowLayout(),Pair(progressBar,textArea))

            //Center Panel
            var textAreaCenter = TextAreaImpl.create(TextArea.KAFKA)
            val progressBarCenter = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panelCenter = PanelImpl.create(FlowLayout(),Pair(progressBarCenter,textAreaCenter))

            //Bottom Panel
            var textAreaBottom = TextAreaImpl.create(TextArea.LOREMIPSUM)
            val progressBarBottom = ProgressBarImpl.create(ProgressBar.MIN, ProgressBar.MAX)
            val panelBottom = PanelImpl.create(FlowLayout(),Pair(progressBarBottom,textAreaBottom))


            //StatusBar
            val statusBar = StatusBarImpl.create(Display.WIDHT)

            //Menubar
            val menuBar = MenuBarImpl.create()

            //File Item Menu
            val menuFile = MenuBarImpl.MenuFile(frame)
            // Menu Item Dialog
            val menuDialog = MenuBarImpl.MenuDialog(frame)
            //Menu Item Chooser
            var menuChooser = MenuBarImpl.MenuChooser(frame)

            val menuList = Arrays.asList(menuFile, menuDialog,menuChooser)
            menuBar.addMenu(menuList)


            //Configure
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