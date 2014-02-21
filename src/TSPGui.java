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

    private GraphGenerator graph;
    public final static String Initialisation = "Initialisation";

    public TSPGui() {
        //  graph = new GraphGenerator();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setMinimumSize(new Dimension(1000, 620));
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
        initButton = new ColleagueButton(Initialisation);
        button1 = new JButton();
        panel19 = new JPanel();
        label5 = new JLabel();
        cityNumberTextField = new ColleagueTextField("");
        panel5 = new JPanel();
        comboBox1 = new JComboBox();
        panel18 = new JPanel();
        button3 = new JButton();
        button2 = new JButton();
        panel6 = new JPanel();
        panel7 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        panel8 = new JPanel();
        checkBox4 = new JCheckBox();
        textField8 = new JTextField();
        textField7 = new JTextField();
        panel9 = new JPanel();
        checkBox5 = new JCheckBox();
        textField9 = new JTextField();
        textField11 = new JTextField();
        panel10 = new JPanel();
        checkBox6 = new JCheckBox();
        textField10 = new JTextField();
        textField14 = new JTextField();
        panel11 = new JPanel();
        label4 = new JLabel();
        panel12 = new JPanel();
        checkBox8 = new JCheckBox();
        textField12 = new JTextField();
        textField16 = new JTextField();
        panel13 = new JPanel();
        checkBox9 = new JCheckBox();
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

        ButtonHandler butEvent = new ButtonHandler();
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
                panel1.setPreferredSize(new Dimension(300, 590));

                //======== panel3 ========
                {
                    panel3.setBorder(new TitledBorder("Initialisation"));

                    //======== panel4 ========
                    {
                        panel4.setLayout(new GridLayout(1, 2));

                        //---- initButton ----
                        initButton.setMediator(this);
                        initButton.setEnabled(false);
                        initButton.addActionListener(initButton);
                        panel4.add(initButton);

                        //---- button1 ----
                        button1.setText("Stop/Reset");
                        button1.setEnabled(false);
                        panel4.add(button1);
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
                        panel18.add(button3);

                        //---- button2 ----
                        button2.setText("Stop");
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

                //======== panel6 ========
                {
                    panel6.setBorder(new TitledBorder("Results"));
                    panel6.setLayout(new GridLayout(8, 0));

                    //======== panel7 ========
                    {
                        panel7.setEnabled(false);
                        panel7.setBorder(null);

                        //---- label1 ----
                        label1.setText("Name of heuristics");
                        label1.setEnabled(false);

                        //---- label2 ----
                        label2.setText("Distance");
                        label2.setEnabled(false);

                        //---- label3 ----
                        label3.setText("Time");
                        label3.setEnabled(false);

                        GroupLayout panel7Layout = new GroupLayout(panel7);
                        panel7.setLayout(panel7Layout);
                        panel7Layout.setHorizontalGroup(
                                panel7Layout.createParallelGroup()
                                        .addGroup(panel7Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(label2)
                                                .addGap(12, 12, 12)
                                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(3, Short.MAX_VALUE))
                        );
                        panel7Layout.setVerticalGroup(
                                panel7Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(panel7Layout.createSequentialGroup()
                                                .addGap(0, 14, Short.MAX_VALUE)
                                                .addGroup(panel7Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(label3)
                                                        .addComponent(label2)))
                        );
                    }
                    panel6.add(panel7);

                    //======== panel8 ========
                    {
                        panel8.setBorder(null);

                        //---- checkBox4 ----
                        checkBox4.setText("Insertion");
                        checkBox4.setEnabled(false);

                        //---- textField8 ----
                        textField8.setEnabled(false);

                        //---- textField7 ----
                        textField7.setEnabled(false);

                        GroupLayout panel8Layout = new GroupLayout(panel8);
                        panel8.setLayout(panel8Layout);
                        panel8Layout.setHorizontalGroup(
                                panel8Layout.createParallelGroup()
                                        .addGroup(panel8Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(checkBox4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
                                                .addGap(28, 28, 28)
                                                .addComponent(textField8, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField7, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        );
                        panel8Layout.setVerticalGroup(
                                panel8Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel8Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel8Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox4)
                                                        .addComponent(textField8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel6.add(panel8);

                    //======== panel9 ========
                    {
                        panel9.setBorder(null);

                        //---- checkBox5 ----
                        checkBox5.setText("Nearest Neighbour");
                        checkBox5.setEnabled(false);

                        //---- textField9 ----
                        textField9.setEnabled(false);

                        //---- textField11 ----
                        textField11.setEnabled(false);

                        GroupLayout panel9Layout = new GroupLayout(panel9);
                        panel9.setLayout(panel9Layout);
                        panel9Layout.setHorizontalGroup(
                                panel9Layout.createParallelGroup()
                                        .addGroup(panel9Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(checkBox5, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField9, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField11, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        );
                        panel9Layout.setVerticalGroup(
                                panel9Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel9Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel9Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox5)
                                                        .addComponent(textField9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel6.add(panel9);

                    //======== panel10 ========
                    {
                        panel10.setBorder(null);

                        //---- checkBox6 ----
                        checkBox6.setText("2 opt & 3 opt");
                        checkBox6.setEnabled(false);

                        //---- textField10 ----
                        textField10.setEnabled(false);

                        //---- textField14 ----
                        textField14.setEnabled(false);

                        GroupLayout panel10Layout = new GroupLayout(panel10);
                        panel10.setLayout(panel10Layout);
                        panel10Layout.setHorizontalGroup(
                                panel10Layout.createParallelGroup()
                                        .addGroup(panel10Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(checkBox6, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(textField10, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField14, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        );
                        panel10Layout.setVerticalGroup(
                                panel10Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel10Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel10Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox6)
                                                        .addComponent(textField10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel6.add(panel10);

                    //======== panel11 ========
                    {
                        panel11.setBorder(null);

                        //---- label4 ----
                        label4.setText("Advanced Heuristics");
                        label4.setEnabled(false);

                        GroupLayout panel11Layout = new GroupLayout(panel11);
                        panel11.setLayout(panel11Layout);
                        panel11Layout.setHorizontalGroup(
                                panel11Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                                .addContainerGap(65, Short.MAX_VALUE)
                                                .addComponent(label4, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))
                        );
                        panel11Layout.setVerticalGroup(
                                panel11Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel11Layout.createSequentialGroup()
                                                .addContainerGap(14, Short.MAX_VALUE)
                                                .addComponent(label4)
                                                .addContainerGap())
                        );
                    }
                    panel6.add(panel11);

                    //======== panel12 ========
                    {
                        panel12.setBorder(null);

                        //---- checkBox8 ----
                        checkBox8.setText("Simul.. Annealing");
                        checkBox8.setEnabled(false);

                        //---- textField12 ----
                        textField12.setEnabled(false);

                        //---- textField16 ----
                        textField16.setEnabled(false);

                        GroupLayout panel12Layout = new GroupLayout(panel12);
                        panel12.setLayout(panel12Layout);
                        panel12Layout.setHorizontalGroup(
                                panel12Layout.createParallelGroup()
                                        .addGroup(panel12Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(checkBox8, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
                                                .addGap(20, 20, 20)
                                                .addComponent(textField16, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField12, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        );
                        panel12Layout.setVerticalGroup(
                                panel12Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel12Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel12Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox8)
                                                        .addComponent(textField16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel6.add(panel12);

                    //======== panel13 ========
                    {
                        panel13.setBorder(null);

                        //---- checkBox9 ----
                        checkBox9.setText("Tabu Search");
                        checkBox9.setEnabled(false);

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
                                                .addComponent(checkBox9, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(textField13, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textField17, GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE))
                        );
                        panel13Layout.setVerticalGroup(
                                panel13Layout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, panel13Layout.createSequentialGroup()
                                                .addGap(0, 10, Short.MAX_VALUE)
                                                .addGroup(panel13Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(checkBox9)
                                                        .addComponent(textField13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textField17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        );
                    }
                    panel6.add(panel13);
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
                    panel14.add(button9);
                }

                GroupLayout panel1Layout = new GroupLayout(panel1);
                panel1.setLayout(panel1Layout);
                panel1Layout.setHorizontalGroup(
                        panel1Layout.createParallelGroup()
                                .addComponent(panel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(panel14, GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
                                .addComponent(panel6, GroupLayout.DEFAULT_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(panel5, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                );
                panel1Layout.setVerticalGroup(
                        panel1Layout.createParallelGroup()
                                .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(panel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(panel6, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
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
    private JButton button1;
    private JPanel panel19;
    private JLabel label5;
    private ColleagueTextField cityNumberTextField;
    private JPanel panel5;
    private JComboBox comboBox1;
    private JPanel panel18;
    private JButton button3;
    private JButton button2;
    private JPanel panel6;
    private JPanel panel7;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JPanel panel8;
    private JCheckBox checkBox4;
    private JTextField textField8;
    private JTextField textField7;
    private JPanel panel9;
    private JCheckBox checkBox5;
    private JTextField textField9;
    private JTextField textField11;
    private JPanel panel10;
    private JCheckBox checkBox6;
    private JTextField textField10;
    private JTextField textField14;
    private JPanel panel11;
    private JLabel label4;
    private JPanel panel12;
    private JCheckBox checkBox8;
    private JTextField textField12;
    private JTextField textField16;
    private JPanel panel13;
    private JCheckBox checkBox9;
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
        if (ColleagueButton.pushed) startButtonPushed();

    }

    private void startButtonPushed() {
        //   System.out.println(initButton.getActionCommand());
        //   System.out.println(initButton.getText());

        if (initButton.e.getSource() == initButton) {
            if (panelMap.getComponentCount() > 0) {
                panelMap.remove(0);
            }
            //System.out.println("working");
            //System.out.println(cityNumberTextField.getText());
            // panelMap.add(new JLabel("sdf"));

            //System.out.println(cityNumberTextField.getText());
            NodeDataStore nodeArray = new NodeDataStore(Integer.parseInt(cityNumberTextField.getText()));
            this.graph = new GraphGenerator(nodeArray);
            panelMap.add(graph.returnJGraph());
            pack();

        }
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
