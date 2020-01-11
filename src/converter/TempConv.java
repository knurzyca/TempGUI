package converter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TempConv extends JFrame {

    private JTextField FahrenDeg;
    private JTextField textFieldCL;
    private JButton CelsToFahren;

    TempConv() {
        super ("Temperature Converter");
        setLayout (new FlowLayout ());
        FahrenDeg = new JTextField (10);
        add (FahrenDeg);
        JLabel labelCels = new JLabel("Celsius:  ", SwingConstants.RIGHT);
        labelCels.setToolTipText("Convert Temperature");
        add (labelCels);
        JLabel labelFh = new JLabel("Fehrenheit:  ", SwingConstants.RIGHT);
        add(labelFh);
        textFieldCL = new JTextField (10);
        add (textFieldCL);
        CelsToFahren = new JButton ("CONVERT");
        add (CelsToFahren);
        JPanel panel = new JPanel(new GridLayout(2, 2, 12, 6));
        panel.add(labelCels);
        panel.add(textFieldCL);
        panel.add(labelFh);
        panel.add(FahrenDeg);
        add(panel, BorderLayout.NORTH);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(CelsToFahren);
        add(buttonPanel, BorderLayout.SOUTH);
        CelsToFahren.addActionListener(new CelsListener ());
    }

    private class CelsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if (event.getSource() == CelsToFahren){
                int conCelToFah = (int) (( 1.8 * (((Double.parseDouble(textFieldCL.getText())))))) + 32;
                FahrenDeg.setText(conCelToFah + " °F");
                textFieldCL.requestFocus();
                textFieldCL.selectAll();
            }
        }
    }
}