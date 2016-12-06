package src

import components.progressBar.PanelImpl
import components.progressBar.ProgressBarImpl
import components.progressBar.TextArea
import components.progressBar.TextAreaImpl
import src.app.ApplicationImpl
import src.configuration.Configuration
import src.configuration.ConfigurationImpl
import src.configuration.Display
import src.configuration.DisplayImpl
import java.awt.FlowLayout
import java.util.concurrent.ExecutionException
import javax.swing.SwingUtilities

/**
 * Created by vicboma on 02/12/16.
 */
object Main {

    @JvmStatic fun main(args: Array<String>) {
        SwingUtilities.invokeLater {
            System.out.println("SwingUtilities.invokeLater")

            val display = DisplayImpl.create(Display.KFRAME_JAVA, Display.WIDHT, Display.HEIGTH, Display.VISIBLE)

            var textArea = TextAreaImpl.create(TextArea.TEXT)
            val progressBar = ProgressBarImpl.create(0,100)

            val panel = PanelImpl.create(FlowLayout(),progressBar,textArea)

            val configure : Configuration = ConfigurationImpl
                    .create(display, panel)

            try {
                val app = ApplicationImpl
                            .create(configure)
                            .startAsync()
                            .get()

            } catch (e: InterruptedException) {
                e.printStackTrace()
            } catch (e: ExecutionException) {
                e.printStackTrace()
            } finally {
                System.out.println("App startAsync")
            }
        }
        System.out.println("Main runAsync")
    }
}