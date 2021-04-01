package com.company.composite;

import java.util.ArrayList;
import java.util.List;

public class SongGroup extends SongComponent {
    private String groupName;
    private String groupDescription;
    private List<SongComponent> songComponents;

    public SongGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        songComponents = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void add(SongComponent component) {
        songComponents.add(component);
    }

    public void remove(SongComponent component) {
        songComponents.remove(component);
    }

    public void remove(int index) {
        songComponents.remove(index);
    }

    public SongComponent get(int index) {
        return songComponents.get(index);
    }

    public void displaySongInfo() {
        System.out.println(getGroupName() + " (" + getGroupDescription() + ")");

        for (SongComponent component : songComponents) {
            component.displaySongInfo();
        }
    }
}
