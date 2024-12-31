/*
	Minimum Window Substring
		Given two strings s and t. Find the smallest window substring of s that includes all characters in t (including duplicates) , in the window. Return the empty string "" if no such substring exists.


		Example 1
			Input : s = "ADOBECODEBANC" , t = "ABC"
			Output : "BANC"
			Explanation : The minimum window substring of string s that contains the string t is "BANC".

		Example 2
			Input : s = "a" , t = "a"
			Output : "a"
			Explanation : The complete string is the minimum window

		Example 3
			Input : s = "aAbBDdcC" , t = "Bc"
			Output: "BDdc"

		Brute :
			Intuition:
				The idea here is to use two for loops to find out all the substrings and while finding out, keep a track of the charaters present in the current substring using a hash array. If the current substring has all the charaters required then store its starting index and return the substring.

			Approach:
				First, initialize few variables: minLen to Integer.MAX_VALUE to store the minimum length of the substring found and sIndex to -1 to store the starting index of this substring. Use an array hash of size 256 (assuming ASCII characters) to count frequencies of characters in the reference string.
			
				Traverse through each character in string, it will indicate the starting point of the substring, for each starting index, initialize count to 0 to track how many characters from t are found in the current substring.
			
				Now, again iterate through the array using a for loop form the starting point of the substring till the end of array. Update the frequency count in hash for the character current character.
			
				If this character is required, increment count. When count equals the length of the another string given this means all characters from the later string are found in the current substring.
			
				Update minLen and sIndex if the length of this window (j - i + 1) is smaller than the current minimum length found. After iterating through all possible starting indices, return the substring starting at sIndex with length minLen. If sIndex remains -1, return an empty string indicating no valid substring was found.
			
			Code :
				public String minWindow(String s, String t) {
			        // Variable to store the minimum length of substring found
			        int minLen = Integer.MAX_VALUE;
			        
			        // Variable to store the starting index of the minimum length substring 
			        int sIndex = -1;
			        
			        // Iterate through string s
			        for (int i = 0; i < s.length(); ++i) {
			            
			            // Array to count frequencies of characters in t
			            int[] hash = new int[256];
			            for (char c : t.toCharArray()) {
			                hash[c]++;
			            }
			            
			            int count = 0;
			            
			            // Iterate through current window 
			            for (int j = i; j < s.length(); ++j) {
			                if (hash[s.charAt(j)] > 0) {
			                    count++;
			                }
			                hash[s.charAt(j)]--;
			                
			                // If all characters from t are found in current window 
			                if (count == t.length()) {
			                    
			                    / Update minLen and sIndex if current window is smaller 
			                    if (j - i + 1 < minLen) {
			                        minLen = j - i + 1;
			                        sIndex = i;
			                    }
			                    break;
			                }
			            }
			        }
			        
			        // Return the minimum length substring from s
			        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
			    }

			Complexity Analysis: 
				Time Complexity:O(N^2), where N is the size of the string. The outer loop runs for N time and for each character the inner loop also runs for N times.

				Space Complexity: O(256) . Hash array to store frequency of all the characters.
*/
import java.util.*;

class MinimumWindowSubstring {
    /* Function to find the minimum length 
    substring in string s that contains
    all characters from string t. */
    public String minWindow(String s, String t) {
        
        /* Variable to store the minimum 
        length of substring found */
        int minLen = Integer.MAX_VALUE;
        
        /* Variable to store the starting index
        of the minimum length substring */
        int sIndex = -1;
        
        /* Array to count frequencies
        of characters in string t*/
        int[] hash = new int[256];
        
        // Count the frequencies of characters in t
        for (char c : t.toCharArray()) {
            hash[c]++;
        }
            
        int count = 0;
        int l = 0, r = 0;
        
        // Iterate through current window 
        while (r < s.length()) {
            // Include the current character in the window
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;
                
            /* If all characters from t 
            are found in current window */
            while (count == t.length()) {
                    
                /* Update minLen and sIndex
                if current window is smaller */
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    sIndex = l;
                }
                
                // Remove leftmost character from window
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }
            r++;
        }
        
        // Return minimum length substring from s
        return (sIndex == -1) ? "" : s.substring(sIndex, sIndex + minLen);
    }

    public static void main(String[] args) {
        String s = "ddaaabbca";
        String t = "abc";

        // Create an instance of MinimumWindowSubstring class
        MinimumWindowSubstring sol = new MinimumWindowSubstring();

        String ans = sol.minWindow(s, t);

        // Print the result
        System.out.println("Minimum length substring containing all characters from \"" + t + "\" is: " + ans);
    }
}
/*
	Complexity Analysis: 
		Time Complexity:O(2N + M ), where N is the size of the string s and M is the size of the string t.
		Space Complexity: O(256) . Hash array to store frequency of all the characters.
*/
