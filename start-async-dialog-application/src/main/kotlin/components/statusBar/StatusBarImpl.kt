package components.progressBar

import utils.ThreadMain
import java.awt.Dimension
import java.util.concurrent.CompletableFuture
import javax.swing.BoxLayout
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.SwingConstants
import javax.swing.border.BevelBorder

/**
 * Created by vicboma on 05/12/16.
 */
class StatusBarImpl internal constructor(private val _width : Int) : JPanel() , StatusBar {

    private var statusLabel = JLabel();

    companion object {
        fun create(_width: Int): StatusBar {
            return StatusBarImpl(_width)
        }
    }

    init{
        border = BevelBorder(BevelBorder.LOWERED);
        preferredSize = Dimension(_width, 19);
        layout = BoxLayout(this, BoxLayout.X_AXIS);
        statusLabel.horizontalAlignment = SwingConstants.LEFT;
        this.add(statusLabel);
    }

    override fun asyncUI() = asyncSpel(StatusBar.TEXT,1000L,50L)

    override fun component() : JPanel? {
        return this
    }

    private fun asyncSpel(str: String, delay: Long, sequence:Long) {
        ThreadMain.asyncUI {
            CompletableFuture.runAsync {
                Thread.sleep(delay)
                statusLabel.text = ""
                for (i in 0..str.length - 1) {
                    Thread.sleep(sequence)
                    statusLabel.text += str[i].toString()
                }
            }.thenAcceptAsync {
                asyncUI()
            }
        }
    }
}
