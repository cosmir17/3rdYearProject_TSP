package GUI;

import Algorithm.InsertionAlgo;
import Algorithm.NearestNeighbourAlgo;
import Algorithm.SimulatedAnnealingAlgo;
import Algorithm.TwoOptAlgo;
import Graph.GraphGenerator;
import com.mxgraph.swing.mxGraphComponent;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import com.jgoodies.forms.factories.*;
/*
 * Created by JFormDesigner on Fri Nov 22 21:50:12 GMT 2013
 */


/**
 * @author S K
 */
public class TSPGui extends JFrame implements ActionListener, Mediator {

    //  private Graph.Testing.GraphGenerator graph;
    private GraphGenerator graphG;
    private GraphGenerator graphGnearnAlgoGraph;
    private GraphGenerator graphInsertionAlgoGraph;
    private GraphGenerator graphTwoOptAlgoGraph;
    private GraphGenerator graphSAalgoGraph;

    public final static String INITIALISATION = "Initialisation";
    public final static String SHORTEST_PATH = "Shortest Path";


    public TSPGui(GraphGenerator graphG) {
        //  graph = new Graph.Testing.GraphGenerator();
        this.graphG = graphG;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(1300, 620));
        setTitle("Third Year Project : Visualisation of Travelling Sales Man Problem");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        createCollegues();

        contentPane.add(panel2, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(getOwner());
        colleagueChanged();
    }


    @Override
    public void createCollegues() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:createColleagues
        // Generated using JFormDesigner Evaluation license - S K
        panel2 = new JPanel();
        panel1 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        initButton = new ColleagueButton(INITIALISATION);
        shortestButton = new ColleagueButton(SHORTEST_PATH);
        panel19 = new JPanel();
        label5 = new JLabel();
        cityNumberTextField = new ColleagueTextField("");
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        panel18 = new JPanel();
        button3 = new JButton();
        button2 = new JButton();
        resultPanel = new JPanel();
        panel7 = new JPanel();
        nameOfHeuristicsLabel = new ColleagueLabel("Name of heuristics");
        timeLabel = new ColleagueLabel("Time");
        distanceLabel = new ColleagueLabel("Distance");
        panel8 = new JPanel();
        insertionCheckBox = new ColleagueCheckBox("Insertion");
        insertionTimeTextF = new ColleagueSecPanelTextF();
        insertionDisTanceTextF = new ColleagueSecPanelTextF();
        panel9 = new JPanel();
        nnCheckBox = new ColleagueCheckBox("Nearest Neighbour");
        nnTimeTextF = new ColleagueSecPanelTextF();
        nnDistanceTextF = new ColleagueSecPanelTextF();
        panel10 = new JPanel();
        optAlgoCheckBox = new ColleagueCheckBox("2 opt & 3 opt");
        optTimeText = new ColleagueSecPanelTextF();
        optDistanceTextF = new ColleagueSecPanelTextF();
        panel11 = new JPanel();
        advancedHeuLabel = new ColleagueLabel("Advanced Heuristics");
        panel12 = new JPanel();
        simultedACheckBox = new ColleagueCheckBox("Simulated Annealing");
        sAtimeTextF = new ColleagueSecPanelTextF();
        sAdistanceTextF = new ColleagueSecPanelTextF();
        panel13 = new JPanel();
        tabuCheckBox = new ColleagueCheckBox("Tabu Search");
        textField13 = new JTextField();
        textField17 = new JTextField();
        panel14 = new JPanel();
        button10 = new JButton();
        button9 = new JButton();
        panel15 = new JPanel();
        panel16 = new JPanel();
        panel17 = new JPanel();
        button5 = new JButton();
        button6 = new JButton();
        button7 = new JButton();
        button8 = new JButton();
        slider1 = new JSlider();
        panelMap = new JPanel();

        //  GUI.ButtonHandler butEvent = new GUI.ButtonHandler();
        //======== this ========


        //======== panel2 ========
        {
            //  panel2.setPreferredSize(new Dimension(500, 200));
            //panel2.setMinimumSize(new Dimension(500, 700));

            // JFormDesigner evaluation mark

          /*
          panel2.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), panel2.getBorder())); panel2.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
*/
            panel2.setLayout(new BorderLayout());

            //======== panel1 ========
            {
                panel1.setPreferredSize(new Dimension(350, 590));

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder(INITIALISATION));

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridLayout(1, 2));

