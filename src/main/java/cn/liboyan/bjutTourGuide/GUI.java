package cn.liboyan.bjutTourGuide;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * @author Li Boyan, BJUT
 */

public class GUI extends JFrame {
    public GUI() {
        initComponents();
        BJUTTourGuide.run = false;
    }

    public JCheckBox selCheckBox(int i) {
        JCheckBox rtn = null;
        switch (i) {
            case 1:
                rtn = checkBox_P1;
                break;
            case 2:
                rtn = checkBox_P2;
                break;
            case 3:
                rtn = checkBox_P3;
                break;
            case 4:
                rtn = checkBox_P4;
                break;
            case 5:
                rtn = checkBox_P5;
                break;
            case 6:
                rtn = checkBox_P6;
                break;
            case 7:
                rtn = checkBox_P7;
                break;
            case 8:
                rtn = checkBox_P8;
                break;
            case 9:
                rtn = checkBox_P9;
                break;
            case 10:
                rtn = checkBox_P10;
                break;
            case 11:
                rtn = checkBox_P11;
                break;
        }
        return rtn;
    }

    public String selComboBox(int i) {
        JComboBox<String> rtn = null;
        switch (i) {
            case 1:
                rtn = Place_P1;
                break;
            case 2:
                rtn = Place_P2;
                break;
            case 3:
                rtn = Place_P3;
                break;
            case 4:
                rtn = Place_P4;
                break;
            case 5:
                rtn = Place_P5;
                break;
            case 6:
                rtn = Place_P6;
                break;
            case 7:
                rtn = Place_P7;
                break;
            case 8:
                rtn = Place_P8;
                break;
            case 9:
                rtn = Place_P9;
                break;
            case 10:
                rtn = Place_P10;
                break;
            case 11:
                rtn = Place_P11;
                break;
        }
        return rtn.getSelectedItem().toString();
    }

    public JTextField selTextField(int i) {
        JTextField rtn = null;
        switch (i) {
            case 1:
                rtn = textField_P1;
                break;
            case 2:
                rtn = textField_P2;
                break;
            case 3:
                rtn = textField_P3;
                break;
            case 4:
                rtn = textField_P4;
                break;
            case 5:
                rtn = textField_P5;
                break;
            case 6:
                rtn = textField_P6;
                break;
            case 7:
                rtn = textField_P7;
                break;
            case 8:
                rtn = textField_P8;
                break;
            case 9:
                rtn = textField_P9;
                break;
            case 10:
                rtn = textField_P10;
                break;
            case 11:
                rtn = textField_P11;
                break;
        }
        return rtn;
    }

