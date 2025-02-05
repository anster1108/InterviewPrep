/*
A
BA
CBA
DCBA
EDCBA
*/

import java.util.*;

class Main{
	public static void main(String[] args) {
		int n = 5;
		for (int i = 0;i < n; i ++) {
			int a = 65 + i;
			for (int j = 0; j <= i ; j++ ) {
				System.out.print((char) a);
				a = a - 1;
			}
			System.out.println();
		}
	}
}