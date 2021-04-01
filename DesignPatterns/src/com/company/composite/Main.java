package com.company.composite;

public class Main {
    public static void main(String[] args) {
        SongGroup playlist = new SongGroup("Playlist", "multiple genres");

        SongGroup rockMusic = new SongGroup("Rock", "broad genre of popular music that originated as \"rock and roll\" in the United States in the late 1940s and early 1950s");
        SongGroup dubstep = new SongGroup("Dubstep", "electronic dance music that originated in South London in the late 1990s");
        SongGroup rnb = new SongGroup("Rhythm and blues", "often abbreviated as R&B, is a genre of popular music that originated in African-American communities in the 1940s");

        SongGroup pinkFloyd = new SongGroup("Pink Floyd", "English rock band formed in London in 1965");
        SongGroup album = new SongGroup("Dark Side of the Moon", "1973, 8th studio album");
        Song song1 = new Song("Speak to Me", "Pink Floyd", 1973);
        Song song2 = new Song("Breathe", "Pink Floyd", 1973);
        Song song3 = new Song("On the Run", "Pink Floyd", 1973);
        Song song4 = new Song("Time", "Pink Floyd", 1973);

        album.add(song1);
        album.add(song2);
        album.add(song3);
        album.add(song4);

        SongComponent x = album.get(2);
        x.displaySongInfo();

        album.remove(x);

        pinkFloyd.add(album);

        rockMusic.add(pinkFloyd);

        playlist.add(rockMusic);
        playlist.add(dubstep);
        playlist.add(rnb);

        Player player = new Player(playlist);
        player.getSongList();
    }
}