                        //---- initButton ----
                        initButton.setMediator(this);
                        initButton.setEnabled(false);
                        initButton.addActionListener(initButton);
                        panel4.add(initButton);

                        //---- shortestButton ----
                        shortestButton.setEnabled(false);
                        shortestButton.setMediator(this);
                        shortestButton.addActionListener(shortestButton);
                        panel4.add(shortestButton);
                    }

                    //======== panel19 ========
                    {

                        //---- label5 ----
                        label5.setText("How many cities?");
                        label5.setFont(new Font("Dialog", Font.PLAIN, 16));

                        //---- cityNumberTextField ----

                        cityNumberTextField.setFont(new Font("Monospaced", Font.PLAIN, 16));
                        // cityNumberTextField.setAutoscrolls(false);
                        //  cityNumberTextField.setBorder(new BevelBorder(BevelBorder.LOWERED));
                        cityNumberTextField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                        cityNumberTextField.setMediator(this);
                        cityNumberTextField.addTextListener(cityNumberTextField);


                        GroupLayout panel19Layout = new GroupLayout(panel19);
                        panel19.setLayout(panel19Layout);
                        panel19Layout.setHorizontalGroup(
                                panel19Layout.createParallelGroup()
                                        .addGroup(panel19Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(label5)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cityNumberTextField, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                                .addContainerGap())
                        );
                        panel19Layout.setVerticalGroup(
                                panel19Layout.createParallelGroup()
                                        .addGroup(panel19Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                .addComponent(label5)
                                                .addComponent(cityNumberTextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
                        );
                    }

                    GroupLayout panel3Layout = new GroupLayout(panel3);
                    panel3.setLayout(panel3Layout);
                    panel3Layout.setHorizontalGroup(
                            panel3Layout.createParallelGroup()
                                    .addComponent(panel19, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(panel4, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    );
                    panel3Layout.setVerticalGroup(
                            panel3Layout.createParallelGroup()
                                    .addGroup(panel3Layout.createSequentialGroup()
                                            .addComponent(panel19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panel4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
                    );
                }

                //======== panel5 ========
                {
                    panel5.setBorder(new TitledBorder("Step By Step Visualisation"));

                    //---- comboBox1 ----
                    comboBox1.setEnabled(false);
                    comboBox1.setModel(new DefaultComboBoxModel(new String[]{
                            "Insertion",
                            "Nearest Neighbour",
                            "2 opt & 3 opt",
                            "Simulated Annealing",
                            "Tabu Search"
                    }));

                    //======== panel18 ========
                    {
                        panel18.setLayout(new GridLayout(1, 2));

                        //---- button3 ----
                        button3.setText("Run");
                        button3.setEnabled(false);
                        panel18.add(button3);


                        //---- button2 ----
                        button2.setText("Stop");
                        button2.setEnabled(false);
                        panel18.add(button2);
                    }

                    GroupLayout panel5Layout = new GroupLayout(panel5);
                    panel5.setLayout(panel5Layout);
                    panel5Layout.setHorizontalGroup(
                            panel5Layout.createParallelGroup()
                                    .addComponent(comboBox1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                                    .addComponent(panel18, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                    );
                    panel5Layout.setVerticalGroup(
                            panel5Layout.createParallelGroup()
                                    .addGroup(panel5Layout.createSequentialGroup()
                                            .addComponent(comboBox1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(panel18, GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE))
                    );
                }

                //======== resultPanel ========
                {
                    resultPanel.setBorder(new TitledBorder("Results"));
                    resultPanel.setLayout(new GridLayout(8, 0));

                    //======== panel7 ========
                    {
                        panel7.setEnabled(false);
                        panel7.setBorder(null);

                        //---- nameOfHeuristicsLabel ----
                        // nameOfHeuristicsLabel.setText("Name of heuristics");
                        nameOfHeuristicsLabel.setEnabled(false);
                        nameOfHeuristicsLabel.setMediator(this);

                        //---- timeLabel ----
                        // timeLabel.setText("Time");
                        timeLabel.setEnabled(false);
                        timeLabel.setMediator(this);
                        //---- distanceLabel ----
                        // distanceLabel.setText("Distance");
                        distanceLabel.setEnabled(false);
                        distanceLabel.setMediator(this);
                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                                panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(nameOfHeuristicsLabel, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                .addGap(23, 23, 23)
                                                .addComponent(timeLabel)
                                                .addGap(30, 30, 30)
                                                .addComponent(distanceLabel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(3, Short.MAX_VALUE))
                        );
                        panel7Layout.setVerticalGroup(
                                panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel7Layout.createSequentialGroup()
                                                .addGap(0, 14, Short.MAX_VALUE)
                                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nameOfHeuristicsLabel, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(distanceLabel)
                                                        .addComponent(timeLabel)))
                        );
                    }
                    resultPanel.add(panel7);

                    //======== panel8 ========
                    {
                        panel8.setBorder(null);

                        //---- insertionCheckBox ----
                        // insertionCheckBox.setText("Insertion");
                        insertionCheckBox.setEnabled(false);
                        insertionCheckBox.setMediator(this);
                        insertionCheckBox.addItemListener(insertionCheckBox);
                        //---- insertionTimeTextF ----
                        insertionTimeTextF.setEnabled(false);
                        insertionTimeTextF.setMediator(this);


                        //---- insertionDisTanceTextF ----
                        insertionDisTanceTextF.setEnabled(false);
                        insertionDisTanceTextF.setMediator(this);

                        GroupLayout panel8Layout = new GroupLayout(panel8);
                        panel8.setLayout(panel8Layout);
                        panel8Layout.setHorizontalGroup(
                                panel8Layout.createParallelGroup()
                                        .addGroup(panel8Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(insertionCheckBox, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(insertionTimeTextF, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(insertionDisTanceTextF, GroupLayout.DEFAULT_SIZE, 54, 75))
                        );
                        panel8Layout.setVerticalGroup(
                                panel8Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(insertionCheckBox)
                                                        .addComponent(insertionTimeTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(insertionDisTanceTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    resultPanel.add(panel8);

                    //======== panel9 ========
                    {
                        panel9.setBorder(null);

                        //---- nnCheckBox ----
                        nnCheckBox.setText("Nearest Neighbour");
                        nnCheckBox.setEnabled(false);
                        nnCheckBox.setMediator(this);
                        nnCheckBox.addItemListener(nnCheckBox);

                        //---- nnTimeTextF ----
                        nnTimeTextF.setEnabled(false);
                        nnTimeTextF.setMediator(this);

                        //---- nnDistanceTextF ----
                        nnDistanceTextF.setEnabled(false);
                        nnTimeTextF.setMediator(this);

                        GroupLayout panel9Layout = new GroupLayout(panel9);
                        panel9.setLayout(panel9Layout);
                        panel9Layout.setHorizontalGroup(
                                panel9Layout.createParallelGroup()
                                        .addGroup(panel9Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(nnCheckBox, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nnTimeTextF, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(nnDistanceTextF, GroupLayout.DEFAULT_SIZE, 54, 75))
                        );
                        panel9Layout.setVerticalGroup(
                                panel9Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(nnCheckBox)
                                                        .addComponent(nnTimeTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(nnDistanceTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    resultPanel.add(panel9);

                    //======== panel10 ========
                    {
                        panel10.setBorder(null);

                        //---- optAlgoCheckBox ----
                        optAlgoCheckBox.setText("2 opt & 3 opt");
                        optAlgoCheckBox.setEnabled(false);
                        optAlgoCheckBox.setMediator(this);
                        optAlgoCheckBox.addItemListener(optAlgoCheckBox);
                        //---- optTimeText ----
                        optTimeText.setEnabled(false);
                        optTimeText.setMediator(this);
                        //---- optDistanceTextF ----
                        optDistanceTextF.setEnabled(false);
                        optDistanceTextF.setMediator(this);

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                                panel10Layout.createParallelGroup()
                                        .addGroup(panel10Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(optAlgoCheckBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(optTimeText, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(optDistanceTextF, GroupLayout.DEFAULT_SIZE, 54, 75))
                        );
                        panel10Layout.setVerticalGroup(
                                panel10Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(optAlgoCheckBox)
                                                        .addComponent(optTimeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(optDistanceTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    resultPanel.add(panel10);

                    //======== panel11 ========
                    {
                        panel11.setBorder(null);

                        //---- advancedHeuLabel ----
                        //  advancedHeuLabel.setText("Advanced Heuristics");
                        advancedHeuLabel.setEnabled(false);
                        advancedHeuLabel.setMediator(this);
                        GroupLayout panel11Layout = new GroupLayout(panel11);
                        panel11.setLayout(panel11Layout);
                        panel11Layout.setHorizontalGroup(
                                panel11Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                                .addContainerGap(75, 100)
                                                .addComponent(advancedHeuLabel, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1))
                        );
                        panel11Layout.setVerticalGroup(
                                panel11Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                                .addContainerGap(1, 1)
                                                .addComponent(advancedHeuLabel)
                                                .addContainerGap())
                        );
                    }
                    resultPanel.add(panel11);

                    //======== panel12 ========
                    {
                        panel12.setBorder(null);

                        //---- simultedACheckBox ----
                        // simultedACheckBox.setText("Simulated Annealing");
                        simultedACheckBox.setEnabled(false);

                        simultedACheckBox.setMediator(this);
                        simultedACheckBox.addItemListener(simultedACheckBox);

                        //---- sAtimeTextF ----
                        sAtimeTextF.setEnabled(false);
                        sAtimeTextF.setMediator(this);
                        //---- sAdistanceTextF ----
                        sAdistanceTextF.setEnabled(false);
                        sAdistanceTextF.setMediator(this);
                        GroupLayout panel12Layout = new GroupLayout(panel12);
                        panel12.setLayout(panel12Layout);
                        panel12Layout.setHorizontalGroup(
                                panel12Layout.createParallelGroup()
                                        .addGroup(panel12Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(simultedACheckBox, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(sAdistanceTextF, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(sAtimeTextF, GroupLayout.DEFAULT_SIZE, 60, 67))
                        );
                        panel12Layout.setVerticalGroup(
                                panel12Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel12Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(simultedACheckBox)
                                                        .addComponent(sAdistanceTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(sAtimeTextF, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    resultPanel.add(panel12);

                    //======== panel13 ========
                    {
                        panel13.setBorder(null);

                        //---- tabuCheckBox ----
                        //tabuCheckBox.setText("Tabu Search");
                        tabuCheckBox.setEnabled(false);
                        tabuCheckBox.setMediator(this);
                        tabuCheckBox.addItemListener(tabuCheckBox);
                        //---- textField13 ----
                        textField13.setEnabled(false);

                        //---- textField17 ----
                        textField17.setEnabled(false);

                        GroupLayout panel13Layout = new GroupLayout(panel13);
                        panel13.setLayout(panel13Layout);
                        panel13Layout.setHorizontalGroup(
                                panel13Layout.createParallelGroup()
                                        .addGroup(panel13Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(tabuCheckBox, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)
                                                .addComponent(textField13, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField17, GroupLayout.DEFAULT_SIZE, 65, 67))
                        );
                        panel13Layout.setVerticalGroup(
                                panel13Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(tabuCheckBox)
                                                        .addComponent(textField13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    resultPanel.add(panel13);
                }

                //======== panel14 ========
                {
                    panel14.setBorder(new TitledBorder("File Save or File Load"));
                    panel14.setLayout(new GridLayout(1, 2));

                    //---- button10 ----
                    button10.setText("Save");
                    button10.setEnabled(false);
                    panel14.add(button10);

                    //---- button9 ----
                    button9.setText("Load");
                    button9.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                         //  graphG.allEdgeRemover();
                        }
                    });
                    panel14.add(button9);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel14, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(resultPanel, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(panel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(resultPanel, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel14, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE))
                );
            }
            panel2.add(panel1, BorderLayout.EAST);

            //======== panel15 ========
            {
                panel15.setBorder(new TitledBorder("Graph Window"));

                panel15.setLayout(new BorderLayout());

                //======== panel16 ========
                {
                    panel16.setBorder(new TitledBorder("Step by step visualisation"));
                    panel16.setLayout(new BorderLayout());

                    //======== panel17 ========
                    {
                        panel17.setLayout(new GridLayout(1, 4));

                        //---- button5 ----
                        button5.setText("Stop");
                        button5.setEnabled(false);
                        panel17.add(button5);

                        //---- button6 ----
                        button6.setText("Prev");
                        button6.setEnabled(false);
                        panel17.add(button6);

                        //---- button7 ----
                        button7.setText("Ford");
                        button7.setEnabled(false);
                        panel17.add(button7);

                        //---- button8 ----
                        button8.setText("Play");
                        button8.setEnabled(false);
                        panel17.add(button8);
                    }
                    panel16.add(panel17, BorderLayout.EAST);

                    //---- slider1 ----
                    slider1.setValue(0);
                    slider1.setEnabled(false);
                    panel16.add(slider1, BorderLayout.CENTER);
                }
                panel15.add(panel16, BorderLayout.SOUTH);
                panel15.add(panelMap, BorderLayout.CENTER);
            }
            panel2.add(panel15, BorderLayout.CENTER);
        }

        // JFormDesigner - End of component initialization  //GEN-END:createColleagues
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - S K
    private JPanel panel2;
    private JPanel panel1;
    private JPanel panel3;
    private JPanel panel4;
    private ColleagueButton initButton;
    private ColleagueButton shortestButton;
    private JPanel panel19;
    private JLabel label5;
    private ColleagueTextField cityNumberTextField;
    private JPanel panel5;
    private JComboBox comboBox1;
    private JPanel panel18;
    private JButton button3;
    private JButton button2;
    private JPanel resultPanel;
    private JPanel panel7;
    private ColleagueLabel nameOfHeuristicsLabel;
    private ColleagueLabel timeLabel;
    private ColleagueLabel distanceLabel;
    private JPanel panel8;
    private ColleagueCheckBox insertionCheckBox;
    private ColleagueSecPanelTextF insertionTimeTextF;
    private ColleagueSecPanelTextF insertionDisTanceTextF;
    private JPanel panel9;
    private ColleagueCheckBox nnCheckBox;
    private ColleagueSecPanelTextF nnTimeTextF;
    private ColleagueSecPanelTextF nnDistanceTextF;
    private JPanel panel10;
    private ColleagueCheckBox optAlgoCheckBox;
    private ColleagueSecPanelTextF optTimeText;
    private ColleagueSecPanelTextF optDistanceTextF;
    private JPanel panel11;
    private ColleagueLabel advancedHeuLabel;
    private JPanel panel12;
    private ColleagueCheckBox simultedACheckBox;
    private ColleagueSecPanelTextF sAtimeTextF;
    private ColleagueSecPanelTextF sAdistanceTextF;
    private JPanel panel13;
    private ColleagueCheckBox tabuCheckBox;
    private JTextField textField13;
    private JTextField textField17;
    private JPanel panel14;
    private JButton button10;
    private JButton button9;
    private JPanel panel15;
    private JPanel panel16;
    private JPanel panel17;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JSlider slider1;
    private JPanel panelMap;


    @Override
    public void colleagueChanged() {

        cityTextChanged();
        startButtonPushed();
        shortestButtonPushed();
        checkBoxCheckedAndUnchecked();
        pack();

        // System.out.println(initButton.e.getSource());
    }

    private void checkBoxCheckedAndUnchecked() {
        if (insertionCheckBox.pushed) {
            removeGraphfromPanel();
            // graphObectDuplicator();
            graphEdgeRemover();
            insertionAlgoRunner();
            // graph object appears or disappears by doing this

            nnCheckBox.setSelected(false);
            optAlgoCheckBox.setSelected(false);
        }


        if (nnCheckBox.pushed) {
            removeGraphfromPanel();
            // graphObectDuplicator();
            graphEdgeRemover();
            nearestAlgorithmRunner();
            // graph object appears or disappears by doing this

            insertionCheckBox.setSelected(false);
            optAlgoCheckBox.setSelected(false);
        }

        if (optAlgoCheckBox.pushed) {
            removeGraphfromPanel();
            // graphObectDuplicator();
            graphEdgeRemover();
            twoOptAlgorithmRunner();

            nnCheckBox.setSelected(false);
            insertionCheckBox.setSelected(false);
        }

        if (simultedACheckBox.pushed) {
            removeGraphfromPanel();
            // graphObectDuplicator();
            graphEdgeRemover();
            sAAlgoRunner();

            nnCheckBox.setSelected(false);
            insertionCheckBox.setSelected(false);
        }


    }

    private void shortestButtonPushed() {
        if (shortestButton.pushed && shortestButton.getActionCommand().equals("Shortest Path")) {
            // removeGraphfromPanel();
            graphObectDuplicator();

            // graphEdgeRemover();

            //nearestAlgorithmRunner();
            //insertionAlgoRunner();
            //twoOptAlgorithmRunner();


            //  System.out.println("short source =  " + shortestButton.getSource());
            //System.out.println("short actionCommand =  " + shortestButton.getActionCommand());

            //nameOfHeuristicsLabel.setColleagueEnabled(true);
            //timeLabel.setColleagueEnabled(true);
            //distanceLabel.setColleagueEnabled(true);


            //  insertGraphintoPanelMap(new Algorithm.InsertionAlgo(graphG).run());
            //insertionCheckBox.setColleagueEnabled(true);


            //graphG.oneEdgeDrawer();


            // nnCheckBox.setColleagueEnabled(true);

            //optAlgoCheckBox.setColleagueEnabled(true);

            //advancedHeuLabel.setColleagueEnabled(true);
            //simultedACheckBox.setColleagueEnabled(true);
            //tabuCheckBox.setColleagueEnabled(true);
            shortestButton.pushed = false;
            secondPanelElementsSwitch(true);


        }

    }

    private void removeGraphfromPanel() {
        if (panelMap.getComponentCount() > 0) {
            for (int i = 0; i < panelMap.getComponentCount(); i++)
                panelMap.remove(i);
        }
    }


    private void graphEdgeRemover() {
        try {
            graphGnearnAlgoGraph.allEdgeRemover();
            graphInsertionAlgoGraph.allEdgeRemover();
            graphTwoOptAlgoGraph.allEdgeRemover();
            graphSAalgoGraph.allEdgeRemover();

            //   GraphGenerator graphGnearnAlgoGraph = graphG;
            //   GraphGenerator graphGnearnAlgoGraph = graphG;
            //   GraphGenerator graphGnearnAlgoGraph = graphG;
        } catch (NullPointerException e) {

        }
    }

    private void graphObectDuplicator() {
        try {
            graphGnearnAlgoGraph = (GraphGenerator) graphG.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            graphInsertionAlgoGraph = (GraphGenerator) graphG.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        try {
            graphTwoOptAlgoGraph = (GraphGenerator) graphG.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        try {
            graphSAalgoGraph = (GraphGenerator) graphG.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        //   GraphGenerator graphGnearnAlgoGraph = graphG;
        //   GraphGenerator graphGnearnAlgoGraph = graphG;
        //   GraphGenerator graphGnearnAlgoGraph = graphG;
    }

    private void insertionAlgoRunner() {
        long start = System.currentTimeMillis();
        InsertionAlgo insertAlgo = new InsertionAlgo(graphInsertionAlgoGraph);
        long end = System.currentTimeMillis();
        insertionDisTanceTextF.setText(String.valueOf(insertAlgo.getTotalDistance()));
        insertionTimeTextF.setText(String.valueOf((end - start)));
        insertGraphintoPanelMap(insertAlgo.run());
    }

    private void sAAlgoRunner() {
        long start = System.currentTimeMillis();
        SimulatedAnnealingAlgo sAAlgo = new SimulatedAnnealingAlgo(graphSAalgoGraph);
        long end = System.currentTimeMillis();
        sAdistanceTextF.setText(String.valueOf(sAAlgo.getTotalDistance()));
        sAtimeTextF.setText(String.valueOf((end - start)));
        insertGraphintoPanelMap(sAAlgo.run());
    }

    private void nearestAlgorithmRunner() {
        long start = System.currentTimeMillis();
        NearestNeighbourAlgo nnAlgo = new NearestNeighbourAlgo(graphGnearnAlgoGraph);
        long end = System.currentTimeMillis();
        nnDistanceTextF.setText(String.valueOf(nnAlgo.getTotalDistance()));
        nnTimeTextF.setText(String.valueOf((end - start)));
        insertGraphintoPanelMap(nnAlgo.run());
    }

    private void twoOptAlgorithmRunner() {
        long start = System.currentTimeMillis();
        TwoOptAlgo twoOptAlgo = new TwoOptAlgo(graphTwoOptAlgoGraph);
        long end = System.currentTimeMillis();
        optDistanceTextF.setText(String.valueOf(twoOptAlgo.getTotalDistance()));
        optTimeText.setText(String.valueOf((end - start)));
        insertGraphintoPanelMap(twoOptAlgo.run());
    }

    private void startButtonPushed() {
        //   System.out.println(initButton.getActionCommand());
        //   System.out.println(initButton.getText());
        if (initButton.pushed)

        {
            if (initButton.getActionCommand().equals(INITIALISATION)) {
                // System.out.println("init ac  =   "+initButton.e.getActionCommand());
                //  System.out.println("init source  =   "+initButton.e.getSource());
                // System.out.println("init something  =   " + initButton.getActionCommand());

                removeGraphfromPanel();
                graphEdgeRemover();

                graphG.createGraph(numberofcityGetter());
                insertGraphintoPanelMap(graphG.componentGetter());
                shortestButton.setColleagueEnabled(true);

                //System.out.println("working");
                //System.out.println(cityNumberTextField.getText());
                // panelMap.add(new JLabel("sdf"));

                //System.out.println(cityNumberTextField.getText());
                //Graph.NodeDataStore nodeArray = new Graph.NodeDataStore(Integer.parseInt(cityNumberTextField.getText()));

                /*
                Graph.NodeDataStore nodeArray = new Graph.NodeDataStore(numberofcityGetter());
                this.graph = new Graph.Testing.GraphGenerator(nodeArray);
                panelMap.add(graph.returnJGraph());
                shortestButton.setColleagueEnabled(true);
                */
                initButton.pushed = false;
                graphObectDuplicator();
                secondPanelElementsSwitch(true);
                //secondPanelElementsSwitch(false);


            }
        }
    }

    private void insertGraphintoPanelMap(mxGraphComponent compo) {

        panelMap.add(compo);
    }

    private void secondPanelElementsSwitch(boolean bswitch) {
        nameOfHeuristicsLabel.setColleagueEnabled(bswitch);
        timeLabel.setColleagueEnabled(bswitch);
        distanceLabel.setColleagueEnabled(bswitch);


        nnCheckBox.setColleagueEnabled(bswitch);
        nnTimeTextF.setColleagueEnabled(bswitch);
        nnDistanceTextF.setColleagueEnabled(bswitch);

        insertionCheckBox.setColleagueEnabled(bswitch);
        insertionDisTanceTextF.setColleagueEnabled(bswitch);
        insertionTimeTextF.setColleagueEnabled(bswitch);

        optAlgoCheckBox.setColleagueEnabled(bswitch);
        optDistanceTextF.setColleagueEnabled(bswitch);
        optTimeText.setColleagueEnabled(bswitch);

        simultedACheckBox.setColleagueEnabled(bswitch);
        sAtimeTextF.setColleagueEnabled(bswitch);
        sAdistanceTextF.setColleagueEnabled(bswitch);


        //  insertionDisTanceTextF.setColl

        //optAlgoCheckBox.setColleagueEnabled(true);

        //advancedHeuLabel.setColleagueEnabled(true);
        //simultedACheckBox.setColleagueEnabled(true);
        //tabuCheckBox.setColleagueEnabled(true);


    }

    private int numberofcityGetter() {
        int numberofcity = Integer.parseInt(cityNumberTextField.getText());
        return numberofcity;
    }

    private void cityTextChanged() {

        char a = 'a';
        if (cityNumberTextField.getText().length() > 0) {
            a = cityNumberTextField.getText().charAt(cityNumberTextField.getText().length() - 1);
        }
        boolean isDigit = (a >= '0' && a <= '9');

        String y = a + "";
        Pattern p1 = Pattern.compile("[a-zA-Z0-9]");
        Matcher m1 = p1.matcher(y);


        Pattern p2 = Pattern.compile("-?[0-9]+");
        Matcher m2 = p2.matcher(cityNumberTextField.getText());


        //System.out.println(cityNumberTextField.getText()+"");

        boolean ok = false;
        if (m2.matches()) {
            initButton.setColleagueEnabled(true);
            ok = true;
        }

        if (isDigit && m1.matches()) {

            initButton.setColleagueEnabled(true);


        } else if (ok) {
            initButton.setColleagueEnabled(true);
        } else {
            initButton.setColleagueEnabled(false);
        }
        try {
            if (Integer.parseInt(cityNumberTextField.getText()) > 500) {
                initButton.setColleagueEnabled(false);
            }
        } catch (NumberFormatException e32) {

        }


/*
        String c = cityNumberTextField.getText();
        try {
            int d = Integer.parseInt(c);
            initButton.setEnabled(true);

        } catch (NumberFormatException e3) {

        }
*/
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
