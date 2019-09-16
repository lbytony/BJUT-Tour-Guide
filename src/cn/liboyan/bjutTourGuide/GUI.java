/*
 * Created by JFormDesigner on Thu Sep 05 20:45:45 CST 2019
 */

package cn.liboyan.bjutTourGuide;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

/**
 * @author Li Boyan, BJUT
 */
public class GUI extends JFrame {
    public GUI() {
        initComponents();
    }

    private void menu1MouseClicked(MouseEvent e) {
        // TODO add your code here

    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        menuBar1 = new JMenuBar();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menu2 = new JMenu();
        menu3 = new JMenu();
        panel1 = new JPanel();
        label1 = new JLabel();
        hourSelect = new JComboBox();
        label2 = new JLabel();
        minuteSelect = new JComboBox();
        button1 = new JButton();
        panel2 = new JPanel();

        //======== this ========
        setTitle("Campus Tour Guide of BJUT");
        setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));

        //======== menuBar1 ========
        {
            menuBar1.setMaximumSize(new Dimension(105, 600));

            //======== menu1 ========
            {
                menu1.setText("text");

                //---- menuItem1 ----
                menuItem1.setText("text");
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);

            //======== menu2 ========
            {
                menu2.setText("text");
            }
            menuBar1.add(menu2);

            //======== menu3 ========
            {
                menu3.setText("text");
            }
            menuBar1.add(menu3);
        }
        setJMenuBar(menuBar1);

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

            //---- label1 ----
            label1.setText("Departure Time: ");
            panel1.add(label1);
            panel1.add(hourSelect);

            //---- label2 ----
            label2.setText(" : ");
            panel1.add(label2);
            panel1.add(minuteSelect);

            //---- button1 ----
            button1.setText("Add Place");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel1.add(button1);
        }
        contentPane.add(panel1);

        //======== panel2 ========
        {
            panel2.setLayout(new BorderLayout(5, 5));
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
    private JMenu menu2;
    private JMenu menu3;
    private JPanel panel1;
    private JLabel label1;
    private JComboBox hourSelect;
    private JLabel label2;
    private JComboBox minuteSelect;
    private JButton button1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public void main(String[] args) {
        initComponents();
    }

}
