/*

Question : check if the given String is palindrome or not

Input : madam

Output : is a palindrome

*/

import java.util.*;

class PalindromeString {
	public static void main(String[] args) {
		String st = "madam";
		boolean isPalindrome = isPalindrome(st, 0 , st.length() -1);

		if (isPalindrome) {
			System.out.println("Given String is Palindrome");
		}else{
			System.out.println("Given String is not Palindrome");
		}
	}
	
	public static boolean isPalindrome(String s, int left, int right){
		if(left >= right){
		return true;
		}

		if (s.charAt(left) != s.charAt(right)) {
		    return false;
		}

        return isPalindrome(s, left + 1, right - 1);
    }
}