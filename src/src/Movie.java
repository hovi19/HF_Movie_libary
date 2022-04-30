package src;

public class Movie {
	private String title;
	private String genre;
	private int length;
	private int year;
	private int ageRating;
	private boolean seen;
	
	public Movie(String t, String g, int l, int y, int a, boolean s) {
		title = t;
		genre = g;
		length = l;
		year = y;
		ageRating = a;
		seen = s;
	}
	
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public int getLength() {
		return length;
	}
	public int getYear() {
		return year;
	}
	public int getAgeRating() {
		return ageRating;
	}
	public boolean isSeen() {
		return seen;
	}
	public void setSeen(boolean seen) {
		this.seen = seen;
	}
	public String toString() {
		return title + "," + genre + "," + length + "," + year + ","
				+ ageRating + "," + seen; 
	}
	
	
}
