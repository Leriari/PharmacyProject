//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
public class DoctorUI extends JFrame {
    private JTextField txtSearch;
    private JButton btnSearch,btnPrescribe;
    private JLabel lblTitle;
    private JLabel lblCopyright;

    private DatabaseConnection databaseConnection;

    public DoctorUI() {
        setTitle("Pharma - Doctor");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        lblTitle = new JLabel("Doctor's Prescription");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);


        txtSearch = new JTextField(20);
        btnSearch = new JButton("Search");
        btnPrescribe = new JButton("Prescribe");
        lblCopyright = new JLabel("copyright  by tobiko leriari ");

      setLayout(new FlowLayout());
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        add(lblTitle);
        add(new JLabel("\n"));
        add(new JLabel("Search for Drugs:"));
        add(txtSearch);
        add(btnSearch);
        add(btnPrescribe);
        add(lblCopyright);
        //panel.add(Box.createVerticalStrut(10));
       // panel.add(prescriptionTextField);
       // panel.add(new JLabel("Prescription:"));
        //panel.add(new JScrollPane(prescriptionTextArea));



        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = txtSearch.getText();
                        String searchQuery = txtSearch.getText();
                 databaseConnection= new DatabaseConnection();
                        List<String> searchResults = (List<String>) DatabaseConnection.searchDrugs(searchQuery);
                        JOptionPane.showMessageDialog(null, searchResults);

            }

        });
        btnPrescribe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Prescription prescription = new Prescription();
                prescription.setVisible(true);
            }
        });
        setVisible(true);


   }

    public static void main(String[] args) {
    DoctorUI obj =new DoctorUI();
    }
}
