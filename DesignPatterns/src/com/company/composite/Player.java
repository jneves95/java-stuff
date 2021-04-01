package com.company.composite;

public class Player {
    private SongComponent songList;

    Player(SongComponent songList) {
        this.songList = songList;
    }

    public void getSongList() {
        songList.displaySongInfo();
    }
}
