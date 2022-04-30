package src;

public class Documentary extends Movie{
	
	private String description;
	
	public Documentary(String t, String g, int l, int y, int a, boolean s, String d) {
		super(t, g, l, y, a, s);
		description = d;
	}

	public String getDescription() {return description;}
}
