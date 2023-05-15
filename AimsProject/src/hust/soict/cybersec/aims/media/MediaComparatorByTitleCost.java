package hust.soict.cybersec.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    @Override
    public int compare(Media o1, Media o2) {
        // Compare by title
        int titleComparison = o1.getTitle().compareTo(o2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        // Compare by cost
        return Double.compare(o2.getCost(), o1.getCost());
    }


        
}
