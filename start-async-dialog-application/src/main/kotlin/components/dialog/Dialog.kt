package components.dialog

/**
 * Created by vicboma on 10/12/16.
 */
interface  Dialog {
    fun showConfirmDialog(yes : () -> Unit)
    fun showConfirmDialog(yes : () -> Unit,no : () -> Unit)
    fun showConfirmDialog(yes : () -> Unit, no : () -> Unit, cancel : () -> Unit)
}