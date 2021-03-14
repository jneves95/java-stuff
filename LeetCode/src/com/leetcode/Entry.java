package com.leetcode;

public class Entry {
    private int key;
    private int value;
    Entry next;

    public Entry(int key, int value) {
        this.key = key;
        this.value = value;
        next = null;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Entry getCopy() {
        return new Entry(key, value);
    }

    public String toString() {
        return "(" + key + " / " + value + ")";
    }

}
