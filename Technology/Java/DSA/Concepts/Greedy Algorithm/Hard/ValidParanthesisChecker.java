/*
	Valid Paranthesis Checker
		Find the validity of an input string s that only contains the letters '(', ')' and '*'.

		A string entered is legitimate if

		- Any left parenthesis '(' must have a corresponding right parenthesis ')'.
		- Any right parenthesis ')' must have a corresponding left parenthesis '('.
		- Left parenthesis '(' must go before the corresponding right parenthesis ')'.
		- '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

		Example 1
			Input : s = "(*))"
			Output : true
			Explanation : The * can be replaced by an opening '(' bracket. The string after replacing the * mark is "(())" and is a valid string.

		Example 2
			Input : s = "*(()"
			Output : false
			Explanation : The * replaced with any bracket does not form a valid string.

		Example 3
			Input : s = "(**()))"
			Output: true

	Intuition
		The optimal approach builds on the idea of balancing opening and closing parentheses but introduces a method to efficiently handle asterisks. 
		By maintaining a range of possible balances (minimum and maximum count of open parentheses), the solution tracks the potential valid states as the string is processed. 
		This range ensures that all valid configurations are considered without explicitly generating each possible string.

	Detailed Thought Process
		Instead of treating each asterisk as three separate branches in a recursion tree, maintain two variables representing the minimum and maximum possible number of open parentheses. 
		As each character in the string is processed, update these variables accordingly. If an asterisk is encountered, adjust the range to reflect its three possible replacements. 
		Throughout the process, ensure that the minimum number of open parentheses never goes negative. At the end of the string, check if the minimum count is zero to determine validity.

	Approach
		-> Initialize two variables, minOpen and maxOpen, to track the range of possible open parentheses.
		-> Traverse the string character by character.
		-> If an opening parenthesis is encountered, increment both minOpen and maxOpen.
		-> If a closing parenthesis is encountered, decrement both minOpen and maxOpen.
		-> If an asterisk is encountered, decrement minOpen (treat as closing), leave it unchanged (treat as empty), and increment maxOpen (treat as opening).
		-> Ensure that minOpen never goes below zero.
		-> After processing the string, check if minOpen is zero to determine if the string is valid.
	
	Time Complexity O(N) : This is because the algorithm processes each element of the input exactly once, leading to a linear time complexity.

	Space Complexity O(1) : This is due to the use of a constant amount of extra space regardless of the input size, making the space complexity constant.

*/
class ValidParanthesisChecker {
    public boolean isValid(String s) {
        int minOpen = 0, maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                minOpen++; // Treat as opening
                maxOpen++; // Treat as opening
            } else if (c == ')') {
                minOpen--; // Treat as closing
                maxOpen--; // Treat as closing
            } else if (c == '*') {
                minOpen--; // Treat as closing
                maxOpen++; // Treat as opening
            }
            if (maxOpen < 0) return false; // More closing parentheses than opening
            if (minOpen < 0) minOpen = 0; // Reset minOpen if negative
        }
        return minOpen == 0; // Check if balanced
    }

    public static void main(String[] args) {
        ValidParanthesisChecker sol = new ValidParanthesisChecker();
        String s = "(({}))";
        System.out.println(sol.isValid(s) ? "true" : "false");
    }
}
