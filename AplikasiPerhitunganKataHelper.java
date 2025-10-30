package Tugas5;

import java.io.File;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * Class ini berisi logika pemrosesan teks untuk AplikasiPerhitunganKata.
 * Semua logika perhitungan, pencarian, dan penyimpanan file dipisahkan dari JFrame utama.
 * 
 * @author ACER
 */
public class AplikasiPerhitunganKataHelper {

    // 🔹 Menghitung jumlah kata, karakter, kalimat, dan paragraf
    public static int hitungKata(String teks) {
        return teks.trim().isEmpty() ? 0 : teks.trim().split("\\s+").length;
    }

    public static int hitungKarakter(String teks) {
        return teks.length();
    }

    public static int hitungKalimat(String teks) {
        if (teks.trim().isEmpty()) return 0;
        return teks.split("[.!?]+").length;
    }

    public static int hitungParagraf(String teks) {
        if (teks.trim().isEmpty()) return 0;
        return teks.split("\\n+").length;
    }

    // 🔹 Menyimpan teks ke file menggunakan JFileChooser
    public static void simpanTeksKeFile(String teks) {
        try {
            if (teks.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Tidak ada teks untuk disimpan!");
                return;
            }

            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                FileWriter writer = new FileWriter(file + ".txt");
                writer.write(teks);
                writer.close();
                JOptionPane.showMessageDialog(null, "Teks berhasil disimpan ke file!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan file: " + e.getMessage());
        }
    }

    // 🔹 Mencari kata dalam teks (mengembalikan indeks ditemukan atau -1)
    public static int cariKata(String teks, String cari) {
        if (teks.isEmpty() || cari.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Isi teks dan kata yang ingin dicari terlebih dahulu!");
            return -1;
        }

        int index = teks.toLowerCase().indexOf(cari.toLowerCase());
        if (index != -1) {
            JOptionPane.showMessageDialog(null, "Kata \"" + cari + "\" ditemukan!");
        } else {
            JOptionPane.showMessageDialog(null, "Kata \"" + cari + "\" tidak ditemukan!");
        }
        return index;
    }
}
