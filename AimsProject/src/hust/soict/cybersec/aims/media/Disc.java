package hust.soict.cybersec.aims.media;

public class Disc extends Media {

    private String director;
    private int length;

    // Getter method
    public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
    
    // Constructor 
    public Disc(String title) {
        super(title);
    }
    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }
    
    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                // Compare by title
                return titleComparison;
            } else {
                // Compare by decreasing length
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    // Compare by cost
                    return Double.compare(this.getCost(), otherDVD.getCost());
                }
            }
        } else {
            // If the media object is not a Disc, use the default method of the Media class
            return super.compareTo(other);
        }
    }

}
