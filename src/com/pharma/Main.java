//Leriari Peter Tobiko, ICS B, 166913
package com.pharma;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(150,600);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LandingPage landingPage = new LandingPage();

            }
        });
    }
}

