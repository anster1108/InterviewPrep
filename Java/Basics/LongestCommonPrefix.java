/*
	Question : Write a function to find the longest common prefix string amongst an array of strings.

	If there is no common prefix, return an empty string "".

	Example 1
	Input : str = ["flowers" , "flow" , "fly", "flight" ]

	Output : "fl"

	Explanation : All strings given in array contains common prefix "fl".

	Example 2
	Input : str = ["dog" , "cat" , "animal", "monkey" ]

	Output : ""

	Explanation : There is no common prefix among the given strings in array.
*/

import java.util.Arrays;

class LongestCommonPrefix{
    // Method to find the longest common prefix in an array of strings
    public String longestCommonPrefix(String[] v) {
        // Use StringBuilder to build the result
        StringBuilder ans = new StringBuilder();
        
        // Sort the array to get the lexicographically smallest and largest strings
        Arrays.sort(v);
        // First string (smallest in sorted order)
        String first = v[0]; 
         // Last string (largest in sorted order)
        String last = v[v.length - 1];
        
        // Compare characters of the first and last strings
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
            // If characters don't match, return the current prefix
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            // Append the matching character to the result
            ans.append(first.charAt(i));
        }
        
        // Return the longest common prefix found
        return ans.toString();
    }
    
    // Main method to test the longestCommonPrefix method
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] input = {"flower", "flow", "flight"};
        // String[] input = {"flower", "alow", "flight"}; // Output : ""
        String result = solution.longestCommonPrefix(input);
        System.out.println("Longest Common Prefix: " + result); // Output: "fl"
    }
}
