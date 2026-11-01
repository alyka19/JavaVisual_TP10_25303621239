package com.unpri.charactermanager.view;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;

public class MainWindow extends JFrame {

    // Batas level tinggi untuk Mini-Challenge
    private static final int HIGH_LEVEL_THRESHOLD = 5;

    private JPanel mainPanel;                      // container utama
    private ArrayList<Character> characterList;    // data dari Model

    // Konstruktor menerima CharacterManager
    public MainWindow(CharacterManager manager) {
        this(manager.getAllCharacters());
    }

    // Konstruktor menerima ArrayList<Character>
    public MainWindow(ArrayList<Character> characterList) {
        super("Character Manager v0.4");           // versi naik: sprint #4
        this.characterList = characterList;

        initComponents();                          // 1. susun semua komponen dulu

        pack();                                    // 2. ukuran jendela mengikuti isi
        setMinimumSize(new Dimension(420, 300));   // 3. cegah jendela terlalu kecil
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);               // 4. pusatkan SETELAH pack()
    }

    private void initComponents() {
        // GridLayout(0, 1, 0, 8): berapa pun baris, 1 kolom, jarak vertikal 8 px.
        mainPanel = new JPanel(new GridLayout(0, 1, 0, 8));
        mainPanel.setBackground(AppTheme.BG_MAIN);                           // warna latar panel
        mainPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16)); // padding luar

        mainPanel.add(createTitleLabel());          // judul di atas

        for (Character c : characterList) {          // satu kartu per karakter
            mainPanel.add(createCharacterLabel(c));
        }

        add(mainPanel);                             // pasang panel ke JFrame
    }

    /** Membuat judul layar. */
    private JLabel createTitleLabel() {
        JLabel lbl = new JLabel("Daftar Karakter (" + characterList.size() + ")",
                                SwingConstants.CENTER);   // teks di tengah label
        lbl.setFont(AppTheme.FONT_TITLE);                 // font judul dari tema
        lbl.setForeground(AppTheme.TEXT_MAIN);            // warna teks judul
        return lbl;
    }

    /** Membuat satu kartu karakter (JLabel berwarna sesuai role). */
    private JLabel createCharacterLabel(Character c) {
        String info = c.getName() + " | " + c.getType()
                    + " | Lv." + c.getLevel()
                    + " | HP:" + c.getHitPoints()
                    + " | ATK:" + c.getAttackPower()
                    + " | Mana:" + c.getMana();            // membaca atribut dari getter

        JLabel lbl = new JLabel(info);
        lbl.setBackground(AppTheme.colorFor(c.getType()));        // warna latar dari role
        lbl.setOpaque(true);                                      // WAJIB agar background tampak
        lbl.setBorder(AppTheme.CARD_BORDER);                      // padding kartu
        lbl.setToolTipText(AppTheme.describe(c.getType()));       // bantuan saat hover
        lbl.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)); // kursor tangan

        // =========================================================================
        // MINI-CHALLENGE IMPLEMENTATION:
        // Jika level >= HIGH_LEVEL_THRESHOLD (5), teks berwarna emas (GOLD) & BOLD.
        // Jika level < 5, teks berwarna putih (TEXT_LIGHT) & PLAIN.
        // =========================================================================
        if (c.getLevel() >= HIGH_LEVEL_THRESHOLD) {
            lbl.setForeground(AppTheme.GOLD);
            lbl.setFont(AppTheme.FONT_BODY.deriveFont(Font.BOLD));
        } else {
            lbl.setForeground(AppTheme.TEXT_LIGHT);
            lbl.setFont(AppTheme.FONT_BODY);
        }

        return lbl;
    }
}