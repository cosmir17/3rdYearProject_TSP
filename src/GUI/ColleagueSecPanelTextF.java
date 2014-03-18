package GUI;

import javax.swing.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * Created by lloydp on 27/02/14.
 */
public class ColleagueSecPanelTextF extends JTextField implements Colleague, TextListener {
    private Mediator mediator;

    public ColleagueSecPanelTextF() {

    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {

        setEnabled(enabled);
        setEditable(false);
        // setBackground(enabled ? Color.white : Color.lightGray);
    }


    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}

