/*

Question: Factorial of n

*/

import java.util.*;

class Factorial{
	public static void main(String[] args) {
		int num = 5;
		int fact = rec(num);
		System.out.println("Factorial of given number: "+ fact);
	}

	public static int rec(int num){
		if(num == 1){
			return num;
		}
		int fact = num * rec(num - 1);
		return fact;
	}
}