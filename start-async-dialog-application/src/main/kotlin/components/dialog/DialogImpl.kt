package components.dialog

import java.awt.Frame
import javax.swing.JOptionPane

/**
 * Created by vicboma on 10/12/16.
 */
class DialogImpl internal constructor( private val frame : Frame, private val pair : Pair<String,String>, private val option : Int) : Dialog {

    companion object {
        fun create(frame: Frame, pair: Pair<String, String>, option: Int): Dialog {
            return DialogImpl(frame, pair, option)
        }
    }

    init {

    }

    public override fun showConfirmDialog(ok : () -> Unit, cancel : () -> Unit) {
        val res = JOptionPane.showConfirmDialog(frame, pair.second, pair.first, option)
        when (res){
            JOptionPane.OK_OPTION -> {
                ok.invoke()
            }
            JOptionPane.CANCEL_OPTION ->{
                cancel.invoke()
            }
            else -> {
                throw RuntimeException("Error JOptionPane input buttons !!!!")
            }
        }
    }

}