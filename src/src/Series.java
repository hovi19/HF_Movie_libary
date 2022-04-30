package src;

public class Series extends Movie{
	private int seasons;
	private int episodes;
	
	public Series(String title, String genre, int length, int year, int ageRating, boolean seen, int seasons, int episodes)
	{
		super(title,genre,length,year,ageRating,seen);
		this.seasons = seasons;
		this.episodes = episodes;
	}
	
	public int getSeasons() {
		return seasons;
	}
	public int getEpisodes() {
		return episodes;
	}
	public String toString() {
		return super.toString() + "," + seasons + "," +  episodes;
	}
	
}
