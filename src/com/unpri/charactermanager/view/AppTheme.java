package com.unpri.charactermanager.view;

import java.awt.Color;                       // kelas warna AWT
import java.awt.Font;                        // kelas font AWT
import javax.swing.BorderFactory;            // pabrik border
import javax.swing.border.Border;            // tipe objek border
import com.unpri.charactermanager.model.CharacterType; // enum dari Model (View boleh membaca Model)

/**
 * Pusat gaya tampilan Character Manager.
 * Mengubah tema aplikasi cukup dengan mengedit file ini.
 */
public final class AppTheme {

    // ---------- Palet warna ----------
    public static final Color BG_MAIN    = Color.decode("#13131f"); // latar jendela: hampir hitam
    public static final Color TEXT_MAIN  = Color.decode("#dfe6e9"); // teks utama: abu terang
    public static final Color TEXT_LIGHT = Color.WHITE;             // teks di atas kartu berwarna
    public static final Color GOLD       = Color.decode("#fdcb6e"); // aksen untuk karakter level tinggi

    // ---------- Font ----------
    public static final Font FONT_TITLE = new Font("SansSerif", Font.BOLD, 22);   // judul layar
    public static final Font FONT_BODY  = new Font("SansSerif", Font.PLAIN, 14);  // isi kartu
    public static final Font FONT_MONO  = new Font("Monospaced", Font.PLAIN, 13); // angka sejajar

    // ---------- Border ----------
    // Border bersifat immutable, jadi aman dipakai ulang oleh banyak komponen.
    public static final Border CARD_BORDER =
            BorderFactory.createEmptyBorder(8, 12, 8, 12); // atas, kiri, bawah, kanan

    private AppTheme() { }  // class utilitas: konstruktor private mencegah new AppTheme()

    /** Menerjemahkan role (data Model) menjadi warna kartu (urusan View). */
    public static Color colorFor(CharacterType type) {
    if (type == null) {
        return Color.GRAY;
    }
    switch (type) {
        case WARRIOR: return Color.decode("#d63031"); // merah
        case MAGE:    return Color.decode("#0984e3"); // biru
        case ARCHER:  return Color.decode("#00b894"); // hijau
        case HEALER:  return Color.decode("#e84393"); // merah muda / magenta untuk HEALER
        case ROGUE:   return Color.decode("#110380"); // navy 
        case KNIGHT:  return Color.decode("#6d4c09"); // coklat tua
        default:      return Color.GRAY;              // 👈 Tambahkan baris ini di sini
    }
}

    /** Teks tooltip per role. */
    public static String describe(CharacterType type) {
        if (type == null) {
            return "Role belum terdaftar";
        }
        switch (type) {
            case WARRIOR: return "Warrior: jarak dekat, HP tinggi";
            case MAGE:    return "Mage: serangan sihir, HP rendah";
            case ARCHER:  return "Archer: jarak jauh, seimbang";
            case HEALER:  return "Healer: pendukung, pemulih HP";
            case ROGUE:   return "Rogue: jarak dekat, kritikal tinggi";
            case KNIGHT:  return "Knight: jarak dekat, pertahanan tinggi";
            default:      return "Role belum terdaftar";
        }
    }
}