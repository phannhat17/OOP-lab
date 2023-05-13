package hust.soict.cybersec.lab01;
import javax.swing.JOptionPane;

public class ChoosingOption {
    public static void main(String[] args) {
        
        int option = JOptionPane.showConfirmDialog(null, "Do you want to change the first class ticket?");
        JOptionPane.showMessageDialog(null, "You've choosen: " + (option == JOptionPane.YES_OPTION? "Yes" : "No"));
        System.exit(0);
    }
}
