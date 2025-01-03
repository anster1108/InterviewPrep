/*
    Longest Substring With At Most K Distinct Characters
        Given a string s and an integer k.Find the length of the longest substring with at most k distinct characters.

        Example 1
            Input : s = "aababbcaacc" , k = 2
            Output : 6
            Explanation : The longest substring with at most two distinct characters is "aababb".
            The length of the string 6.

        Example 2
            Input : s = "abcddefg" , k = 3
            Output : 4
            Explanation : The longest substring with at most three distinct characters is "bcdd".
            The length of the string 4.

        Example 3
            Input : s = "abccab" , k = 4
            Output: 6

        Brute : 
            Intuition: 
                The idea here is to generate all possible substrings of the given array using two loops and while doing so, check if the number of distinct characters in the current substring is within the allowed limit, using a map data structure. If the number of distinct characters exceed limit, then no need to consider that substring, else calculate the length of the current substring and update the maximum length of substring.

            Approach: 
                First, initialize few variables as: maxLen as 0, which will store the maximum length of substrings with at most k distinct characters, mpp an unordered_map to track the count of each character in the current substring.
                
                iterate through each possible starting point of the substring in the string using a loop. Before entering the inner loop for each new starting point, clear the map. This ensures that we start counting characters fresh for the new window.
                
                Use another loop from strating point of the substring till sizeOfArray - 1, to expand the window and include more characters in the substring. Add each character to the map and increment its count.
                
                Check if the number of distinct characters is within the limit k. If so, calculate the length of the current valid substring. Update maximum length of the substring. Else, break out of the loop. Finally, return the maxLen variable as an answer.

            Code :
                public int kDistinctChar(String s, int k) {    
                    // Variable to store the 
                    maximum length of substring
                    int maxLen = 0;  
                    
                    // Map to track the count of each
                    character in the current window
                    HashMap<Character, Integer> mpp = new HashMap<>();

                    // Iterate through each starting
                    point of the substring
                    for(int i = 0; i < s.length(); i++){
                        // Clear map for a new starting point
                        mpp.clear();
                        
                        for(int j = i; j < s.length(); j++){
                            
                            // Add the current character to the map
                            char c = s.charAt(j);
                            mpp.put(c, mpp.getOrDefault(c, 0) + 1);
                            
                            // Check if the number of distinct characters is within the limit
                            if(mpp.size() <= k){
                                
                                // Calculate the length of the current valid substring
                                maxLen = Math.max(maxLen, j - i + 1);
                            }
                            else break;
                        }
                    }
                    
                    // Return the maximum length found
                    return maxLen;
                }
            Time Complexity:O(N2), where N is the size of the array. As for every element of the array the inner loop runs for N times.

            Space Complexity: O(k), as at most the map data structure is holding k elements.

        Better :
            Intuition: 
                Here, the idea is to use sliding window approach with hashMap to solve this problem in optimal way. Which ensures that to find the longest substring with at most k distinct characters efficiently by maintaining a sliding window and using a hashmap to keep track of character frequencies within the window.

            Approach: 
                First, initialize few variables: l and r pointers to 0 which represent the left and right boundaries of the current window respectively, maxLen initialized to 0 to store the maximum length of substring with at most k distinct characters found so far, mpp a hashMap is used to track the frequency of characters within the current window.

                Use r pointer to expand the window by iterating through each character of the string. Increment the frequency of the current character in the mpp HashMap.
                
                Check if the number of distinct characters exceeds k. If so, maintain k distinct characters by decrementing the frequency of the character at l pointer. If the frequency becomes zero, remove that character from the map. Move l pointer to the right to shrink the window.
                
                Continue expanding r until it reaches the end of the string. Return maxLen as an answer.

            Code :
                public int kDistinctChar(String s, int k) {
                    // Initialize left pointer, right pointer, and maximum length of substring
                    int l = 0, r = 0, maxLen = 0;
                    
                    // Hash map to store character frequencies
                    HashMap<Character, Integer> mpp = new HashMap<>();
                    
                    while (r < s.length()) {
                        // Increment frequency of current character
                        char currentChar = s.charAt(r);
                        mpp.put(currentChar, mpp.getOrDefault(currentChar, 0) + 1);
                        
                       
                        // If the number of distinct characters 
                        exceeds k, shrink the window from the left
                        while (mpp.size() > k) {
                            
                            // Decrement frequency of character at left pointer
                            char leftChar = s.charAt(l);
                            mpp.put(leftChar, mpp.get(leftChar) - 1);
                            if (mpp.get(leftChar) == 0) {
                                
                                 // Remove character from map if its frequency becomes zero
                                mpp.remove(leftChar);
                            }
                            // Move left pointer to the right
                            l++;
                        }
                        
                        // Update maximum length of substring with at most k distinct characters found so far
                        if (mpp.size() <= k) {
                            maxLen = Math.max(maxLen, r - l + 1);
                        }
                        
                        // Move right pointer
                        r++;
                    }
                    
                    // Return the maximum length found
                    return maxLen;
                }

            Time Complexity:O(2N), where N is the size of the array. As the other while loop runs for N time and the inner while loop runs for N time in total throghto the program. Ignore the contribution of map data structure in the time complexity as size of the map is extremely small.

            Space Complexity: O(k) , as at most the map data structure is holding k elements.
*/
import java.util.*;

class LongestSubstringWithAtMostKDistinctCharacters { 
    /* Function to find the maximum length of 
    substring with at most k distinct characters */
    public int kDistinctChar(String s, int k) {
        
        // Length of the input string
        int n = s.length();  
        
        /* Variable to store the 
        maximum length of substring */
        int maxLen = 0;  
        
        /* Map to track the count of each
        character in the current window */
        HashMap<Character, Integer> mpp = new HashMap<>();
        
        // Pointers for the sliding window approach
        int l = 0, r = 0;
        
        while(r < n){
            char charR = s.charAt(r);
            mpp.put(charR, mpp.getOrDefault(charR, 0) + 1);
            
            /* If number of different characters exceeds
             k, shrink the window from the left*/
            if(mpp.size() > k){
                char charL = s.charAt(l);
                mpp.put(charL, mpp.get(charL) - 1);
                if(mpp.get(charL) == 0){
                    mpp.remove(charL);
                }
                l++;
            }
            
            /* If number of different characters 
            is at most k, update maxLen*/
            if(mpp.size() <= k){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            
            r++;
        }
        
        // Return the maximum length
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "aaabbccd";  
        int k = 2;
        
        // Create an instance of LongestSubstringWithAtMostKDistinctCharacters class
        LongestSubstringWithAtMostKDistinctCharacters sol = new LongestSubstringWithAtMostKDistinctCharacters();
        
        int length = sol.kDistinctChar(s, k);
        
        // Print the result
        System.out.println("Maximum length of substring with at most " + k + " distinct characters: " + length);
    }
}

