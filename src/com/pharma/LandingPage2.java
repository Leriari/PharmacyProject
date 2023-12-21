package com.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class LandingPage2 extends JFrame {
        private JLabel lblUserSelection;
        private JButton btnPharmacist;
        private JButton btnDoctor;
        private JButton btnPatient;
        private JLabel lblCopyright;

        public LandingPage2() {
            super("Select user");
            setSize(400, 400);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            initUI();
            initActions();

            setVisible(true);
        }

        private void initUI() {
            ImageIcon imageIcon = new ImageIcon("C:\\Users\\pc\\Downloads\\pharm 2.0.jpg");
            JLabel lblImage = new JLabel(imageIcon);

            lblUserSelection = new JLabel("Select User");
            btnDoctor = new JButton("Doctor");
            btnPatient = new JButton("Patient");
            btnPharmacist = new JButton("Pharmacist");
            lblCopyright = new JLabel("Copyright by Tobiko Leriari");

            getContentPane().setBackground(Color.CYAN);
            setLayout(new BorderLayout());

            add(lblImage, BorderLayout.NORTH);

            JPanel buttonPanel = new JPanel(new FlowLayout());
            buttonPanel.add(lblUserSelection);
            buttonPanel.add(btnDoctor);
            buttonPanel.add(btnPharmacist);
            buttonPanel.add(btnPatient);

            add(buttonPanel, BorderLayout.CENTER);
            add(lblCopyright, BorderLayout.SOUTH);
        }

        private void initActions() {
            btnPharmacist.addActionListener(e -> openLoginUI());
            btnDoctor.addActionListener(e -> openLoginUI());
            btnPatient.addActionListener(e -> openPatientUI());
        }

        private void openLoginUI() {
            LoginUI loginUI = new LoginUI();
            loginUI.setVisible(true);
        }

        private void openPatientUI() {
            // Uncomment the following line when PatientUI is implemented
            // PatientUI patientUI = new PatientUI();
            // patientUI.setVisible(true);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> new LandingPage2());
        }
    }


