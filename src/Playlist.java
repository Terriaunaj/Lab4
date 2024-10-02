import java.util.Arrays;

public class Playlist {

	private Song[] songs;
	private int numSongs;
	private static final int MIN_CAPACITY = 3;
	
	public Playlist() {
		songs = new Song[MIN_CAPACITY];
	}
	
	public Playlist(int capacity) {
		if(capacity < MIN_CAPACITY) {
			songs = new Song[MIN_CAPACITY];
		}
		else {
			songs = new Song[capacity];
		}
	}
	
	public int getCapacity() {
		return songs.length;
	}
	
	public int getNumSongs() {
		return numSongs;
	}
	
	public Song getSong(int index) {
		
		if(index < 0 || index >= songs.length) {
			return null;
		}
		else {
			return songs[index];
		}
	}
	
	public Song[] getSongs() {
		return Arrays.copyOf(songs, numSongs);
	}
	
	public boolean addSong(Song song) {
		return addSong(getNumSongs(), song);
		
	}
	
	public boolean addSong(int index, Song song) {
				
		
		if(numSongs == songs.length ){			
			return false;
		}
		if(index < 0 || index > numSongs){
			return false;
		}
		if(song == null) {
			return false;
		}
		
			for(int i = numSongs - 1; i >= index; i--) {
			
				songs[i+1] = songs[i];
			
			}
			songs[index] = song;
			numSongs++;
			return true;
		
	}
	
	public int addSongs(Playlist playlist) {
		 
		int num = 0;
		if(playlist == null) {
			return 0;
		}
		
		Song[] copy = Arrays.copyOf(playlist.getSongs(), playlist.getNumSongs());
		for(int i = 0; i < numSongs; i++) {
			
			if(addSong(playlist.getSong(i)) == false) {
				break;
			}	
				addSong(songs.length,playlist.getSong(i));
				num++;
		}
		return num;
		
	}
	
	public Song removeSong() {
		
		return removeSong(numSongs-1);
		
	}
	
	public Song removeSong(int index) {
		
		if(index < 0 ){
			return null;
		}
		else if(songs[index] == null) {
			return null;
		}
		else if(index > songs.length - 1) {
			return null;
		}
		
		Song removed = songs[index];
		
		for(int i = index; i<songs.length; i++) {
			
			if(i == (songs.length - 1)) {
				songs[i] = null;
				break;
			}
			
			else {
				songs[i] = songs[i+1];
			}
		}
		numSongs--;
		return removed;
	}
}
