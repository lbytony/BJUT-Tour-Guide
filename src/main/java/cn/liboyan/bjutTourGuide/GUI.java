/*
 * Created by JFormDesigner on Thu Sep 05 20:45:45 CST 2019
 */

package cn.liboyan.bjutTourGuide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Li Boyan, BJUT
 */
public class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menu2 = new JMenu();
        menuItem4 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menu3 = new JMenu();
        menuItem6 = new JMenuItem();
        menuItem7 = new JMenuItem();
        panel1 = new JPanel();
        panel3 = new JPanel();
        label1 = new JLabel();
        hourSelect = new JComboBox();
        label2 = new JLabel();
        minuteSelect = new JComboBox();
        button1 = new JButton();
        panel4 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        comboBox1 = new JComboBox();
        label7 = new JLabel();
        comboBox2 = new JComboBox();
        panel5 = new JPanel();
        label8 = new JLabel();
        label9 = new JLabel();
        label10 = new JLabel();
        comboBox3 = new JComboBox();
        label11 = new JLabel();
        comboBox4 = new JComboBox();
        panel6 = new JPanel();
        label12 = new JLabel();
        label13 = new JLabel();
        label14 = new JLabel();
        comboBox5 = new JComboBox();
        label15 = new JLabel();
        comboBox6 = new JComboBox();
        panel7 = new JPanel();
        label16 = new JLabel();
        label17 = new JLabel();
        label18 = new JLabel();
        comboBox7 = new JComboBox();
        label19 = new JLabel();
        comboBox8 = new JComboBox();
        panel8 = new JPanel();
        label20 = new JLabel();
        label21 = new JLabel();
        label22 = new JLabel();
        comboBox9 = new JComboBox();
        label23 = new JLabel();
        comboBox10 = new JComboBox();
        panel9 = new JPanel();
        label24 = new JLabel();
        label25 = new JLabel();
        label26 = new JLabel();
        comboBox11 = new JComboBox();
        label27 = new JLabel();
        comboBox12 = new JComboBox();
        panel10 = new JPanel();
        label28 = new JLabel();
        label29 = new JLabel();
        label30 = new JLabel();
        comboBox13 = new JComboBox();
        label31 = new JLabel();
        comboBox14 = new JComboBox();
        panel11 = new JPanel();
        label32 = new JLabel();
        label33 = new JLabel();
        label34 = new JLabel();
        comboBox15 = new JComboBox();
        label35 = new JLabel();
        comboBox16 = new JComboBox();
        panel12 = new JPanel();
        label36 = new JLabel();
        label37 = new JLabel();
        label38 = new JLabel();
        comboBox17 = new JComboBox();
        label39 = new JLabel();
        comboBox18 = new JComboBox();
        panel2 = new JPanel();
        label3 = new JLabel();

        //======== this ========
        setTitle("Campus Tour Guide of BJUT");
        setFont(new Font("Dialog", Font.BOLD, 12));
        Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        //======== menuBar1 ========
        {
            menuBar1.setMaximumSize(new Dimension(105, 600));

            //======== menu1 ========
            {
                menu1.setText("File");

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("text");
                menu1.add(menuItem2);

                //---- menuItem3 ----
                menuItem3.setText("text");
                menu1.add(menuItem3);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("Edit");

                //---- menuItem4 ----
                menuItem4.setText("text");
                menu2.add(menuItem4);

                //---- menuItem5 ----
                menuItem5.setText("text");
                menu2.add(menuItem5);
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("text");

                //---- menuItem6 ----
                menuItem6.setText("text");
                menu3.add(menuItem6);

                //---- menuItem7 ----
                menuItem7.setText("text");
                menu3.add(menuItem7);
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayout(10, 6));

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label1 ----
                label1.setText("Departure Time: ");
                panel3.add(label1);
                panel3.add(hourSelect);

                //---- label2 ----
                label2.setText(" : ");
                panel3.add(label2);
                panel3.add(minuteSelect);

                //---- button1 ----
                button1.setText("Add Place");
                button1.setHorizontalAlignment(SwingConstants.LEFT);
                button1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        button1ActionPerformed(e);
                    }
                });
                panel3.add(button1);
            }
            panel1.add(panel3);

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label4 ----
                label4.setText("Place ");
                panel4.add(label4);

                //---- label5 ----
                label5.setText("1");
                panel4.add(label5);

                //---- label6 ----
                label6.setText(":");
                panel4.add(label6);
                panel4.add(comboBox1);

                //---- label7 ----
                label7.setText("Duration Time: ");
                panel4.add(label7);
                panel4.add(comboBox2);
            }
            panel1.add(panel4);

            //======== panel5 ========
            {
                panel5.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label8 ----
                label8.setText("Place ");
                panel5.add(label8);

                //---- label9 ----
                label9.setText("1");
                panel5.add(label9);

                //---- label10 ----
                label10.setText(":");
                panel5.add(label10);
                panel5.add(comboBox3);

                //---- label11 ----
                label11.setText("Duration Time: ");
                panel5.add(label11);
                panel5.add(comboBox4);
            }
            panel1.add(panel5);

            //======== panel6 ========
            {
                panel6.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label12 ----
                label12.setText("Place ");
                panel6.add(label12);

                //---- label13 ----
                label13.setText("1");
                panel6.add(label13);

                //---- label14 ----
                label14.setText(":");
                panel6.add(label14);
                panel6.add(comboBox5);

                //---- label15 ----
                label15.setText("Duration Time: ");
                panel6.add(label15);
                panel6.add(comboBox6);
            }
            panel1.add(panel6);

            //======== panel7 ========
            {
                panel7.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label16 ----
                label16.setText("Place ");
                panel7.add(label16);

                //---- label17 ----
                label17.setText("1");
                panel7.add(label17);

                //---- label18 ----
                label18.setText(":");
                panel7.add(label18);
                panel7.add(comboBox7);

                //---- label19 ----
                label19.setText("Duration Time: ");
                panel7.add(label19);
                panel7.add(comboBox8);
            }
            panel1.add(panel7);

            //======== panel8 ========
            {
                panel8.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label20 ----
                label20.setText("Place ");
                panel8.add(label20);

                //---- label21 ----
                label21.setText("1");
                panel8.add(label21);

                //---- label22 ----
                label22.setText(":");
                panel8.add(label22);
                panel8.add(comboBox9);

                //---- label23 ----
                label23.setText("Duration Time: ");
                panel8.add(label23);
                panel8.add(comboBox10);
            }
            panel1.add(panel8);

            //======== panel9 ========
            {
                panel9.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label24 ----
                label24.setText("Place ");
                panel9.add(label24);

                //---- label25 ----
                label25.setText("1");
                panel9.add(label25);

                //---- label26 ----
                label26.setText(":");
                panel9.add(label26);
                panel9.add(comboBox11);

                //---- label27 ----
                label27.setText("Duration Time: ");
                panel9.add(label27);
                panel9.add(comboBox12);
            }
            panel1.add(panel9);

            //======== panel10 ========
            {
                panel10.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label28 ----
                label28.setText("Place ");
                panel10.add(label28);

                //---- label29 ----
                label29.setText("1");
                panel10.add(label29);

                //---- label30 ----
                label30.setText(":");
                panel10.add(label30);
                panel10.add(comboBox13);

                //---- label31 ----
                label31.setText("Duration Time: ");
                panel10.add(label31);
                panel10.add(comboBox14);
            }
            panel1.add(panel10);

            //======== panel11 ========
            {
                panel11.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label32 ----
                label32.setText("Place ");
                panel11.add(label32);

                //---- label33 ----
                label33.setText("1");
                panel11.add(label33);

                //---- label34 ----
                label34.setText(":");
                panel11.add(label34);
                panel11.add(comboBox15);

                //---- label35 ----
                label35.setText("Duration Time: ");
                panel11.add(label35);
                panel11.add(comboBox16);
            }
            panel1.add(panel11);

            //======== panel12 ========
            {
                panel12.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 7));

                //---- label36 ----
                label36.setText("Place ");
                panel12.add(label36);

                //---- label37 ----
                label37.setText("1");
                panel12.add(label37);

                //---- label38 ----
                label38.setText(":");
                panel12.add(label38);
                panel12.add(comboBox17);

                //---- label39 ----
                label39.setText("Duration Time: ");
                panel12.add(label39);
                panel12.add(comboBox18);
            }
            panel1.add(panel12);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout(5, 5));
            panel2.add(label3, BorderLayout.CENTER);
        }
        contentPane.add(panel2);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JMenuBar menuBar1;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JMenuItem menuItem3;
    private JMenu menu2;
    private JMenuItem menuItem4;
    private JMenuItem menuItem5;
    private JMenu menu3;
    private JMenuItem menuItem6;
    private JMenuItem menuItem7;
    private JPanel panel1;
    private JPanel panel3;
    private JLabel label1;
    private JComboBox hourSelect;
    private JLabel label2;
    private JComboBox minuteSelect;
    private JButton button1;
    private JPanel panel4;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JComboBox comboBox1;
    private JLabel label7;
    private JComboBox comboBox2;
    private JPanel panel5;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JComboBox comboBox3;
    private JLabel label11;
    private JComboBox comboBox4;
    private JPanel panel6;
    private JLabel label12;
    private JLabel label13;
    private JLabel label14;
    private JComboBox comboBox5;
    private JLabel label15;
    private JComboBox comboBox6;
    private JPanel panel7;
    private JLabel label16;
    private JLabel label17;
    private JLabel label18;
    private JComboBox comboBox7;
    private JLabel label19;
    private JComboBox comboBox8;
    private JPanel panel8;
    private JLabel label20;
    private JLabel label21;
    private JLabel label22;
    private JComboBox comboBox9;
    private JLabel label23;
    private JComboBox comboBox10;
    private JPanel panel9;
    private JLabel label24;
    private JLabel label25;
    private JLabel label26;
    private JComboBox comboBox11;
    private JLabel label27;
    private JComboBox comboBox12;
    private JPanel panel10;
    private JLabel label28;
    private JLabel label29;
    private JLabel label30;
    private JComboBox comboBox13;
    private JLabel label31;
    private JComboBox comboBox14;
    private JPanel panel11;
    private JLabel label32;
    private JLabel label33;
    private JLabel label34;
    private JComboBox comboBox15;
    private JLabel label35;
    private JComboBox comboBox16;
    private JPanel panel12;
    private JLabel label36;
    private JLabel label37;
    private JLabel label38;
    private JComboBox comboBox17;
    private JLabel label39;
    private JComboBox comboBox18;
    private JPanel panel2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void main(String[] args) {
        initComponents();
    }

}