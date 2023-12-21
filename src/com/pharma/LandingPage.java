//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LandingPage extends JFrame{
    private JLabel lblUserSelection;
    private JButton btnPharmacist;
    private JLabel lblCopyright;
    private JButton btnDoctor;
    private JButton btnPatient;
    private JPanel SelectUser;

    public LandingPage(){
        super ( "Select user");
        setSize(300,300);
        setLocationRelativeTo(null);
        ImageIcon imageIcon = new ImageIcon("\"C:\\Users\\pc\\Downloads\\pharm 2.0.jpg\"");
        JLabel lblImage = new JLabel(imageIcon);
        Insets imagePadding = new Insets(10, 50, 20, 50);
        add(lblImage, BorderLayout.NORTH);
        lblUserSelection = new JLabel("Select User");
        btnDoctor=new JButton("Doctor");
        btnPatient=new JButton("Patient");
        btnPharmacist=new JButton("Pharmacist");
        lblCopyright = new JLabel("copyright  by tobiko leriari ");
        getContentPane().setBackground(Color.CYAN);
        setLayout(new FlowLayout());
        add(lblUserSelection);
        add(btnDoctor);
        add (lblImage);
       // add(btnPatient);
        add(btnPharmacist);
        add(lblCopyright);



        btnPharmacist.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI loginUI= new LoginUI();
                loginUI.setVisible(true);
            }
        });
        btnDoctor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginUI loginUI= new LoginUI();
                loginUI.setVisible(true);
            }
        });

        btnPatient.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PatientUI patientUI=new PatientUI();
                //patientUI.setVisible(true);
            }
        });
        setVisible(true);
    }
}
