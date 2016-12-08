package src.app

import src.configuration.Configuration
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.util.concurrent.CompletableFuture
import javax.swing.JFrame

/**
 * Created by vicboma on 02/12/16.
 */
class ApplicationImpl internal constructor(private val configuration: Configuration) : JFrame(), Application {

    companion object {
        fun create(configuration: Configuration): Application {
            return ApplicationImpl(configuration)
        }
    }

    override fun startAsync() : CompletableFuture<Application> {
        var future = CompletableFuture<Application>()
        return runAsync(future)
    }

    private fun runAsync(result: CompletableFuture<Application>) : CompletableFuture<Application>  {
        CompletableFuture.runAsync {

            this.setLayout()
            this.setTitle()
            this.setCloseOp()
            this.setLayout(FlowLayout())
            this.setContentPane()
            this.setMenuBar()
            this.setStatusBar()

            this.pack()
            this.setSize()
            this.setLocation()
            this.setVisible()

            asyncOperations()

            result.complete(this)
        }

        return result
    }

    private fun setCloseOp() {
        this.defaultCloseOperation = configuration.display?.closeOp!!
    }

    private fun setTitle()  {
        super.setTitle(configuration.display?.title!!)
    }

    private fun setLayout() {
        super.setLayout(configuration.display?.layout)
    }

    private fun setSize()  {
        this.setSize(configuration.display?.widht!!, configuration.display?.heigth!!)
    }

    private fun setLocation()  {
        super.setLocationRelativeTo(configuration.display?.location)
    }

    private fun setVisible() {
        this.isVisible = configuration.display?.visible!!
    }

    private fun setContentPane() {
        configuration.panel?.forEach {
            this.contentPane.add(it.component(), BorderLayout.CENTER)
        }
    }

    private fun setMenuBar() {
        this.jMenuBar = configuration.menuBar?.component()
    }

    private fun setStatusBar() {
        this.add(configuration.statusBar?.component(), BorderLayout.SOUTH);
    }

    private fun asyncOperations() {

        configuration.panel?.forEach {
            it.progressBar?.asyncUI()
            it.textArea?.asyncUI()
        }
        configuration.statusBar?.asyncUI()

    }
}
