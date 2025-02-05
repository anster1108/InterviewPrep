/*
	Number of Substrings Containing All Three Characters
		Given a string s , consisting only of characters 'a' , 'b' , 'c'.Find the number of substrings that contain at least one occurrence of all these characters 'a' , 'b' , 'c'.

		Example 1
			Input : s = "abcba"
			Output : 5
			Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "abc" , "abcb" , "abcba" , "bcba" , "cba".

		Example 2
			Input : s = "ccabcc"
			Output : 8
			Explanation : The substrings containing at least one occurrence of the characters 'a' , 'b' , 'c' are "ccab" , "ccabc" , "ccabcc" , "cab" , "cabc" , "cabcc" , "abc" , "abcc".

		Example 3
			Input : s = "abccba"
			Output: 7


		Brute : 
			Intuition:
				Here, the idea is to find all possible substrings of the given string and while doing so, mark the presence of each character in the hash array. If 'a', 'b', 'c' are present in the current subarray increment the count and finally return it.

			Approach:
				Initialize count to 0 to keep track of the number of valid substrings found.
				
				Iterate through the array using a loop, to reach every staring point of the substring. Use an array hash of size 3 to track the presence of characters 'a', 'b', 'c'. Initialize it to {0} at the beginning of each iteration of the outer for loop.
				
				Now, initialize another for loop from starting point of the substring till the end of the array. Mark the presence of the current character in the hash array.
				
				After marking the current character in hash, check if all characters 'a', 'b', 'c' are present by summing up hash[0] + hash[1] + hash[2]. If the sum equals 3, increment the count as it indicates that the substring from index i to j contains all required characters. After completing the loops, finally return the count variable.

			Code: 
				public int numberOfSubstrings(String s) {
			        int count = 0;
			        
			        // Iterate through each starting point of substring
			        for (int i = 0; i < s.length(); ++i) {
			            
			            // Array to track presence of 'a', 'b', 'c'
			            int[] hash = new int[3]; 
			            
			            // Iterate through each ending point of substring
			            for (int j = i; j < s.length(); ++j) {
			                
			                // Mark current character in hash
			                hash[s.charAt(j) - 'a'] = 1; 
			                
			                // Check if all characters 'a', 'b', 'c' are present
			                if (hash[0] + hash[1] + hash[2] == 3) {
			                    
			                    // Increment count for valid substring
			                    count++; 
			                }
			            }
			        }
			        // Return the total count of substrings
			        return count;
			    }

			Complexity Analysis: 
				Time Complexity:O(N2), where N is the size of the string. The outer loop runs for N time and for each character the inner loop also runs for N times.

				Space Complexity: O(1) . As no significant amount of extra space is used.
*/

class NumberOfSubstringsContainingAllThreeCharacters {
    /* Function to find the number of substrings 
    containing all characters 'a', 'b', 'c' in string s. */
    public int numberOfSubstrings(String s) {
        
        /* Array to store the last seen
        index of characters 'a', 'b', 'c'*/
        int[] lastSeen = {-1, -1, -1};
        
        int count = 0;
        
        // Iterate through each character in string s
        for (int i = 0; i < s.length(); ++i) {
            
            // Update lastSeen index 
            lastSeen[s.charAt(i) - 'a'] = i;
            
            /* Check if all characters 'a',
            'b', 'c' have been seen*/
            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                
                /* Count valid substrings
                ending at current index*/
                count += 1 + Math.min(Math.min(lastSeen[0], lastSeen[1]), lastSeen[2]);
            }
        }
        
        // Return the total count of substrings
        return count;
    }
    
    public static void main(String[] args) {
        String s = "bbacba";
        
        // Create an instance of NumberOfSubstringsContainingAllThreeCharacters class
        NumberOfSubstringsContainingAllThreeCharacters sol = new NumberOfSubstringsContainingAllThreeCharacters();
        
        int ans = sol.numberOfSubstrings(s);
        
        // Print the result
        System.out.println("Number of substrings containing 'a', 'b', 'c' in \"" + s + "\" is: " + ans);
    }
}
