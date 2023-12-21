//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;


import jdk.jfr.Description;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PharmacistUI extends JFrame {
   private JLabel lblDrugName;
    private JLabel lblCopyright;
    private JTextField txtDrugName,txtQuantity;
    private JLabel lblDescription,lblQuantity,lblExpiryDate;
    private JTextField txtDescription;
    private JLabel lblDosage;
    private JTextField txtDosage,txtExpiryDate;
    private JButton btnRemoveExpired;
    private JLabel lblTitle;
    private JButton btnAddStock, btnSellDrug;
    public DatabaseConnection databaseConnection;

    public PharmacistUI() {
        setTitle("Pharma - Pharmacist");
        setSize(300, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout(FlowLayout.CENTER, 30, 8));

        lblTitle = new JLabel("Pharmacist Dashboard");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        lblCopyright = new JLabel("copyright  by tobiko leriari ");

        lblDescription = new JLabel("Description");
        lblDosage = new JLabel("Dosage    ");
        lblDrugName = new JLabel("Drug Name");
        lblQuantity= new JLabel("Quantity   ");
        lblExpiryDate =new JLabel("Expiry Date:");
        btnAddStock = new JButton("Add New Stock");
        txtDrugName = new JTextField(10);

        txtDescription = new JTextField(10);
        txtDosage = new JTextField(10);
        txtQuantity =new JTextField(10);
        txtExpiryDate = new JTextField(10);
        btnSellDrug=new JButton("Sell ");
        btnRemoveExpired = new JButton("Remove Expired Stock");
        getContentPane().setBackground(Color.CYAN);

        add(lblTitle);
        add(Box.createVerticalStrut(30));
        add(lblDrugName);
        add(txtDrugName);
        add(lblDescription);
        add(txtDescription);
        add(lblDosage);
        add(txtDosage);
        add(lblQuantity);
        add(txtQuantity);
        add(lblExpiryDate);
        add(txtExpiryDate);
        add(btnAddStock);
        add(btnRemoveExpired);
        add(btnSellDrug);
        add(lblCopyright);
        setVisible(true);

        btnAddStock.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drugName = txtDrugName.getText();
                String description = txtDescription.getText();
                String dosage = txtDosage.getText();
                String quantity = txtQuantity.getText();
                String expiry = txtExpiryDate.getText();
                databaseConnection = new DatabaseConnection();
                if (databaseConnection.addDrugs(drugName, dosage, description,quantity,expiry)) {
                    JOptionPane.showMessageDialog(null, "Drug added successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add drug");
                }
            }
        });

        btnRemoveExpired.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drugName = txtDrugName.getText();
                databaseConnection = new DatabaseConnection();
                if (databaseConnection.removeDrugs(drugName)) {
                    JOptionPane.showMessageDialog(null, "Drug is Successfully deleted");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to delete drug");
                }
            }
        });
        btnSellDrug.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String drugName = txtDrugName.getText();
                int quantity = Integer.parseInt(txtQuantity.getText());
                databaseConnection = new DatabaseConnection();
                if (databaseConnection.sellDrugs(drugName,quantity)) {
                    JOptionPane.showMessageDialog(null, "Drug is Successfully sold");
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to sell drug");
                }
            }
        });




    }

    public static void main(String[] args) {
        PharmacistUI obj =new PharmacistUI();
    }
}
