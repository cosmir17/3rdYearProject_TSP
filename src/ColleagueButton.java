import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by lloydp on 21/02/14.
 */
public class ColleagueButton extends JButton implements Colleague, ActionListener {
    private Mediator mediator;
    public ActionEvent e;
    public boolean pushed = false;

    public ColleagueButton(String caption) {
        super(caption);
    }


    @Override
    public void setMediator(Mediator mediator) {

        this.mediator = mediator;

    }

    @Override
    public void setColleagueEnabled(boolean enabled) {
        setEnabled(enabled);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pushed = true;
        this.e = e;
        mediator.colleagueChanged();
    }


}
