/*
	Question : Given an input string as an array of characters, write a function that reverses the string.

	Example 1
		Input : s = ["h", "e", "l", "l", "o"]
		Output : ["o", "l", "l", "e", "h"]
		Explanation : The given string is s = "hello" and after reversing it becomes s = "olleh".

	Example 2
		Input : s = ["b", "y", "e" ]
		Output : ["e", "y", "b" ]
		Explanation : Explanation : The given string is s = "bye" and after reversing it becomes s = "eyb".
*/

class ReverseStringArray{
	public static void main(String[] args) {
        Vector<Character> s = new Vector<>();
        s.add('h');
        s.add('e');
        s.add('l');
        s.add('l');
        s.add('o');
        
        // Function call to reverse the given string
        Vector<Character> reversed = reverseString(s);
        System.out.println(reversed);
    }

	/* Recursive function to reverse the 
    string character by character */
    private static void reverse(Vector<Character> s, int left, int right) {
        
        // Base case
        if (left >= right) return;
        
        // Swap characters at left and right positions
        char temp = s.get(left);
        s.set(left, s.get(right));
        s.set(right, temp);
        
        // Recursive call with updated indices
        reverse(s, left + 1, right - 1);
    }
    
    // Function to reverse the given string
    public static Vector<Character> reverseString(Vector<Character> s) {
        int left = 0;
        int right = s.size() - 1;
        reverse(s, left, right);
        return s;
    }
}