package hust.soict.cybersec.aims.media;

import java.time.Duration;

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
    public String playGUI() {
        return "Playing track: " + this.getTitle() + "\n" + 
                "Track length: " + formatDuration(this.getLength());
    }
    public String formatDuration(int durationInSeconds) {
        Duration duration = Duration.ofSeconds(durationInSeconds);
        return String.format("%02d:%02d", duration.toMinutes(), duration.minusMinutes(duration.toMinutes()).getSeconds());
    }
    // Getter method
    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {  
            return true;
        }
        if (!(obj instanceof Track)) {
            return false;
        }
        return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
    }
}
