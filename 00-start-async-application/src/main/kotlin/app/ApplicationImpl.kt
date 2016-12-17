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
        this.contentPane.add(configuration.panel?.component(), BorderLayout.CENTER)
    }

    private fun asyncOperations() {
        val panel = configuration.panel
        panel?.progressBar?.asyncUI()
        panel?.textArea?.asyncUI()
    }
}
