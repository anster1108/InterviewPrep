/*

Question: Sum opf n numbers

*/

import java.util.*;

class SumOfNumber{
	public static void main(String[] args) {
		int num = 5;
		int sum = rec(num);
		System.out.println("Sum of given number: "+ sum);
	}

	public static int rec(int num){
		if(num < 1){
			return num;
		}
		int sum = num + rec(num - 1);
		return sum;
	}
}