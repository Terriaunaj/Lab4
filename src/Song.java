import java.util.Arrays;

public class Song {

	private String title;
	private String artist;
	private int[] time;
	
	public Song(String title, String artist, int[] time) {
	//make copy of time array before assigning	
		this.artist = artist;
		this.title = title;		
		this.time = Arrays.copyOf(time, time.length);	
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public int[] getTime() {
	//make copy of time array before returning	
		int[] copy = Arrays.copyOf(time, time.length);
		return copy;
	}
}
