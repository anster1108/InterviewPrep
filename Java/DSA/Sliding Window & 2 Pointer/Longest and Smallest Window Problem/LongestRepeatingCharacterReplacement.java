/*
	Longest Repeating Character Replacement
		Given an integer k and a string s, any character in the string can be selected and changed to any other uppercase English character. This operation can be performed up to k times. After completing these steps, return the length of the longest substring that contains the same letter.


		Example 1
			Input : s = "BAABAABBBAAA" , k = 2
			Output : 6
			Explanation : we can change the B present at index 0 , 3 (0 base indexing) to A.
			The new string is "AAAAAABBBAAA".
			The substring "AAAAAA" is the longest substring having same letter with length 6.

		Example 2
			Input : s = "AABABBA" , k = 1
			Output : 4
			Explanation : The underlined characters are changed in the new string obtained.
			The new string is "AABBBBA". The substring "BBBB" is the answer.
			There are other ways to achieve this answer.

		Example 3
			Input : s = "ABCDEF" k = 1
			Output: 2

		Brute :
			Intuition:
				The thought process is very straightforward, first find out each and every substring and while doing so, keep a track of characters and their frequencies. Further, calculate the number of characters that needs to be changed, if it is greater than the given limit then no need to consider that substring, else calculate the maximum length of the substring encountred so far.

			Approach:
				First, initialize few variables: maxLen as 0 to track the maximum length found and maxFreq as 0 to track the highest frequency of any single character in the current window.
				
				Iterate through the array, which will basically be the starting point of the substring. For each starting index, initialize a frequency array hash to count occurrences of characters.
				
				Update max frequency encountered and store it in maxFreq variable. Calculate the number of changes needed to make.
				
				If changes is less than or equal to k, update maxLen with the size of the current valid window. If changes exceeds k, break out of the inner loop since further expanding the window won't help in achieving a valid substring. Finally return the maxLen as a answer.

			Code : 
				public int characterReplacement(String s, int k) {
			        // Variable to store the maximum length of substring found 
			        int maxLen = 0;
			        
			       // Variable to track the maximum frequency of any single character in the current window
			        int maxFreq = 0;

			        // Iterate through each starting point of the substring
			        for (int i = 0; i < s.length(); ++i) {
			            
			            // Initialize hash array for character frequencies
			            int[] hash = new int[26];

			            for (int j = i; j < s.length(); ++j) {
			                  
			                // Update frequency of current character in the hash array
			                hash[s.charAt(j) - 'A']++;

			                // Update max frequency encountered
			                maxFreq = Math.max(maxFreq, hash[s.charAt(j) - 'A']);

			                // Calculate number of changes needed to make
			                int changes = (j - i + 1) - maxFreq;

			                // If the number of changes is less than or equal to k, the current window is valid
			                if (changes <= k) {
			                    maxLen = Math.max(maxLen, j - i + 1);
			                } else {
			                    break;
			                }
			            }
			        }

			        // Return the maximum length of substring with at most k characters replaced
			        return maxLen;
			    }

			Complexity Analysis: 
			    
				Time Complexity:O(N2), where N is the size of the array. Iterating the array twice using two for loops.

				Space Complexity: O(26) . Hash array to store the frequencies of the capital letters.


		Better :

			Intuition:
				The idea here is to use the sliding window technique to solve this problem optimally. This method efficiently finds the longest substring with frequency counting and dynamic adjustments to ensure validity of the window. First expand the window and add those substring that validates the cndition and when it crosses the limit, again shrink the window by moving the left pointer. This process ensures to provide a linear time complexity.

			Approach:
				First initialize few variables: l (left) and r (right) as 0 to define the current window in the string, maxLen as 0 to track the maximum length of valid substrings, maxFreq as 0 to monitor the highest frequency of any single character within the current window. Also, maintain a frequency array hash to count occurrences of characters.

				Incrementally expand the window by moving the r pointer to the right. Update the frequency of the current character in hash and adjust maxFreq if this frequency exceeds the current maxFreq.
				
				Check if the number of characters that need replacement exceeds k. If so, slide the l pointer to the right until the window becomes valid again. Adjust the frequencies in hash and update maxFreq accordingly.
				
				After ensuring the window is valid, update maxLen with the length of the current window. Finally, return maxLen, which holds the length of the longest substring.

			Code : 
				public int characterReplacement(String s, int k) {
        
			        // Variable to store the maximum length of substring found
			        int maxLen = 0;
			        
			        // Variable to track the maximum frequency of any single character in the current window
			        int maxFreq = 0;
			        
			        // Pointers to maintain the current window [l, r]
			        int l = 0, r = 0;
			        
			        // Hash array to count frequencies of characters
			        int[] hash = new int[26];

			        // Iterate through each starting point of substring
			        while (r < s.length()) {
			            // Update frequency of current character in the hash array
			            hash[s.charAt(r) - 'A']++;
			            
			            // Update max frequency encountered
			            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
			            
			            // Check if current window is invalid
			            while ((r - l + 1) - maxFreq > k) {
			                // Slide the left pointer to make the window valid again
			                hash[s.charAt(l) - 'A']--;
			                
			                // Recalculate maxFreq for current window
			                maxFreq = 0;
			                for (int i = 0; i < 26; ++i) {
			                    maxFreq = Math.max(maxFreq, hash[i]);
			                }
			                
			                // Move left pointer forward
			                l++;
			            }
			            
			            // Update maxLen with the length of the current valid substring
			            maxLen = Math.max(maxLen, r - l + 1);
			            
			            // Move right pointer forward to expand window
			            r++;
			        }

			        // Return the maximum length of substring with at most k characters replaced
			        return maxLen;
			    }

			Complexity Analysis: 
			    
				Time Complexity:O((N+N) * 26), where N is the size of the array. The right pointer runs for N times and the left pointer runs for N times throughout. The for loop takes extra O(26) to claculate the maximum frequency.

				Space Complexity: O(26) . Hash array to store all the characters.

*/
import java.util.*;

class LongestRepeatingCharacterReplacement {
    /*Function to find the longest substring 
    with at most k characters replaced*/
    public int characterReplacement(String s, int k) {
        
        /* Variable to store the maximum
        length of substring found*/
        int maxLen = 0;
        
        /* Variable to track the maximum frequency
        of any single character in the current window*/
        int maxFreq = 0;
        
        // Pointers to maintain the current window [l, r]
        int l = 0, r = 0;
        
        // Hash array to count frequencies of characters
        int[] hash = new int[26];

        // Iterate through each starting point of substring
        while (r < s.length()) {
            /* Update frequency of current
            character in the hash array*/
            hash[s.charAt(r) - 'A']++;
            
            // Update max frequency encountered
            maxFreq = Math.max(maxFreq, hash[s.charAt(r) - 'A']);
            
            // Check if current window is invalid
            if ((r - l + 1) - maxFreq > k) {
                /* Slide the left pointer to 
                make the window valid again*/
                hash[s.charAt(l) - 'A']--;
                
                // Move left pointer forward
                l++;
            }
            
            /* Update maxLen with the length 
            of the current valid substring*/
            maxLen = Math.max(maxLen, r - l + 1);
            
            // Move right pointer forward to expand window
            r++;
        }

        /* Return the maximum length of substring
        with at most k characters replaced*/
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 2;

        // Create an instance of LongestRepeatingCharacterReplacement class
        LongestRepeatingCharacterReplacement sol = new LongestRepeatingCharacterReplacement();

        int length = sol.characterReplacement(s, k);

        // Print the result
        System.out.println("Maximum length of substring with at most " + k + " characters replaced: " + length);
    }
}
