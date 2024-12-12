package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new SongList();
    }

    public boolean addSong(String title, double duration) {
        return songList.add(new Song(title, duration));
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        Song song = songList.findSong(trackNumber);
        if (song != null) {
            playlist.add(song);
            return true;
        } else {
            System.out.println("This album does not have a track " + trackNumber);
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songList.findSong(title);
        if (song != null) {
            playlist.add(song);
            return true;
        } else {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
    }

    private class SongList {
        private ArrayList<Song> songs;

        public SongList() {
            this.songs = new ArrayList<>();
        }

        private boolean add(Song song) {
            if (findSong(song.getTitle()) == null) {
                songs.add(song);
                return true;
            }
            return false;
        }

        private Song findSong(String title) {
            for (Song song : songs) {
                if (song.getTitle().equalsIgnoreCase(title)) {
                    return song;
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber - 1;
            if (index >= 0 && index < songs.size()) {
                return songs.get(index);
            }
            return null;
        }
    }
}