package components.dialog.message

import java.awt.Frame
import javax.swing.ImageIcon
import javax.swing.JOptionPane

/**
 * Created by vicboma on 10/12/16.
 */
class MessageImpl internal constructor( val frame : Frame, val pair : Pair<String,String>, val option : EnumMessage, val icon : ImageIcon?) : Message {

    companion object {
        fun create(frame: Frame, pair: Pair<String, String>, option: EnumMessage): Message {
            return MessageImpl(frame, pair, option, null)
        }

        fun create(frame: Frame, pair: Pair<String, String>, option: EnumMessage, icon: ImageIcon): Message {
            return MessageImpl(frame, pair, option, icon)
        }
    }

    init {
        show()
    }

    fun show() = JOptionPane.showMessageDialog(frame, pair.second, pair.first, option.value, icon)

}