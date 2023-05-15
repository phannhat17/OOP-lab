package hust.soict.cybersec.aims;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;
import java.util.*;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {

        // Init add media to the store
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Flash", "Action", 18.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Insidious", "Horror", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        

        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        Book book3 = new Book("Looking Glass Sound", "Horror", 1.00f);
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);


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
        Track track3CD3 = new Track("Mark My Words", 2*60+14);
        cd3.addTrack(track1CD3);
        cd3.addTrack(track2CD3);
        cd3.addTrack(track3CD3);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);

        showMenu();
    }
    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                store.print();
                storeMenu();
                break;
            case 2:
                System.out.println("In progress");
                break;
            case 3:
                cart.print();
                cartMenu();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        scanner.close();

    }
    public static void storeMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                store.print();
                storeMenu();
                break;
            case 2:
                System.out.println("In progress");
                break;
            case 3:
                cart.print();
                cartMenu();
                break;
            case 0:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
        scanner.close();
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
