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

public class InputView extends BaseView implements ActionListener {
    private final JLabel lblNama, lblNIM, lblTugas, lblQuiz, lblKelas, lblMatkul;
    private final JTextField txtNama, txtNIM, txtTugas, txtQuiz;
    private final JRadioButton rbTeori, rbPraktikum;
    private final JComboBox cbMataKuliah;
    private final JButton btnSubmit, btnLogout;
    private final ButtonGroup bgKelas;

    public InputView() {
        super("Halaman Input Nilai", 400, 650);
        setLayout(null);
        String[] daftarMatkul = {"PBO", "SCPK", "Algo Lanjut"};
        
        // Instansiasi Objek
        lblNama = new JLabel("Nama Mahasiswa:");
        txtNama = new JTextField();
        lblNIM = new JLabel("NIM:");
        txtNIM = new JTextField();
        lblTugas = new JLabel("Nilai Tugas:");
        txtTugas = new JTextField();
        lblQuiz = new JLabel("Nilai Quiz:");
        txtQuiz = new JTextField();
        lblKelas = new JLabel("Tipe Kelas:");
        rbTeori = new JRadioButton("Teori", true);
        rbPraktikum = new JRadioButton("Praktikum");
        bgKelas = new ButtonGroup();
        lblMatkul = new JLabel("Mata Kuliah:");
        cbMataKuliah = new JComboBox(daftarMatkul);
        btnSubmit = new JButton("Submit");
        btnLogout = new JButton("Logout");

        // Atur Design
        lblNama.setBounds(25, 10, 250, 30);
        txtNama.setBounds(25, 40, 250, 30);
        lblNIM.setBounds(25, 80, 250, 30);
        txtNIM.setBounds(25, 110, 250, 30);
        lblTugas.setBounds(25, 150, 250, 30);
        txtTugas.setBounds(25, 180, 250, 30);
        lblQuiz.setBounds(25, 220, 250, 30);
        txtQuiz.setBounds(25, 250, 250, 30);
        lblKelas.setBounds(25, 290, 250, 30);
        rbTeori.setBounds(25, 320, 100, 30);
        rbPraktikum.setBounds(130, 320, 100, 30);
        lblMatkul.setBounds(25, 360, 250, 30);
        cbMataKuliah.setBounds(25, 390, 250, 30);
        btnSubmit.setBounds(25, 430, 150, 30);
        btnLogout.setBounds(200, 430, 150, 30);
        
        // Tambahkan ke Layout
        add(lblNama);
        add(txtNama);
        add(lblNIM);
        add(txtNIM);
        add(lblTugas);
        add(txtTugas);
        add(lblQuiz);
        add(txtQuiz);
        add(lblKelas);
        add(rbTeori);
        add(rbPraktikum);
        add(lblMatkul);
        add(cbMataKuliah);
        add(btnSubmit);
        add(btnLogout);
        
        // Mengelompokkan RB menjadi satu
        bgKelas.add(rbTeori);
        bgKelas.add(rbPraktikum);
        
        // Add Event Listener
        btnSubmit.addActionListener(this);
        btnLogout.addActionListener(this);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            try {
                String nama = txtNama.getText();
                String nim = txtNIM.getText();
                
                if (nama.isBlank() || nim.isBlank()) {
                    throw new RuntimeException("Masih terdapat field yang kosong");
                }
                
                double tugas = Double.parseDouble(txtTugas.getText());
                double quiz = Double.parseDouble(txtQuiz.getText());
                String tipeKelas = rbTeori.isSelected() ? "Teori" : "Praktikum";
                String mataKuliah = cbMataKuliah.getSelectedItem().toString();
                

                // Instansiasi objek Mahasiswa
                Mahasiswa mahasiswa = new Mahasiswa(nama, nim, tugas, quiz, tipeKelas, mataKuliah);

                // Tampilkan hasil dalam pop-up
                JOptionPane.showMessageDialog(null,
                        "Nama: " + mahasiswa.getNama()
                        + "\nNIM: " + mahasiswa.getNim()
                        + "\nMata Kuliah: " + mahasiswa.getMataKuliah()
                        + "\nTotal Nilai: " + mahasiswa.getTotalNilai()
                        + "\nStatus: " + mahasiswa.getStatusKelulusan(),
                        "Hasil Akhir", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Harap masukkan nilai tugas dan quiz dalam format angka!", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (RuntimeException er) {
                JOptionPane.showMessageDialog(null, "Harap isi seluruh field!", "Missing Field", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnLogout) {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin logout?", "Konfirmasi Logout", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                dispose();
                new LoginView();
            }
        }
    }
}
