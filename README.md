## TP10 

### Screenshot Perbandingan
1. Sebelum (v0.3 - Tampilan Standar) : [v0.3 Screenshot](Screenshot 2026-10-30 215821.png)
2. Sesudah (v0.4 - AppTheme Integrated) : [v0.4 Screenshot](Screenshot 2026-10-31 234140.png)

### Alur MVC & Pengaturan Warna
Warna dan aturan styling diletakkan di `AppTheme` (layer View) dan bukan di `Character` (layer Model) untuk menjaga prinsip **Separation of Concerns**. Layer Model berfokus murni pada logika bisnis serta state data karakter (seperti HP, level, dan role), sehingga bebas dari ketergantungan library GUI (`java.awt.Color`). Dengan memisahkan visual ke `AppTheme`, perubahan tema tampilan aplikasi dapat dilakukan secara terpusat tanpa risiko merusak atau memodifikasi kode logika internal pada Model.

### Properti Tambahan Swing
1. **`setToolTipText`**: Menampilkan tooltip interaktif yang berisi deskripsi singkat mengenai role karakter saat kursor pengguna berada di atas kartu.
2. **`setCursor(Cursor.HAND_CURSOR)`**: Memberikan umpan balik visual (*visual feedback*) dengan mengubah ikon kursor mouse menjadi tangan ketika melintasi kartu karakter, menandakan bahwa komponen tersebut dapat diinteraksi.

### Dokumen Analisis
Google Docs : https://docs.google.com/document/d/1gGZty9ubI2WGuO2L_JT3AaJRvMwVZAt8jWJRR5yaXbI/edit?usp=sharing