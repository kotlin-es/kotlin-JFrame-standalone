package components.progressBar

import utils.ThreadMain
import java.awt.Component
import java.util.concurrent.CompletableFuture
import javax.swing.JComponent
import javax.swing.JPanel
import javax.swing.JTextArea

/**
 * Created by vicboma on 05/12/16.
 */
class TextAreaImpl internal constructor(val _text: String) : JTextArea() , TextArea {

    companion object {
        fun create(text: String): TextArea {
            return TextAreaImpl(text)
        }
    }

    init{
        isEditable = false
        alignmentX = JPanel.CENTER_ALIGNMENT
        autoscrolls = true
        text = _text
        setAlignmentX(Component.CENTER_ALIGNMENT)
    }

    override fun asyncUI()  {
        ThreadMain.asyncUI {
            CompletableFuture.runAsync {
                Thread.sleep(1500)
                text = ""
                for ( i in 0.._text.length-1) {
                    Thread.sleep(50)
                    text += _text[i]
                }
            }.thenAcceptAsync {
                asyncUI()
            }
        }
    }

    override fun component() : JComponent {
        return this
    }



}
