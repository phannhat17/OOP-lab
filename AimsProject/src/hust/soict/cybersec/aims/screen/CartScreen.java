package hust.soict.cybersec.aims.screen;

import javax.swing.JFrame;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.screen.controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.cybersec.aims.cart.Cart;



public class CartScreen extends JFrame {

    private static Cart cart = new Cart();

    public static void initSetup() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

    
        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        cart.addMedia(book);
        cart.addMedia(book1);
        cart.addMedia(book2);


        CompactDisc cd1 = new CompactDisc("Adele - 30", "Music","Adele", 1500.98f);
        Track track1CD1 = new Track("All Night Parking (interlude)", 161);
        Track track2CD1 = new Track("To Be Loved", 403);
        Track track3CD1 = new Track("Woman Like Me", 300);
        cd1.addTrack(track1CD1);
        cd1.addTrack(track2CD1);
        cd1.addTrack(track3CD1);

        CompactDisc cd2 = new CompactDisc("The Gods We Can Touch", "Music","Aurora", 2000.22f);
        Track track1CD2 = new Track("Everything Matters", 180+34);
        Track track2CD2 = new Track("Blood in the Wine", 180+30);
        Track track3CD2 = new Track("Artemis", 60*2+39);
        cd2.addTrack(track1CD2);
        cd2.addTrack(track2CD2);
        cd2.addTrack(track3CD2);

        CompactDisc cd3 = new CompactDisc("Purpose", "Music","Justin Bieber", 1000.98f);
        Track track1CD3 = new Track("The Feeling", 4*60+5);
        Track track2CD3 = new Track("No Sense", 4*60+35);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);

        cart.addMedia(cd1);
        cart.addMedia(cd2);
        cart.addMedia(cd3);
        

    }
    
    public static void main(String[] args) {
        initSetup();
		new CartScreen(cart);
	}

    public CartScreen(Cart cart) {

        super();

        CartScreen.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/cybersec/aims/screen/view/cart.fxml"));
                    
                    CartScreenController controller = new CartScreenController(cart);
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
