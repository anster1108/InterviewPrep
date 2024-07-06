/*

Question : check if the given String is palindrome or not

Input : madam

Output : is a palindrome

*/

import java.util.*;

class PalindromeString {
	public static void main(String[] args) {
		String st = "madam";
		boolean isPalindrome = rec(st, 0 , st.length() -1);

		if (isPalindrome) {
			System.out.println("Given String is Palindrome");
		}else{
			System.out.println("Given String is not Palindrome");
		}
	}

	public static boolean rec(String st, int i, int j){
		if (i == j) {
			return true;
		}
		
		if (st.charAt(i) != st.charAt(j)) {
			return false;
		}

		return rec(st, i+1, j-1);
	}
}