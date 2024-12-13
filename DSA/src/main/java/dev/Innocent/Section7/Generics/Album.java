package dev.Innocent.Section7.Generics;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        songs = new SongList();
    }

    public boolean addSong(String title, double duration ) {
        if (songs.findSong(title) == null) {
            songs.add(new Song(title, duration));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) {
        if (songs.findSong(trackNumber) != null) {
            playlist.add(songs.songs.get(trackNumber-1));
            return true;
        }
        System.out.println("This album does not have a track " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String title, LinkedList<Song> playlist) {
        Song song = songs.findSong(title);
        if (song == null) {
            System.out.println("The song " + title + " is not in this album");
            return false;
        }
        playlist.add(song);
        return true;
    }


    public static class SongList {
        private ArrayList<Song> songs;

        private SongList() {
            songs = new ArrayList<Song>();
        }

        private boolean add(Song songToAdd){
            for (int i = 0; i < songs.size(); i++) {
                if(songs.get(i).equals(songToAdd)){
                    return false;
                }
            }
            songs.add(songToAdd);
            return true;
        }

        private Song findSong(String title) {
            for (int i = 0; i < songs.size(); i++) {
                if (songs.get(i).getTitle().equals(title)) {
                    return songs.get(i);
                }
            }
            return null;
        }

        private Song findSong(int trackNumber) {
            int index = trackNumber-1;
            for (int i = 0; i < songs.size(); i++) {
                Song song = songs.get(i);
                if (index <= songs.size() && song.equals(songs.get(index))) {
                    return song;
                }
            }
            return null;
        }
    }
}