/*
Question : Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


Example 1
    Input : s = "anagram" , t = "nagaram"

    Output : true

    Explanation : We can rearrange the characters of string s to get string t as frequency of all characters from both strings is same.

Example 2
    Input : s = "dog" , t = "cat"

    Output : false

    Explanation : We cannot rearrange the characters of string s to get string t as frequency of all characters from both strings is not same.
*/

import java.util.Arrays;

class CheckStringAnagram {
    /* Brute Force
        public boolean anagramStrings(String s, String t) {
            // If lengths are not equal, they cannot be anagrams
            if (s.length() != t.length()) return false;

            // Convert strings to char arrays and sort them
            char[] sArray = s.toCharArray();
            char[] tArray = t.toCharArray();
            Arrays.sort(sArray);
            Arrays.sort(tArray);

            // Compare sorted arrays
            return Arrays.equals(sArray, tArray);
        }
    */

    // Optimal
    public boolean anagramStrings(String s, String t) {
        // Edge Cases
        if (s.length() != t.length()) return false;

        // To store the count of each character
        int[] count = new int[26];

        // Count occurrence of each character in first string 
        for (char c : s.toCharArray()) count[c - 'a']++;

        // Decrement the count for each character in the second string
        for (char c : t.toCharArray()) count[c - 'a']--;

        // Check for count of every character
        for (int i : count) {
            // If the count is not zero
            if (i != 0) return false; // Return false
        }

        // Otherwise strings are anagram
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str1 = "INTEGER";
        String str2 = "TEGERNI";
        boolean result = solution.anagramStrings(str1, str2);
        System.out.println(result ? "True" : "False");
    }
}
