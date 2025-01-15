/*
	Balanced Paranthesis
		Given string str containing just the characters '(', ')', '{', '}', '[' and ']', check if the input string is valid and return true if the string is balanced otherwise return false.
		
		Input: str = “()[{}()]”
		Output: True
		Explanation: As every open bracket has its corresponding close bracket. Match parentheses are in correct order hence they are balanced.

		Input: str = “[()”
		Output: False
		Explanation: As ‘[‘ does not have ‘]’ hence it is not valid and will return false.

		Input: str = "{[()]}"
		Output: 1


	Intuition:
		Let us understand first when a string is said to be balanced:

		Every opening bracket must have a corresponding closing bracket and vice versa.
		Example: "(){}" is valid but "(]{}" is invalid.
		
		The order of opening brackets must follow the order to closing brackets.
		Example: "([{}])" is valid but "({[}])" is invalid.

	In order to find whether a paranthesis is matching or not, we need to know what was the last opened paranthesis for every closing paranthesis found.
	
	Example: If a ')' (closing paranthesis) is found, the last opened paranthesis must be '(', then only the paranthesis will be matched, otherwise it's a mismatch.

	Now, in order to find the last opened paranthesis first, a data structure like stack will be helpful.
	
	The stack will store opening brackets (i.e., '(' or '[' or '{') to maintain them in LIFO order. The following operations will be performed:
	
		For every opening bracket found, it must be pushed on top of the stack.
		
		For every closing bracket found, the last opened bracket (top element of the stack) can be taken out. Now there can be the following cases:
		
		Match: If the opening bracket found matches with the closing bracket.
		
		Mismatch: If the opening bracket found does not match with the closing bracket. This leads to an unbalanced paranthesis.
		If all the paranthesis are matched, the given pair of paranthesis is valid otherwise it is not valid.

	If all the paranthesis are matched, the given pair of paranthesis is valid otherwise it is not valid.
	
	Edge Cases:
		What if there is no top element in stack when a closing bracket is found?
		This will happen for strings like "()]", where there is no opening bracket to compare with the ']' bracket. In such cases, the parantheis will be invalid.

	Approach:
		Initialize a stack that will store character data type (to store the opening brackets).
		
		Start traversing the given string one character at a time. For every opening bracket found, push it on top of the stack.
		
		For every closing bracket, take the top element (last opened bracket) of the stack (if it doesn't exit, return the string as invalid):
			If the opening and closing bracket matches, continue matching the string further.

			Otherwise, the string is invalid.
		Once all the characters are read from the input string, check if the stack is empty. If it is empty, all the paranthesis are balanced, otherwise unbalanced.

	Complexity Analysis:
		Time Complexity: O(N) (where N is the length of the string)
		Traversing the string once takes O(N) time.

		Space Complexity: O(N)
		In the worst case (when the string contains only opening brackets), the stack will store all the characters, taking O(N) space.
*/
import java.util.Stack;

class BalancedParanthesis {
    // Function to match the opening and closing brackets
    private boolean isMatched(char open, char close) {
       
        // Match
        if((open == '(' && close == ')') ||
           (open == '[' && close == ']') ||
           (open == '{' && close == '}')
        )
            return true;
           
        // Mismatch
        return false;
    }

    // Function to check if the string is valid 
    public boolean isValid(String str) {
       
        // Initialize a stack
        Stack<Character> st = new Stack<>();
       
        // Start iterating on the string
        for(int i=0; i < str.length(); i++) {
           
            // If an opening bracket is found
            if(str.charAt(i) == '(' || str.charAt(i) == '[' || 
               str.charAt(i) == '{') {
               
                // Push on top of stack
                st.push(str.charAt(i));
            }
           
            // Else if a closing bracket is found
            else {
                // Return false if stack is empty
                if(st.isEmpty()) return false;
               
                // Get the top element from stack
                char ch = st.peek();
                st.pop();
               
                // If the opening and closing brackets are not matched, return false
                if(!isMatched(ch, str.charAt(i))) return false;
            }
        }
       
        // If stack is empty, the string is valid, else invalid
        return st.isEmpty();
    }
   
    public static void main(String[] args) {
        String str = "()[{}()]";
       
        // Creating an instance of BalancedParanthesis class
        BalancedParanthesis sol = new BalancedParanthesis();
       
        // Function call to check if the string is valid
        boolean ans = sol.isValid(str);
       
        if(ans)
            System.out.println("The given string is valid.");
        else 
            System.out.println("The given string is invalid.");
    }
}
