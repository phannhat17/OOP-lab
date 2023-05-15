package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

    @Override
    public int compare(Media o1, Media o2) {
        // Compare by cost
        int costComparison = Double.compare(o2.getCost(), o1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // Compare by title
        return o1.getTitle().compareTo(o2.getTitle());        
    }
}
