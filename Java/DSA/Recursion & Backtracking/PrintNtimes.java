/*

Question : Print a given number N times

*/

import java.util.*;

class PrintNtimes {
	public static void main(String[] args) {
		int num = 3, times = 12;
        rec(num, times);
	}

	public static void rec(int num, int times){
		if (times == 0) {
			return;
		}
		System.out.println(num);
		rec(num,  times - 1);
	}
}