//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class LoginUI extends JFrame {
        private JLabel lblUser, lblPass;
        private JTextField txtUser;
        private JLabel lblCopyright;
        private JPasswordField txtPass;
        private JButton btnLogin;
        private DatabaseConnection databaseConnection;

        public LoginUI() {
            super("Sign in Page");
            setLayout(new FlowLayout());
            setSize(300,300);
            setLocationRelativeTo(null);
            lblUser = new JLabel("Username:");
            lblPass = new JLabel("Password:");
            txtUser = new JTextField(15);
            txtPass = new JPasswordField(15);
            btnLogin = new JButton("Login");
            lblCopyright = new JLabel("copyright  by tobiko leriari ");
            getContentPane().setBackground(Color.CYAN);
            add(lblUser);
            add(txtUser);
            add(lblPass);
            add(txtPass);
            add(btnLogin);
            add(lblCopyright,BorderLayout.SOUTH);
            btnLogin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = txtUser.getText();
                    char[] password = txtPass.getPassword();
                    databaseConnection = new DatabaseConnection();
                    if (databaseConnection.validateUsername(username, new String(password))) {
                        if (databaseConnection.isDoctor(username)) {
                            new DoctorUI();
                        } else if (databaseConnection.isPharmacist(username)) {
                            new PharmacistUI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    }
                }
            });
            setVisible(true);
        }
    }
