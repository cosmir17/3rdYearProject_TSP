import javax.swing.*;
import java.awt.*;

/**
 * Created by lloydp on 22/02/14.
 */
public class ColleagueLabel extends JLabel implements Colleague {
    private Mediator mediator;

    public ColleagueLabel(String text) {
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


}
