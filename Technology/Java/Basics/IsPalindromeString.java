// Question : Check if the String is Palindrome or not

import java.util.*;

class IsPalindromeString{
	public static void main(String[] args) {
		String s = "aabbaaa";
		boolean isPalindrome = true;
        int left = 0;
        int right = s.length() - 1;
        while(right > left){
            if(s.charAt(left) != s.charAt(right)){
                isPalindrome = false;
                break;
            }
            right -= 1;
            left += 1;
        }


		if(isPalindrome){
			System.out.println(s+" is a palindrome");
		}else{
			System.out.println(s+" is not a palindrome");
		}
	}
}