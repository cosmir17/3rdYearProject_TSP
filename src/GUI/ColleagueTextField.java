package GUI;

import java.awt.*;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

/**
 * Created by lloydp on 21/02/14.
 */
public class ColleagueTextField extends TextField implements Colleague, TextListener {
    private Mediator mediator;

    public ColleagueTextField(String text) {
        super(text);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {

        setEnabled(enabled);
        setBackground(enabled ? Color.white : Color.lightGray);
    }


    @Override
    public void textValueChanged(TextEvent e) {
        mediator.colleagueChanged();
    }
}
