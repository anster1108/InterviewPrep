/*

Question : Print number from number to max

Question : Print number from max to number

*/

import java.util.*;

class PrintNumerWithLimit {
	public static void main(String[] args) {
		int num = 3, max = 12;
        rec1(num, max);
	}

	public static void rec(int num, int max){
		if (num == max) {
			return;
		}
		System.out.println(num);
		rec(num + 1,  max);
	}

	public static void rec1(int num, int max){
		if (num == max) {
			return;
		}
		System.out.println(max);
		rec1(num,  max - 1);
	}
}