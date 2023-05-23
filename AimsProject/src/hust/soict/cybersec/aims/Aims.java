package hust.soict.cybersec.aims;
import hust.soict.cybersec.aims.cart.Cart;
import hust.soict.cybersec.aims.media.*;
import hust.soict.cybersec.aims.store.Store;
import java.util.*;

import javax.naming.LimitExceededException;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        
        // Init add media to the store
        initSetup();

        boolean exit = false;
        // CLI
        while (!exit) {
            
            showMenu();

            Scanner scanner = new Scanner(System.in);
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 0:
                    exit = true;
                    System.out.println("Good bye!");
                    break;
                case 1:
                    clearConsole();
                    storeMenu(scanner);
                    break;
                case 2:
                    clearConsole();
                    updateStoreMenu(scanner);
                    break;
                case 3:
                    clearConsole();
                    cartMenu(scanner);
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                    break;
            }

        }

    }
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
    // init store setup 
    public static void initSetup() {

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);     
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War", "Science Fiction", "George Lucas", 87, 24.95f); 
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

    
        Book book = new Book("The Valley of Fear", "Detective", 20.00f);
        Book book1 = new Book("A Living Remedy: A Memoir", "Biography", 202.00f);
        Book book2 = new Book("On the Origin of Time: Stephen Hawking's Final Theory", "Science", 120.00f);
        store.addMedia(book);
        store.addMedia(book1);
        store.addMedia(book2);


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

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        
        clearConsole();
    }
    
    // Print method
    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            store.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    boolean foundDetails = false;
                    while (!foundDetails) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            clearConsole();
                            System.out.println("Details: ");
                            System.out.println(media);
                            mediaDetailsMenu(scanner, media);
                            foundDetails = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                    break;
                case 2:
                    boolean foundToAdd = false;
                    while (!foundToAdd) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            try {
                                cart.addMedia(media);
                            } catch (LimitExceededException e) {
                                e.printStackTrace();
                            }
                            foundToAdd = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                    break;
                case 3:
                    boolean foundToPlay = false;
                    while (!foundToPlay) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("This type of media is not supported!");
                            }
                            foundToPlay = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                    break;
                case 4:
                    clearConsole(); 
                    cartMenu(scanner);
                    break;    
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    public static void mediaDetailsMenu(Scanner scanner, Media media) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole(); 
                    back = true;
                    break;
                case 1:
                    try {
                        cart.addMedia(media);
                    } catch (LimitExceededException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    if (media instanceof Disc || media instanceof CompactDisc) {
                        media.play();
                    } else {
                        System.out.println("This type of media is not supported!");
                    }
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    public static void cartMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            cart.print();
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
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole(); 
                    back = true;
                    break;
                case 1:
                    System.out.println("Filter medias in cart by (1) id or (2) title:");
                    int filterOption = scanner.nextInt();
                    scanner.nextLine();
                    boolean found = false;
                    while (!found) {
                        if (filterOption == 1) {
                            System.out.println("Enter the id to filter (type 0 to stop):");
                            int id = scanner.nextInt();
                            scanner.nextLine();
                            if (id == 0) {
                                clearConsole();
                                break;
                            }
                            cart.searchByID(id);
                            found = true;
                        } else if (filterOption == 2) {
                            System.out.println("Enter the title to filter (type 0 to stop):");
                            String title = scanner.nextLine();
                            if (title.equals("0")) {
                                clearConsole();
                                break;
                            }
                            cart.searchByTitle(title);
                            found = true;
                        } else if (filterOption == 0) {
                            clearConsole();
                            break;
                        } else {
                            System.out.println("Invalid option.");
                        }
                    }
                    break;
                case 2:
                    System.out.println("Sort medias in cart by (1) title or (2) cost:");
                    int sortOption = scanner.nextInt();
                    scanner.nextLine();
                    if (sortOption == 1) {
                        cart.sortMediaByTitle();
                    } else if (sortOption == 2) {
                        cart.sortMediaByCost();
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 3:
                    boolean foundToRemove = false;
                    while (!foundToRemove) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = cart.searchToRemove(title);
                        if (media != null) {
                            clearConsole();
                            cart.removeMedia(media);
                            foundToRemove = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    } 
                    break;
                case 4:
                    boolean foundToPlay = false;
                    while (!foundToPlay) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String title = scanner.nextLine();
                        if (title.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(title);
                        if (media != null) {
                            if (media instanceof Disc || media instanceof CompactDisc) {
                                media.play();
                            } else {
                                System.out.println("This type of media is not supported!");
                            }
                            foundToPlay = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                    break; 
                case 5:
                    clearConsole();
                    cart.empty();
                    break;
                default:
                    clearConsole(); 
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
    public static void updateStoreMenu(Scanner scanner) {
        boolean back = false;
        while (!back) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add a media");
            System.out.println("2. Remove a media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    clearConsole();
                    back = true;
                    break;
                case 1:
                    System.out.println("Enter the category of the media (1) Book, (2) CD, (3) DVD or (0) exit:");
                    int categoryChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (categoryChoice == 1) {
                        System.out.println("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        System.out.println("Enter book category: ");
                        String bookCategory = scanner.nextLine();
                        System.out.println("Enter book cost: ");
                        Float bookCost = scanner.nextFloat();
                        scanner.nextLine();

                        Book newBook = new Book(bookTitle, bookCategory, bookCost);
                        store.addMedia(newBook);
                    } else if (categoryChoice == 2) {
                        System.out.println("Enter CD title: ");
                        String cdTitle = scanner.nextLine();
                        System.out.println("Enter CD category: ");
                        String cdCategory = scanner.nextLine();
                        System.out.println("Enter CD artist: ");
                        String cdArtist = scanner.nextLine();
                        System.out.println("Enter CD cost: ");
                        Float cdCost = scanner.nextFloat();
                        scanner.nextLine();

                        CompactDisc newCD = new CompactDisc(cdTitle, cdCategory, cdArtist, cdCost);

                        
                        System.out.println("Do you want to add tracks to your CD? (1) Yes (0) No:");
                        int addTrack = scanner.nextInt();
                        scanner.nextLine();
                        
                        if (addTrack == 1) {
                            System.out.println("How many tracks in your CD?");
                            int numTrack = scanner.nextInt();
                            scanner.nextLine();
                            for (int i = 0; i < numTrack; i++) {
                                System.out.println("Your " + (i+1) + " track: ");
                                System.out.println("Enter track title: ");
                                String trackTitle = scanner.nextLine();
                                System.out.println("Enter track length: ");
                                int trackLength = scanner.nextInt();
                                scanner.nextLine();

                                Track newTrack = new Track(trackTitle, trackLength);
                                newCD.addTrack(newTrack);
                            }
                            store.addMedia(newCD);
                        } else if (addTrack == 0) {
                            store.addMedia(newCD);
                        }
                    } else if (categoryChoice == 3) {
                        System.out.println("Enter DVD title: ");
                        String dvdTitle = scanner.nextLine();
                        System.out.println("Enter DVD category: ");
                        String dvdCategory = scanner.nextLine();
                        System.out.println("Enter book cost: ");
                        Float dvdCost = scanner.nextFloat();
                        scanner.nextLine();
                        
                        DigitalVideoDisc newDVD = new DigitalVideoDisc(dvdTitle, dvdCategory, dvdCost);
                        store.addMedia(newDVD);                
                    } else if (categoryChoice == 0) {
                        clearConsole();
                        break;
                    } else {
                        System.out.println("Invalid option.");
                    }
                    break;
                case 2:
                    boolean foundToRemove = false;
                    while (!foundToRemove) {
                        System.out.println("Enter the title of the media (type 0 to stop): ");
                        String titleForRemove = scanner.nextLine();
                        if (titleForRemove.equals("0")) {
                            clearConsole();
                            break;
                        }
                        Media media = store.search(titleForRemove);
                        if (media != null) {
                            clearConsole();
                            store.removeMedia(media);
                            foundToRemove = true;
                        } else {
                            System.out.println("***MEDIA NOT FOUND***");
                        }
                    }
                    break;
                default:
                    clearConsole();
                    System.out.println("Invalid option, please choose again.");
                    break;
            }
        }
    }
}
        