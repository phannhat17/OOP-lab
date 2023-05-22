package hust.soict.cybersec.aims.screen;

import javax.swing.JFrame;
import hust.soict.cybersec.aims.screen.controller.AddCDScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.cybersec.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame{

    private static Store store;
    
    public static void main(String[] args) {
		new AddCompactDiscToStoreScreen(store);
	}

    public AddCompactDiscToStoreScreen(Store store) {

        super();

        AddCompactDiscToStoreScreen.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add DVD");
        this.setSize(1024, 768);
        this.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/view/addCD.fxml"));
                    
                    AddCDScreenController controller = new AddCDScreenController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    
}
