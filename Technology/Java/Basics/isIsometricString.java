/*
Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

Example 1 : 
	Input : s = "egg" , t = "add"

	Output : true

	Explanation : The 'e' in string s can be replaced with 'a' of string t.

	The 'g' in string s can be replaced with 'd' of t.

	Hence all characters in s can be replaced to get t.

Example 2 : 
	Input : s = "apple" , t = "bbnbm"

	Output : false

	Explanation : The 'a' in string s can be replaced with 'n' of string t.

	The 'p' in string s can be replaced by 'b' of string t.

	The 'l' in string s can be replaced by 'm' of string t.

	The 'e' in string s cannot be replaced by any character of string t as all the characters in string t are already mapped.

	Hence all characters in s cannot be replaced to get t.
*/

class isIsometricString {
    public boolean isomorphicString(String s, String t) {
        // Arrays to store the last seen positions of characters in s and t
        int[] m1 = new int[256], m2 = new int[256];
        
        // Length of the string
        int n = s.length();
        
        // Iterate through each character in the strings
        for (int i = 0; i < n; ++i) {
            // If the last seen positions of the current characters don't match, return false
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            
            // Update the last seen positions
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        
        // If all characters match, return true
        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "egg";
        String t = "add";
        // "apple", "bbnbm" // false , as b is already mapped to a at first iteration, so can't be mapped to p
        if (solution.isomorphicString(s, t)) {
            System.out.println("Strings are isomorphic.");
        } else {
            System.out.println("Strings are not isomorphic.");
        }
    }
}
