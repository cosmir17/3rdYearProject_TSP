package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lloydp on 21/02/14.
 */
public class ButtonHandler implements ActionListener {
    public ButtonHandler() {
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals(TSPGui.INITIALISATION)) {
            System.exit(1);
        }
        // CommandInterface CommandObj = (CommandInterface) e.getSource();
        //CommandObj.processEvent();
    }
}

