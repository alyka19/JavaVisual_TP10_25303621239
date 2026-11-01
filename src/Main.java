import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.view.MainWindow;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        // 1. Siapkan DATA terlebih dahulu (layer Model)
        CharacterManager manager = new CharacterManager();
        manager.addCharacter(new Character("Alyka", CharacterType.WARRIOR, 7)); // Lv.7 -> Emas & Bold
        manager.addCharacter(new Character("Ariana", CharacterType.MAGE, 3));    // Lv.3 -> Putih & Plain
        manager.addCharacter(new Character("V", CharacterType.ARCHER, 4));       // Lv.4 -> Putih & Plain
        manager.addCharacter(new Character("joko", CharacterType.HEALER, 5));    // Lv.5 -> Emas & Bold
        manager.addCharacter(new Character("bowo", CharacterType.ROGUE, 2));     // Lv.2 -> Putih & Plain
        manager.addCharacter(new Character("Gatotkaca", CharacterType.KNIGHT, 8));// Lv.8 -> Emas & Bold 

        // 2. Jalankan GUI dengan AMAN di Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager);
            window.setVisible(true); // WAJIB
        });
    }
}