    public void buttonClrActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (e.getSource() == buttonClr) {
            textField_P1.setText("");
            textField_P2.setText("");
            textField_P3.setText("");
            textField_P4.setText("");
            textField_P5.setText("");
            textField_P6.setText("");
            textField_P7.setText("");
            textField_P8.setText("");
            textField_P9.setText("");
            textField_P10.setText("");
            textField_P11.setText("");
            Place_P1.setSelectedIndex(0);
            Place_P2.setSelectedIndex(0);
            Place_P3.setSelectedIndex(0);
            Place_P4.setSelectedIndex(0);
            Place_P5.setSelectedIndex(0);
            Place_P6.setSelectedIndex(0);
            Place_P7.setSelectedIndex(0);
            Place_P8.setSelectedIndex(0);
            Place_P9.setSelectedIndex(0);
            Place_P10.setSelectedIndex(0);
            Place_P11.setSelectedIndex(0);
            checkBox_P1.setSelected(false);
            checkBox_P2.setSelected(false);
            checkBox_P3.setSelected(false);
            checkBox_P4.setSelected(false);
            checkBox_P5.setSelected(false);
            checkBox_P6.setSelected(false);
            checkBox_P7.setSelected(false);
            checkBox_P8.setSelected(false);
            checkBox_P9.setSelected(false);
            checkBox_P10.setSelected(false);
            checkBox_P11.setSelected(false);
        }

    }

    public void buttonRunActionPerformed(ActionEvent e) {
        // TODO add your code here
        if (e.getSource() == buttonRun) {
            BJUTTourGuide.run = true;
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - unknown
        panel0 = new JPanel();
        label1 = new JLabel();
        hourSelect = new JComboBox<>();
        label2 = new JLabel();
        minuteSelect = new JComboBox<>();
        buttonRun = new JButton();
        buttonClr = new JButton();
        P1 = new JPanel();
        checkBox_P1 = new JCheckBox();
        Place_P1 = new JComboBox<>();
        Dur_P1 = new JLabel();
        textField_P1 = new JTextField();
        P2 = new JPanel();
        checkBox_P2 = new JCheckBox();
        Place_P2 = new JComboBox<>();
        Dur_P2 = new JLabel();
        textField_P2 = new JTextField();
        P3 = new JPanel();
        checkBox_P3 = new JCheckBox();
        Place_P3 = new JComboBox<>();
        Dur_P3 = new JLabel();
        textField_P3 = new JTextField();
        P4 = new JPanel();
        checkBox_P4 = new JCheckBox();
        Place_P4 = new JComboBox<>();
        Dur_P4 = new JLabel();
        textField_P4 = new JTextField();
        P5 = new JPanel();
        checkBox_P5 = new JCheckBox();
        Place_P5 = new JComboBox<>();
        Dur_P5 = new JLabel();
        textField_P5 = new JTextField();
        P6 = new JPanel();
        checkBox_P6 = new JCheckBox();
        Place_P6 = new JComboBox<>();
        Dur_P6 = new JLabel();
        textField_P6 = new JTextField();
        P7 = new JPanel();
        checkBox_P7 = new JCheckBox();
        Place_P7 = new JComboBox<>();
        Dur_P7 = new JLabel();
        textField_P7 = new JTextField();
        P8 = new JPanel();
        checkBox_P8 = new JCheckBox();
        Place_P8 = new JComboBox<>();
        Dur_P8 = new JLabel();
        textField_P8 = new JTextField();
        P9 = new JPanel();
        checkBox_P9 = new JCheckBox();
        Place_P9 = new JComboBox<>();
        Dur_P9 = new JLabel();
        textField_P9 = new JTextField();
        P10 = new JPanel();
        checkBox_P10 = new JCheckBox();
        Place_P10 = new JComboBox<>();
        Dur_P10 = new JLabel();
        textField_P10 = new JTextField();
        P11 = new JPanel();
        checkBox_P11 = new JCheckBox();
        Place_P11 = new JComboBox<>();
        Dur_P11 = new JLabel();
        textField_P11 = new JTextField();

        //======== this ========
        setTitle("Campus Tour Guide of BJUT");
        setFont(new Font(Font.DIALOG, Font.BOLD, 12));
        setIconImage(new ImageIcon("C:\\Users\\lbyto\\OneDrive\\2019-2020-1\\\u6570\u636e\u7ed3\u6784\u8bfe\u8bbe\\BJUT-Tour-Guide\\src\\main\\resources\\B\u6807128\u65b9.png").getImage());
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(380, 480));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(12, 1));

        //======== panel0 ========
        {

            panel0.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override
                public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("\u0062order".equals(e.getPropertyName()))
                        throw new RuntimeException();
                }
            });
            panel0.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));

            //---- label1 ----
            label1.setText("Departure Time: ");
            panel0.add(label1);

            //---- hourSelect ----
            hourSelect.setModel(new DefaultComboBoxModel<>(new String[]{
                    "00",
                    "01",
                    "02",
                    "03",
                    "04",
                    "05",
                    "06",
                    "07",
                    "08",
                    "09",
                    "10",
                    "11",
                    "12",
                    "13",
                    "14",
                    "15",
                    "16",
                    "17",
                    "18",
                    "19",
                    "20",
                    "21",
                    "22",
                    "23"
            }));
            hourSelect.setEditable(true);
            hourSelect.setMaximumRowCount(10);
            hourSelect.setMinimumSize(new Dimension(80, 24));
            hourSelect.setPreferredSize(new Dimension(50, 24));
            panel0.add(hourSelect);

            //---- label2 ----
            label2.setText(":");
            panel0.add(label2);

            //---- minuteSelect ----
            minuteSelect.setModel(new DefaultComboBoxModel<>(new String[]{
                    "00",
                    "05",
                    "10",
                    "15",
                    "20",
                    "25",
                    "30",
                    "35",
                    "40",
                    "45",
                    "50",
                    "55"
            }));
            minuteSelect.setEditable(true);
            minuteSelect.setMaximumRowCount(10);
            minuteSelect.setMinimumSize(new Dimension(80, 24));
            minuteSelect.setPreferredSize(new Dimension(50, 24));
            panel0.add(minuteSelect);

            //---- buttonRun ----
            buttonRun.setText("Run");
            buttonRun.setPreferredSize(new Dimension(65, 24));
            buttonRun.setMinimumSize(new Dimension(70, 24));
            buttonRun.setMaximumSize(new Dimension(70, 24));
            buttonRun.addActionListener(e -> buttonRunActionPerformed(e));
            panel0.add(buttonRun);

            //---- buttonClr ----
            buttonClr.setText("Clear");
            buttonClr.setMaximumSize(new Dimension(70, 24));
            buttonClr.setMinimumSize(new Dimension(70, 24));
            buttonClr.setPreferredSize(new Dimension(65, 24));
            buttonClr.addActionListener(e -> buttonClrActionPerformed(e));
            panel0.add(buttonClr);
        }
        contentPane.add(panel0);

        //======== P1 ========
        {
            P1.setPreferredSize(new Dimension(451, 30));
            P1.setMinimumSize(new Dimension(478, 30));
            P1.setBorder(null);
            P1.setLayout(new FlowLayout(FlowLayout.LEFT));
            P1.add(checkBox_P1);

            //---- Place_P1 ----
            Place_P1.setPreferredSize(new Dimension(160, 24));
            Place_P1.setMinimumSize(new Dimension(120, 24));
            Place_P1.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P1.add(Place_P1);

            //---- Dur_P1 ----
            Dur_P1.setText("Duration Time: ");
            P1.add(Dur_P1);

            //---- textField_P1 ----
            textField_P1.setPreferredSize(new Dimension(80, 24));
            P1.add(textField_P1);
        }
        contentPane.add(P1);

        //======== P2 ========
        {
            P2.setPreferredSize(new Dimension(451, 30));
            P2.setMinimumSize(new Dimension(478, 30));
            P2.setBorder(null);
            P2.setLayout(new FlowLayout(FlowLayout.LEFT));
            P2.add(checkBox_P2);

            //---- Place_P2 ----
            Place_P2.setPreferredSize(new Dimension(160, 24));
            Place_P2.setMinimumSize(new Dimension(120, 24));
            Place_P2.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P2.add(Place_P2);

            //---- Dur_P2 ----
            Dur_P2.setText("Duration Time: ");
            P2.add(Dur_P2);

            //---- textField_P2 ----
            textField_P2.setPreferredSize(new Dimension(80, 24));
            P2.add(textField_P2);
        }
        contentPane.add(P2);

        //======== P3 ========
        {
            P3.setPreferredSize(new Dimension(451, 30));
            P3.setMinimumSize(new Dimension(478, 30));
            P3.setBorder(null);
            P3.setLayout(new FlowLayout(FlowLayout.LEFT));
            P3.add(checkBox_P3);

            //---- Place_P3 ----
            Place_P3.setPreferredSize(new Dimension(160, 24));
            Place_P3.setMinimumSize(new Dimension(120, 24));
            Place_P3.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P3.add(Place_P3);

            //---- Dur_P3 ----
            Dur_P3.setText("Duration Time: ");
            P3.add(Dur_P3);

            //---- textField_P3 ----
            textField_P3.setPreferredSize(new Dimension(80, 24));
            P3.add(textField_P3);
        }
        contentPane.add(P3);

        //======== P4 ========
        {
            P4.setPreferredSize(new Dimension(451, 30));
            P4.setMinimumSize(new Dimension(478, 30));
            P4.setBorder(null);
            P4.setLayout(new FlowLayout(FlowLayout.LEFT));
            P4.add(checkBox_P4);

            //---- Place_P4 ----
            Place_P4.setPreferredSize(new Dimension(160, 24));
            Place_P4.setMinimumSize(new Dimension(120, 24));
            Place_P4.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P4.add(Place_P4);

            //---- Dur_P4 ----
            Dur_P4.setText("Duration Time: ");
            P4.add(Dur_P4);

            //---- textField_P4 ----
            textField_P4.setPreferredSize(new Dimension(80, 24));
            P4.add(textField_P4);
        }
        contentPane.add(P4);

        //======== P5 ========
        {
            P5.setPreferredSize(new Dimension(451, 30));
            P5.setMinimumSize(new Dimension(478, 30));
            P5.setBorder(null);
            P5.setLayout(new FlowLayout(FlowLayout.LEFT));
            P5.add(checkBox_P5);

            //---- Place_P5 ----
            Place_P5.setPreferredSize(new Dimension(160, 24));
            Place_P5.setMinimumSize(new Dimension(120, 24));
            Place_P5.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P5.add(Place_P5);

            //---- Dur_P5 ----
            Dur_P5.setText("Duration Time: ");
            P5.add(Dur_P5);

            //---- textField_P5 ----
            textField_P5.setPreferredSize(new Dimension(80, 24));
            P5.add(textField_P5);
        }
        contentPane.add(P5);

        //======== P6 ========
        {
            P6.setPreferredSize(new Dimension(451, 30));
            P6.setMinimumSize(new Dimension(478, 30));
            P6.setBorder(null);
            P6.setLayout(new FlowLayout(FlowLayout.LEFT));
            P6.add(checkBox_P6);

            //---- Place_P6 ----
            Place_P6.setPreferredSize(new Dimension(160, 24));
            Place_P6.setMinimumSize(new Dimension(120, 24));
            Place_P6.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P6.add(Place_P6);

            //---- Dur_P6 ----
            Dur_P6.setText("Duration Time: ");
            P6.add(Dur_P6);

            //---- textField_P6 ----
            textField_P6.setPreferredSize(new Dimension(80, 24));
            P6.add(textField_P6);
        }
        contentPane.add(P6);

        //======== P7 ========
        {
            P7.setPreferredSize(new Dimension(451, 30));
            P7.setMinimumSize(new Dimension(478, 30));
            P7.setBorder(null);
            P7.setLayout(new FlowLayout(FlowLayout.LEFT));
            P7.add(checkBox_P7);

            //---- Place_P7 ----
            Place_P7.setPreferredSize(new Dimension(160, 24));
            Place_P7.setMinimumSize(new Dimension(120, 24));
            Place_P7.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P7.add(Place_P7);

            //---- Dur_P7 ----
            Dur_P7.setText("Duration Time: ");
            P7.add(Dur_P7);

            //---- textField_P7 ----
            textField_P7.setPreferredSize(new Dimension(80, 24));
            P7.add(textField_P7);
        }
        contentPane.add(P7);

        //======== P8 ========
        {
            P8.setPreferredSize(new Dimension(451, 30));
            P8.setMinimumSize(new Dimension(478, 30));
            P8.setBorder(null);
            P8.setLayout(new FlowLayout(FlowLayout.LEFT));
            P8.add(checkBox_P8);

            //---- Place_P8 ----
            Place_P8.setPreferredSize(new Dimension(160, 24));
            Place_P8.setMinimumSize(new Dimension(120, 24));
            Place_P8.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P8.add(Place_P8);

            //---- Dur_P8 ----
            Dur_P8.setText("Duration Time: ");
            P8.add(Dur_P8);

            //---- textField_P8 ----
            textField_P8.setPreferredSize(new Dimension(80, 24));
            P8.add(textField_P8);
        }
        contentPane.add(P8);

        //======== P9 ========
        {
            P9.setPreferredSize(new Dimension(451, 30));
            P9.setMinimumSize(new Dimension(478, 30));
            P9.setBorder(null);
            P9.setLayout(new FlowLayout(FlowLayout.LEFT));
            P9.add(checkBox_P9);

            //---- Place_P9 ----
            Place_P9.setPreferredSize(new Dimension(160, 24));
            Place_P9.setMinimumSize(new Dimension(120, 24));
            Place_P9.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P9.add(Place_P9);

            //---- Dur_P9 ----
            Dur_P9.setText("Duration Time: ");
            P9.add(Dur_P9);

            //---- textField_P9 ----
            textField_P9.setPreferredSize(new Dimension(80, 24));
            P9.add(textField_P9);
        }
        contentPane.add(P9);

        //======== P10 ========
        {
            P10.setPreferredSize(new Dimension(451, 30));
            P10.setMinimumSize(new Dimension(478, 30));
            P10.setBorder(null);
            P10.setLayout(new FlowLayout(FlowLayout.LEFT));
            P10.add(checkBox_P10);

            //---- Place_P10 ----
            Place_P10.setPreferredSize(new Dimension(160, 24));
            Place_P10.setMinimumSize(new Dimension(120, 24));
            Place_P10.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P10.add(Place_P10);

            //---- Dur_P10 ----
            Dur_P10.setText("Duration Time: ");
            P10.add(Dur_P10);

            //---- textField_P10 ----
            textField_P10.setPreferredSize(new Dimension(80, 24));
            P10.add(textField_P10);
        }
        contentPane.add(P10);

        //======== P11 ========
        {
            P11.setPreferredSize(new Dimension(451, 30));
            P11.setMinimumSize(new Dimension(478, 30));
            P11.setBorder(null);
            P11.setLayout(new FlowLayout(FlowLayout.LEFT));
            P11.add(checkBox_P11);

            //---- Place_P11 ----
            Place_P11.setPreferredSize(new Dimension(160, 24));
            Place_P11.setMinimumSize(new Dimension(120, 24));
            Place_P11.setModel(new DefaultComboBoxModel<>(new String[]{
                    "DormitaryOne",
                    "DomitaryTwo",
                    "TeachingOne",
                    "StudentService",
                    "NBathroom",
                    "Hospital",
                    "DomitaryTen",
                    "TeachingThreeNGate",
                    "TeachingThreeSGate",
                    "TeachingFour",
                    "ComputerBuilding",
                    "Jingguan",
                    "Library",
                    "Meishiyuan",
                    "Aoyun",
                    "Sbathroom",
                    "ArtBuilding",
                    "ScienceBuilding",
                    "RenwenBuildingW",
                    "RenwenBuildingE",
                    "ShixunBuilding",
                    "ChengjianBuilding",
                    "RuanjianBuilding"
            }));
            P11.add(Place_P11);

            //---- Dur_P11 ----
            Dur_P11.setText("Duration Time: ");
            P11.add(Dur_P11);

            //---- textField_P11 ----
            textField_P11.setPreferredSize(new Dimension(80, 24));
            P11.add(textField_P11);
        }
        contentPane.add(P11);
        setSize(420, 490);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - unknown
    public JPanel panel0;
    public JLabel label1;
    public JComboBox<String> hourSelect;
    public JLabel label2;
    public JComboBox<String> minuteSelect;
    public JButton buttonRun;
    public JButton buttonClr;
    public JPanel P1;
    public JCheckBox checkBox_P1;
    public JComboBox<String> Place_P1;
    public JLabel Dur_P1;
    public JTextField textField_P1;
    public JPanel P2;
    public JCheckBox checkBox_P2;
    public JComboBox<String> Place_P2;
    public JLabel Dur_P2;
    public JTextField textField_P2;
    public JPanel P3;
    public JCheckBox checkBox_P3;
    public JComboBox<String> Place_P3;
    public JLabel Dur_P3;
    public JTextField textField_P3;
    public JPanel P4;
    public JCheckBox checkBox_P4;
    public JComboBox<String> Place_P4;
    public JLabel Dur_P4;
    public JTextField textField_P4;
    public JPanel P5;
    public JCheckBox checkBox_P5;
    public JComboBox<String> Place_P5;
    public JLabel Dur_P5;
    public JTextField textField_P5;
    public JPanel P6;
    public JCheckBox checkBox_P6;
    public JComboBox<String> Place_P6;
    public JLabel Dur_P6;
    public JTextField textField_P6;
    public JPanel P7;
    public JCheckBox checkBox_P7;
    public JComboBox<String> Place_P7;
    public JLabel Dur_P7;
    public JTextField textField_P7;
    public JPanel P8;
    public JCheckBox checkBox_P8;
    public JComboBox<String> Place_P8;
    public JLabel Dur_P8;
    public JTextField textField_P8;
    public JPanel P9;
    public JCheckBox checkBox_P9;
    public JComboBox<String> Place_P9;
    public JLabel Dur_P9;
    public JTextField textField_P9;
    public JPanel P10;
    public JCheckBox checkBox_P10;
    public JComboBox<String> Place_P10;
    public JLabel Dur_P10;
    public JTextField textField_P10;
    public JPanel P11;
    public JCheckBox checkBox_P11;
    public JComboBox<String> Place_P11;
    public JLabel Dur_P11;
    public JTextField textField_P11;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
