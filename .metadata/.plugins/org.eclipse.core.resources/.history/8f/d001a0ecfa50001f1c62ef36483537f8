package com.aurionpro.behavioural.iterator.model;

import java.util.ArrayList;
import java.util.List;

public class Playlist implements IterableCollection {
    private List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    @Override
    public SongIterator createIterator() {
        return new PlaylistIterator(songs);
    }
}
