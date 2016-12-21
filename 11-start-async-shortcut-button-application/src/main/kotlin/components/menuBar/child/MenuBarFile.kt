package components.menuBar.child

import components.progressBar.MenuBarImpl
import java.awt.event.ActionEvent
import java.util.*
import javax.swing.JMenuItem

/**
 * Created by vicboma on 12/12/16.
 */
public fun MenuBarImpl.Companion.MenuBarFile(): Map<String, Map<String, (ActionEvent) -> Unit>> {
    return object : LinkedHashMap<String, Map<String, (ActionEvent) -> Unit>>() {
        init {
            put("File",LinkedHashMap<String, (ActionEvent) -> Unit>())
        }
    }
}

private fun clickAction(it: ActionEvent) {
    var item = (it.source as JMenuItem)
    item.text = it.actionCommand.plus("  -  (Clicked!)")
    item.removeActionListener(item.actionListeners.get(0))
}

/*
// create an Action doing what you want
Action action = new AbstractAction("doSomething") {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("triggered the action");
    }

};
// configure the Action with the accelerator (aka: short cut)
action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control S"));

// create a button, configured with the Action
JButton toolBarButton = new JButton(action);
// manually register the accelerator in the button's component input map
toolBarButton.getActionMap().put("myAction", action);
toolBarButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
(KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "myAction");*/


