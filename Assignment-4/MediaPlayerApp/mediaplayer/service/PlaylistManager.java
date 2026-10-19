package mediaplayer.service;

import mediaplayer.model.Song;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlaylistManager {
    private LinkedList<Song> queue = new LinkedList<>();
    private ListIterator<Song> iterator = queue.listIterator();

    public void addSongToEnd(Song song) {
        queue.add(song);
        resetIterator();
    }

    public void addSongToFront(Song song) {
        queue.addFirst(song);
        resetIterator();
    }

    public void addSongAt(int index, Song song) {
        if (index >= 0 && index <= queue.size()) {
            queue.add(index, song);
            resetIterator();
        } else {
            System.out.println("Invalid index position.");
        }
    }

    public void removeDuplicates() {
        LinkedHashSet<Song> uniqueSongs = new LinkedHashSet<>(queue);
        queue.clear();
        queue.addAll(uniqueSongs);
        resetIterator();
        System.out.println("Duplicates removed successfully.");
    }

    public void playNext() {
        if (iterator.hasNext()) {
            System.out.println("Playing Next: " + iterator.next());
        } else {
            System.out.println("End of playlist reached.");
        }
    }

    public void playPrevious() {
        if (iterator.hasPrevious()) {
            System.out.println("Playing Previous: " + iterator.previous());
        } else {
            System.out.println("Start of playlist reached.");
        }
    }

    private void resetIterator() {
        iterator = queue.listIterator();
    }

    public void displayPlaylist() {
        System.out.println("Current Playlist Queue: " + queue);
    }
}