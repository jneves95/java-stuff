package com.leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyHashMap {
    private int capacity;
    private float loadFactor;
    private int size;
    private List<Entry> buckets;

    public MyHashMap() {
        this(16, (float) 0.75);
    }

    public MyHashMap(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        size = 0;
        buckets = createMap(capacity);
    }

    public int hash(int key) {
        return key & (capacity - 1);
    }

    public List<Entry> createMap(int capacity) {
        List<Entry> buckets = new ArrayList<>(capacity);

        // Initialize bucket array
        for (int i = 0; i < capacity; i++) {
            buckets.add(null);
        }

        return buckets;
    }

    /*
    Resizes and rehashes map when capacity is over our load factor.
    We start by doubling the map capacity and then redistributing the existing key-value pairs into the new bucket array.
    During the redistribution, we know all key-value pairs are unique, so we don't need to search like in our put method, we can just insert them.
     */
    public void resize() {
        // Double the map capacity
        capacity <<= 1;
        List<Entry> newBuckets = createMap(capacity);


        // Copy entries from old array into new larger one
        for (Entry head : buckets) {
            Entry entry = head;
            while (entry != null) {
                Entry newEntry = entry.getCopy();
                int index = hash(newEntry.getKey());

                // Inserts entry at the start of the bucket
                newEntry.next = newBuckets.get(index);
                newBuckets.set(index, newEntry);

                entry = entry.next;
            }
        }

        buckets = newBuckets;
    }

    public void put(int key, int value) {
        // Get hash code of key
        int index = hash(key);

        // Check if bucket exists
        Entry entry = buckets.get(index);

        if (entry == null) {
            // If bucket empty, this will be its first entry
            buckets.set(index, new Entry(key, value));
        }
        else {
            // Otherwise, traverse bucket in search of key
            while (entry != null) {
                if (entry.getKey() == key) {
                    entry.setValue(value);
                    return;
                }
                entry = entry.next;
            }

            // If key didn't exist, add it to the start of bucket
            Entry e = new Entry(key, value);
            e.next = buckets.get(index);
            buckets.set(index, e);
        }

        // New key was added, check if resize is necessary
        size++;
        if (size > capacity * loadFactor) {
            resize();
        }
    }

    public int get(int key) {
        int index = hash(key);

        Entry entry = buckets.get(index);
        while (entry != null) {
            if (entry.getKey() == key)
                return entry.getValue();
            else
                entry = entry.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        Entry entry = buckets.get(index);
        Entry prev = entry;

        while (entry != null) {
            if (entry.getKey() == key) {
                if (prev == entry) {
                    // If it was first entry, the bucket should point to the next entry
                    buckets.set(index, entry.next);
                }
                else {
                    prev.next = entry.next;
                }
                size--;
            }
            prev = entry;
            entry = entry.next;
        }
    }

    /*
    Print out the whole map by buckets
     */
    public void print() {
        for (int i = 0; i < capacity; i++) {
            System.out.print(i + ": [");
            Entry e = buckets.get(i);
            while (e != null) {
                System.out.print(e.toString());
                if (e.next != null) System.out.print(", ");
                e = e.next;
            }
            System.out.println("]");
        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();

        try {
            File inputOps = new File("ops");
            File inputValues = new File("values");
            File inputExpected = new File("expected");
            Scanner opsReader = new Scanner(inputOps);
            Scanner valuesReader = new Scanner(inputValues);
            Scanner expectedReader = new Scanner(inputExpected);

            while (opsReader.hasNextLine() && valuesReader.hasNextLine() && expectedReader.hasNextLine()) {
                String op = opsReader.nextLine();
                String values = valuesReader.nextLine();
                String expected = expectedReader.nextLine();

                switch (op) {
                    case "put" -> {
                        String[] vals = values.split(",");
                        int key = Integer.parseInt(vals[0]);
                        int val = Integer.parseInt(vals[1]);
                        map.put(key, val);
                    }
                    case "get" -> {
                        int val = map.get(Integer.parseInt(values));
                        int expectedVal = Integer.parseInt(expected);
                        if (val != expectedVal) {
                            map.get(Integer.parseInt(values));
                            System.out.println("Found an error. Output = " + val + "; Expected: " + expectedVal);
                        }
                    }
                    case "remove" -> map.remove(Integer.parseInt(values));
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
