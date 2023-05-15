package hust.soict.cybersec.aims.media;

public class Track implements Playable {
    
    private String title;
    private int length;

    // Constructor 
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Play method
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }

    // Getter method
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

}
