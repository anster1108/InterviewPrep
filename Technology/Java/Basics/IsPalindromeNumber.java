// Question : Check if the number is Palindrome or not

import java.util.*;
import java.io.*;
import java.lang.*;

class IsPalindromeNumber{
	public static void main(String[] args) {
		int a = 121;
		int temp = a;
		int isPal = 0 ;
		while(temp != 0){
			isPal = (isPal * 10) + (temp % 10);
			temp = temp / 10;
		}


		if(isPal == a){
			System.out.println(a+" is a palindrome number");
		}else{
			System.out.println(a+" is not a palindrome number");
		}
	}
}