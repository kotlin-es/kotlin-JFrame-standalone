package src.configuration

import java.awt.Component
import java.awt.LayoutManager

/**
 * Created by vicboma on 02/12/16.
 */
interface Display  {

     companion object {
          val KFRAME_JAVA = "KFrame Async "
          val WIDHT = 580
          val HEIGTH = 456
          val VISIBLE = true
    }

    var title: String
    val widht: Int?
    val heigth: Int?
    val visible: Boolean?
    val layout: LayoutManager?
    val closeOp: Int?
    val location: Component?
}
