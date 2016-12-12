package components.dialog

/**
 * Created by vicboma on 10/12/16.
 */
interface  Dialog {
    fun showConfirmDialog(ok: () -> Unit, cancel: () -> Unit)
}