package GUI.Testing;

import Graph.Testing.GraphGenerator;

import javax.swing.*;
import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: lloydp
 * Date: 12/10/13
 * Time: 14:03
 * To change this template use File | Settings | File Templates.
 */


public class GuiForTestingSmallparts extends JFrame {

    private Container TContentPane;
    private JPanel eastPanel = new JPanel();
    private JPanel mapPanel = new JPanel();
    private GraphGenerator graph;

    public GuiForTestingSmallparts(GraphGenerator graph) {
        this.graph = graph;
        initGui();


    }

    public void initGui() {

        createSettings();
        createPanelLayoutSetter();
        createPanelMaker();
        createPanelAdder();
        setVisible(true);
    }

    public void createSettings() {
        this.setTitle("A Thrid-year project  :            Finding A Shortest Path for every cities within a selected area");
        this.setSize(1000, 600);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        TContentPane = this.getContentPane();
        setLayout(new BorderLayout());
        guiCentre();

    }

    private void createPanelLayoutSetter() {
        eastPanel.setLayout(new BorderLayout());
        mapPanel.setLayout(new BorderLayout());
    }

    private void createPanelMaker() {

        createEastPanel();
        createMapPanel();
    }

    private void createPanelAdder() {
        TContentPane.add(eastPanel, BorderLayout.EAST);
        TContentPane.add(mapPanel, BorderLayout.CENTER);

    }

    private void createEastPanel() {


    }


    private void createMapPanel() {
        /*
        JLabel label1 = new JLabel("sdfsdfds");
        mapPanel.add(label1);
         Works
          */

        mapPanel.add(graph.returnJGraph());


    }

    private void guiCentre() {
        Dimension windowSize = TContentPane.getSize();
        Dimension screenSi = Toolkit.getDefaultToolkit().getScreenSize();
        int Shrizontal = (screenSi.width - windowSize.width) / 2;
        int Svertical = (screenSi.height - windowSize.height) / 2;
        TContentPane.setLocation(Shrizontal, Svertical);
    }


}
