package GUI;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 * Created by lloydp on 22/02/14.
 */
public class ColleagueCheckBox extends JCheckBox implements Colleague, ItemListener {
    private Mediator mediator;

    public ColleagueCheckBox(String text) {
        super(text);
    }

    @Override
    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void setColleagueEnabled(boolean enabled) {

        setEnabled(enabled);
        setSelected(enabled);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        mediator.colleagueChanged();
    }
}
