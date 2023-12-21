//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PatientUI extends JFrame {
    private JLabel lblTitle;
    private JTextField prescriptionTextField;
    private JButton btnBuy;

    public PatientUI() {
        setTitle("Pharma - Patient");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        lblTitle = new JLabel("Patient's Dashboard");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        prescriptionTextField = new JTextField();

        prescriptionTextField.setMargin(new Insets(5, 2, 5, 2));
        prescriptionTextField.setSize(20,10);

        btnBuy = new JButton("Buy Prescribed Drugs");
        getContentPane().setBackground(Color.CYAN);

        panel.add(lblTitle);
        panel.add(Box.createVerticalStrut(8));
        panel.add(new JLabel("Prescription:"));
        panel.add(new JScrollPane(prescriptionTextField));
        panel.add(Box.createVerticalStrut(8));
        panel.add(btnBuy);
        setLocationRelativeTo(null);

        add(panel);

        btnBuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PatientUI patientUI = new PatientUI();
                patientUI.setVisible(true);
            }
        });
    }
}

