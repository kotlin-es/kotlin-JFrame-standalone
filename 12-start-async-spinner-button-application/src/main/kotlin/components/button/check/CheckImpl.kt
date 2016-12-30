package components.progressBar

import javax.swing.JComponent

/**
 * Created by vicboma on 05/12/16.
 */
class CheckImpl internal constructor() : javax.swing.JCheckBox() , Check{


    companion object {
        fun create(): Check {
            return CheckImpl()
        }
    }

    init{

    }
}
