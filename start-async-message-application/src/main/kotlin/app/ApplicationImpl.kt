package src.app

import src.configuration.Configuration
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.util.concurrent.CompletableFuture
import javax.swing.JFrame

/**
 * Created by vicboma on 02/12/16.
 */
class ApplicationImpl internal constructor(private val frame: JFrame) : Application {

    private var configuration : Configuration? = null

    companion object {
        fun create(frame: JFrame): Application {
            return ApplicationImpl(frame)
        }
    }

    override fun startAsync(configuration : Configuration) : CompletableFuture<Application> {
        this.configuration = configuration
        var future = CompletableFuture<Application>()
        return runAsync(future)
    }

    private fun runAsync(result: CompletableFuture<Application>) : CompletableFuture<Application>  {
        CompletableFuture.runAsync {

            this.setLayout()
            this.setTitle()
            this.setCloseOp()
            frame.setLayout(FlowLayout())
            this.setContentPane()
            this.setMenuBar()
            this.setStatusBar()

            frame.pack()
            this.setSize()
            this.setLocation()
            this.setVisible()

            asyncOperations()

            result.complete(this)
        }

        return result
    }

    private fun setCloseOp() {
        frame.defaultCloseOperation = configuration?.display?.closeOp!!
    }

    private fun setTitle()  {
        frame.setTitle(configuration?.display?.title!!)
    }

    private fun setLayout() {
        frame.setLayout(configuration?.display?.layout)
    }

    private fun setSize()  {
        frame.setSize(configuration?.display?.widht!!, configuration?.display?.heigth!!)
    }

    private fun setLocation()  {
        frame.setLocationRelativeTo(configuration?.display?.location)
    }

    private fun setVisible() {
        frame.isVisible = configuration?.display?.visible!!
    }

    private fun setContentPane() {
        configuration?.panel?.forEach {
            frame.contentPane.add(it.component(), BorderLayout.CENTER)
        }
    }

    private fun setMenuBar() {
        frame.jMenuBar = configuration?.menuBar?.component()
    }

    private fun setStatusBar() {
        frame.add(configuration?.statusBar?.component(), BorderLayout.SOUTH);
    }

    private fun asyncOperations() {

        configuration?.panel?.forEach {
            it.progressBar?.asyncUI()
            it.textArea?.asyncUI()
        }
        configuration?.statusBar?.asyncUI()

    }
}
