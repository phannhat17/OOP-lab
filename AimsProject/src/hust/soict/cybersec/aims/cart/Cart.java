package hust.soict.cybersec.aims.cart;
import java.util.*;

import hust.soict.cybersec.aims.media.Media;

public class Cart {
    
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public int qtyOrdered = 0;

    // Add and remove media from cart
    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is almost full!");
        } else {
            itemsOrdered.add(media);
            System.out.println(media.getTitle() + " has been added!");
        }
    }
    public void removeMedia(Media media) {
        if (itemsOrdered.size() == 0) {
            System.out.println("Nothing to remove!");
        } else {
            if (itemsOrdered.remove(media)) {
                System.out.println(media.getTitle() + " has been removed from the cart.");
            } else {
                System.out.println("Media not found in cart!");
            }
        }
    }

    // Search by title, category, price (max cost/ min-max cost) and ID
    public void searchByTitle(String keyword) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(keyword)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found with \"" + keyword + "\" in the title!");
        }
    }

    public void searchByCategory(String category) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getCategory().equalsIgnoreCase(category)) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no media matching the \"" + category + "\" category were found!");
        }
    }

    public void searchByPrice(float maxCost) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found that match the maximum cost provided!");
        }
    }

    public void searchByPrice(float minCost, float maxCost) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.getCost() >= minCost && media.getCost() <= maxCost) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found that match the cost range between your specified minimum and maximum!");
        }
    }

    public void searchByID(int id) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Found " + media);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Sorry, no media were found that match the ID provided!");
        }
    }

    // Calculate total cost
    public float totalCost() {
        float totalCost = 0;
        for (Media media : itemsOrdered) {
            totalCost += media.getCost();
        }
        return totalCost;
    }

    // Print the cart
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i =0;
        for (Media media : itemsOrdered) {
            i +=1;
            System.out.println(i + ". " + media);
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

}
