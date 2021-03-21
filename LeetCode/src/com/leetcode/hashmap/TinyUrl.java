package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Encodes and decodes a given Url for a Url shortening service.
 */
public class TinyUrl {
    private Map<String, String> urlMap;
    private Map<String, String> urlIndex;

    public TinyUrl() {
        urlMap = new HashMap<>();
        urlIndex = new HashMap<>();
    }

    /**
     * Creates an alphanumeric hash code 6 characters long.
     */
    public String hash(String url) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            int rand = (int) (Math.random() * 62);
            if (rand < 10) sb.append(rand);
            else if (rand < 36) sb.append('A' + rand - 10);
            else sb.append('a' + rand - 36);
        }
        return sb.toString();
    }

    public String encode(String url) {
        // Check to see if this url is already stored
        if (urlIndex.containsKey(url)) return "http://tinyurl.com/" + urlIndex.get(url);

        String hash = hash(url);

        // Check to see if duplicate
        while (urlMap.containsKey(hash)) {
            hash = hash(url);
        }

        urlMap.put(hash, url);
        urlIndex.put(url, hash);
        return "http://tinyurl.com/" + hash;
    }

    public String decode(String tinyUrl) {
        return urlMap.get(tinyUrl.substring(19));
    }

    public static void main(String[] args) {
        TinyUrl tu = new TinyUrl();

        String tinyurl = tu.encode("http://leetcode.com/problems/tinyurl");
        System.out.println(tinyurl);
        System.out.println(tu.decode(tinyurl));

        tinyurl = tu.encode("http://leetcode.com/problems/tinyurl");
        System.out.println(tinyurl);
        System.out.println(tu.decode(tinyurl));
    }
}
