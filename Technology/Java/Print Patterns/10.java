/*

O/P :

12345
1234
123
12
1

*/


import java.util.*;

class Main{
	public static void main(String[] args) {
		int n = 5;
		for (int i = 0; i < n ; i++ ) {
            int a = 1;
			for (int j = n; j > i ; j-- ) {
				System.out.print(a);
				a = a + 1;
			}
			System.out.println();
		}
	}
}