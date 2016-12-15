package components.progressBar

import utils.ThreadMain
import java.awt.Dimension
import java.util.concurrent.CompletableFuture
import javax.swing.JPanel
import javax.swing.JScrollPane
import javax.swing.JTextArea

/**
 * Created by vicboma on 05/12/16.
 */
class TextAreaImpl internal constructor(val _text: String) : JTextArea() , TextArea {

    companion object {
        var scrollPane : JScrollPane? = null

        fun create(text: String): TextArea {
            return TextAreaImpl(text)
        }
    }

    init{

        scrollPane =  JScrollPane(this)
        scrollPane?.setPreferredSize(Dimension(380, 100))
        scrollPane?.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS)
        this.lineWrap = true
        this.wrapStyleWord = true
        this.isEditable = false
        this.alignmentX = JPanel.CENTER_ALIGNMENT
        this.autoscrolls = true

        for ( i in 0.._text.length-1) {
            i.text()
        }
    }

    override fun asyncUI()  {
        ThreadMain.asyncUI {
            CompletableFuture.runAsync {
                Thread.sleep(1500)
                text = ""
                for ( i in 0.._text.length-1) {
                    Thread.sleep(50)
                    i.text()
                }

            }.thenAcceptAsync {
                asyncUI()
            }
        }
    }

    private fun isMod(a : Int, b :Int) = (a % b) == 0

    public fun Int.text() = when {
        //isMod(this,TextArea.MOD) -> caretPosition = getDocument().getLength()
        else -> {
            append(_text[this].toString())
            caretPosition = getDocument().getLength()
        }
    }

    override fun component() : JScrollPane?  = scrollPane

}
