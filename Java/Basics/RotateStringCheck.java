/*
    Question : Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

    A shift on s consists of moving the leftmost character of s to the rightmost position.

    For example, if s = "abcde", then it will be "bcdea" after one shift.


    Example 1
    Input : s = "abcde" , goal = "cdeab"

    Output : true

    Explanation : After performing 2 shifts we can achieve the goal string from string s.

    After first shift the string s is => bcdea

    After second shift the string s is => cdeab.

    

*/


public class RotateStringCheck {
    // optimal
    public boolean rotateString(String s, String goal) {
    // Strings must be same length to be rotations of each other
        if (s.length() != goal.length()) {
            return false; 
        }
        
        // Doube the string s
        String temp = s + s;
        return temp.contains(goal);  
    }

    /* brute force 
        public boolean rotateString(String s, String goal) {
        // Strings must be same length to be rotations of each other
            if (s.length() != goal.length()) {
                return false; 
            }
            // Try all possible rotations of s
            for (int i = 0; i < s.length(); i++) {
                String rotated = s.substring(i) + s.substring(0, i); 
                if (rotated.equals(goal)) {
                    return true;  // Return true if a match is found
                }
            }
            return false;  
        }
    */

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rotateString("abcde", "cdeab"));  
        System.out.println(sol.rotateString("abcde", "abced"));  
    }
}
