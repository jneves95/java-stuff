package com.leetcode.strings;

/**
 * LeetCode 28 March 2021 challenge
 *
 * Given a non-empty string containing an out-of-order English representation of digits 0-9, return the digits in ascending order.
 */
public class EnglishDigits {

    // First approach to unique characters
    public String originalDigits(String s) {
        // Try to work by layers, subsequently eliminating digits with characters that uniquely identify them (e.g. if there's a 'z', then there must be a "zero")
        // First layer - unique characters 'z', 'w', 'u', 'x', 'g' (0, 2, 4, 6, 8)
        // Second layer - because we already eliminated previous digits, there are new unique characters 'o', 'r', 'f', 's' (1, 3, 5, 7)
        // Third layer - only "nine" remains
        // Given these layers, we can just try and parse digits in this order - 0, 2, 4, 6, 8, 1, 3, 5, 7, 9 - by checking if their first character exists

        String[] digitReps = {"zero", "one", "wto", "rthee", "ufor", "five", "xsi", "seven", "geiht", "nine"};  // English representation of digits, with unique character first
        int[] parsingOrder = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};   // The order in which we want to parse the digits
        int[] fmap = new int[26];    // Frequency map of characters
        int[] digits = new int[10];     // Digit count

        // Count the occurrences of each letter
        for (int i = 0; i < s.length(); i++) {
            fmap[s.charAt(i) - 'a']++;
        }

        // Now parse the digits
        for (int i : parsingOrder) {
            char first = digitReps[i].charAt(0);

            // Check if string contains unique character
            while (fmap[first - 'a'] > 0) {
                for (char c : digitReps[i].toCharArray()) {    // Take this digit away
                    fmap[c - 'a']--;
                }
                digits[i]++;
            }
        }

        // Now that we have the parsed digits, just output them to a string
        String ans = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < digits[i]; j++) {
                ans += i;
            }
        }

        return ans;
    }

    // Second, more elegant approach
    public String originalDigitsBetter(String s) {
        // Building on the same premise as the first approach, we can think that for every character 'z', there are the same number of 'zero' words found
        // So it is for 'w', 'u', 'x', 'g'. But now let's take 'o', for example. The number of 'o' characters equals the number of words that contain 'o' (0, 1, 2, 4)
        // But since we've already eliminated 3 of those, we can arrive at the count[1] = count['o'] - count[0+2+4]
        // We can arrive at the remaining values by following the same principle:
        // 0 (zero) -> z
        // 1 (one) -> o-0-2-4
        // 2 (two) -> w
        // 3 (three) -> h-8
        // 4 (four) -> u
        // 5 (five) -> f-4
        // 6 (six) -> x
        // 7 (seven) -> s-6
        // 8 (eight) -> g
        // 9 (nine) -> i-5-6-8 (we don't count 'n' here because 'n' occurs twice in "nine")

        int[] fmap = new int[26];
        int[] count = new int[10];     // Digit count

        // Count the occurrences of each letter
        for (int i = 0; i < s.length(); i++) {
            fmap[s.charAt(i) - 'a']++;
        }

        count[0] = fmap['z' - 'a'];
        count[2] = fmap['w' - 'a'];
        count[4] = fmap['u' - 'a'];
        count[6] = fmap['x' - 'a'];
        count[8] = fmap['g' - 'a'];
        count[1] = fmap['o' - 'a'] - count[0] - count[2] - count[4];
        count[3] = fmap['h' - 'a'] - count[8];
        count[5] = fmap['f' - 'a'] - count[4];
        count[7] = fmap['s' - 'a'] - count[6];
        count[9] = fmap['i' - 'a'] - count[5] - count[6] - count[8];

        String ans = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < count[i]; j++) {
                ans += i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        EnglishDigits ed = new EnglishDigits();

        System.out.println(ed.originalDigits("owoztneoer"));
        System.out.println(ed.originalDigits("fviefuro"));

        System.out.println(ed.originalDigitsBetter("owoztneoer"));
        System.out.println(ed.originalDigitsBetter("fviefuro"));
    }
}
