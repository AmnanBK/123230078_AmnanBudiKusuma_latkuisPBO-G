/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latkuispbo;

/**
 *
 * @author amnan
 */
public class Mahasiswa {
    final private String nama;
    final private String nim;
    final private double nilaiTugas;
    final private double nilaiQuiz;
    final private String tipeKelas;
    final private String mataKuliah;
    
    public Mahasiswa(String nama, String nim, double nilaiTugas, double nilaiQuiz, String tipeKelas, String mataKuliah) {
        this.nama = nama;
        this.nim = nim;
        this.nilaiTugas = nilaiTugas;
        this.nilaiQuiz = nilaiQuiz;
        this.tipeKelas = tipeKelas;
        this.mataKuliah = mataKuliah;
    }

    public double getTotalNilai() {
        if (tipeKelas.equals("Teori")) {
            return (0.3 * nilaiTugas) + (0.7 * nilaiQuiz);
        } else {
            return (0.7 * nilaiTugas) + (0.3 * nilaiQuiz);
        }
    }

    public String getStatusKelulusan() {
        return getTotalNilai() <= 85 ? "NOT PASS" : "PASS";
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getMataKuliah() { return mataKuliah; }
}
