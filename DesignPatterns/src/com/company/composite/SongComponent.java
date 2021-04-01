package com.company.composite;

public abstract class SongComponent {
    public void add(SongComponent component) {
        throw new UnsupportedOperationException();
    }

    public void remove(SongComponent component) {
        throw new UnsupportedOperationException();
    }

    public SongComponent get(int index) {
        throw new UnsupportedOperationException();
    }

    public void displaySongInfo() {
        throw new UnsupportedOperationException();
    }
}
