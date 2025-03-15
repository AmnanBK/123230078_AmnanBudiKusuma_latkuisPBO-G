/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuispbo;

/**
 *
 * @author amnan
 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends BaseView implements ActionListener {
    final private JLabel lblUsername, lblPassword;
    final private JTextField txtUsername;
    final private JPasswordField txtPassword;
    final private JButton btnLogin;

    public LoginView() {
        super("Halaman Login", 325, 250);
        setLayout(null);
        
        // Instansiasi Objek
        lblUsername = new JLabel("Username");
        txtUsername = new JTextField();
        lblPassword = new JLabel("Password");
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        
        // Atur Design
        lblUsername.setBounds(25, 10, 250, 30);
        txtUsername.setBounds(25, 40, 250, 30);
        lblPassword.setBounds(25, 80, 250, 30);
        txtPassword.setBounds(25, 110, 250, 30);
        btnLogin.setBounds(75, 150, 150, 30);
        
        // Tambahkan ke Layout
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(txtPassword);
        add(btnLogin);
        
        // Add Event ke Button
        btnLogin.addActionListener(this);

        setVisible(true);
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());
            
            if (username.equals("123230078") && password.equals("ifkelasg")) {
                JOptionPane.showMessageDialog(null, "Login Berhasil!");
                dispose();
                new InputView();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
        }
    }
}
