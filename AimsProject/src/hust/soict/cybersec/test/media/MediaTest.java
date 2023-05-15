package hust.soict.cybersec.test.media;

import java.util.*;

import hust.soict.cybersec.aims.media.*;

public class MediaTest {
    
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        Book book = new Book("The Valley of Fear", "Detective", 20.00f);


        CompactDisc cd = new CompactDisc("Adele - 30", "Music","Adele", 1500.98f);
        Track track1 = new Track("All Night Parking (interlude)", 161);
        Track track2 = new Track("To Be Loved", 403);
        Track track3 = new Track("Woman Like Me", 300);

        cd.addTrack(track1);
        cd.addTrack(track2);
        cd.addTrack(track3);

        mediae.add(cd);
        mediae.add(book);
        mediae.add(dvd);    

        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
    
}
