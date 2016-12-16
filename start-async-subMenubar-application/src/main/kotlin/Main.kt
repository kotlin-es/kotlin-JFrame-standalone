package src

import components.menuBar.child.MenuBarDialog
import components.menuBar.child.MenuBarFile
import components.menuBar.child.dialog.MenuBarConfirm
import components.menuBar.child.dialog.MenuBarInput
import components.menuBar.child.dialog.MenuBarMessage
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

            var menuBar = MenuBarImpl.create()

            var menuDialog = menuBar.createMenu(MenuBarImpl.MenuBarDialog())
            var menuDialogSubMenu = Arrays.asList(
                    menuBar.createMenu(MenuBarImpl.MenuBarMessage(frame)),
                    menuBar.createMenu(MenuBarImpl.MenuBarConfirm(frame)),
                    menuBar.createMenu(MenuBarImpl.MenuBarInput(frame))
            )

            menuBar.createSubMenu(menuDialog,menuDialogSubMenu)

            val menuList = Arrays.asList(
                    menuBar.createMenu(MenuBarImpl.MenuBarFile()),
                    menuDialog
            )

            menuBar.addMenu(menuList)


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