package hust.soict.cybersec.aims;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.DigitalVideoDisc;

public class Aims {
 
    public static void main(String[] args) {
     
        Cart anOder = new Cart();
        
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f); 
        anOder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 25.95f); 
        anOder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        anOder.addMedia(dvd3);

        System.out.println("Total cost is: ");
        System.out.println(anOder.totalCost());

    }

}
