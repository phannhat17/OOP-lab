package hust.soict.cybersec.aims.store;
import java.util.ArrayList;

import hust.soict.cybersec.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}


    // Add and remove media from the store
    public void addMedia(Media media) {
        if (itemsInStore.contains(media)) {
            System.out.println("The media " + media.getTitle() + " is already in the store!");
        } else {
            itemsInStore.add(media);
            System.out.println("The media " + media.getTitle() + " has been added to the store.");
        }
    }
    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media " + media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println("The media " + media.getTitle() + " is not in the store!");
        }
    }

    // Print the store
    public void print() {
        if (itemsInStore.size() == 0) {
            System.out.println("The store is empty!");
        } else {
            System.out.println("********************STORE INVENTORY********************");
            for (Media media : itemsInStore) {
                System.out.println(media);
            }
            System.out.println("********************************************************");
        }
    }

    public Media search(String title) {
		for (Media media : itemsInStore) {
			if (media.getTitle().equals(title)) {
				return media;
			}
		}
		return null;
	}
}