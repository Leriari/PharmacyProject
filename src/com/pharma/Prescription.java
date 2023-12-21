package com.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prescription extends JFrame {
    private JLabel lblDrugName, lblDosage, lblQuantity, lblPatient;
    private JTextField txtDrugName, txtQuantity, txtPatient;
    private JButton btnPrescribe;
    private DatabaseConnection databaseConnection;

    public Prescription() {
        super("Prescription");
        setSize(300, 300);
        setResizable(false);
        setResizable(true);
        getContentPane().setBackground(Color.cyan);
        setLocationRelativeTo(null);

        // Initialize the JLabels
        lblDrugName = new JLabel("Drug Name");
        lblQuantity = new JLabel("Quantity    ");
        lblPatient = new JLabel("Patient       ");

        // Set the font for the JLabels to italic
        Font labelFont = new Font("Arial", Font.ITALIC, 14); // You can change the font name and size
        lblDrugName.setFont(labelFont);
        lblQuantity.setFont(labelFont);
        lblPatient.setFont(labelFont);

        // Set the foreground color for the JLabels
        lblQuantity.setForeground(Color.white);
        lblPatient.setForeground(Color.white);
        lblDrugName.setForeground(Color.white);

        // Initialize other components
        txtDrugName = new JTextField(10);

        txtQuantity = new JTextField(10);
        txtPatient = new JTextField(10);

        btnPrescribe = new JButton("Prescribe");

        btnPrescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Patient = txtPatient.getText();
                String Drug = txtDrugName.getText();

                String quantity = txtQuantity.getText();
                databaseConnection = new DatabaseConnection();
                if (databaseConnection.PrescribeDrugs(Patient,Drug,quantity)) {
                    JOptionPane.showMessageDialog(null, "Prescription added successfully!");
                    dispose(); // Close the PrescriptionGUI after the prescription is added
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to prescribe drug");
                }
            }
        });

        // Adding components to the JFrame
        setLayout(new FlowLayout());
        add(lblPatient);
        add(txtPatient);
        add(lblDrugName);
        add(txtDrugName);
        add(lblQuantity);
        add(txtQuantity);
        add(btnPrescribe);
        setVisible(true);
    }
}
