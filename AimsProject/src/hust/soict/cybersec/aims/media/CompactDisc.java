package hust.soict.cybersec.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Media {

    private String artist;
    private ArrayList<Track> tracks; 

    
    public String getArtist() {
        return artist;
    }


    public CompactDisc(String title) {
        super(title);
    }
    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists in CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track does not exist in CD.");
        }
    }
    
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

}
