package mediaplayer.main;

import mediaplayer.model.Song;
import mediaplayer.service.PlaylistManager;

public class Main {
    public static void main(String[] args) {
        PlaylistManager player = new PlaylistManager();

        Song s1 = new Song("S01", "Blinding Lights", "The Weeknd");
        Song s2 = new Song("S02", "Starboy", "The Weeknd");
        Song s3 = new Song("S03", "Shape of You", "Ed Sheeran");
        Song s4 = new Song("S01", "Blinding Lights", "The Weeknd");

        player.addSongToEnd(s1);
        player.addSongToEnd(s2);
        player.addSongToEnd(s3);
        player.addSongToEnd(s4);

        System.out.println("--- INITIAL PLAYLIST (WITH DUPLICATES) ---");
        player.displayPlaylist();

        System.out.println("\n--- REMOVING DUPLICATES ---");
        player.removeDuplicates();
        player.displayPlaylist();

        System.out.println("\n--- PRIORITY QUEUEING (ADD TO FRONT) ---");
        Song prioritySong = new Song("S04", "Levitating", "Dua Lipa");
        player.addSongToFront(prioritySong);
        player.displayPlaylist();

        System.out.println("\n--- BIDIRECTIONAL NAVIGATION TEST ---");
        player.playNext();
        player.playNext();
        player.playPrevious();
    }
}