/*

O/P :

1
12
123
1234
12345

*/

import java.util.*;

class Main{
	public static void main(String[] args) {
		int n = 5;
		for (int i = 0; i < n ; i++ ) {
			for(int j = 0; j <= i ; j++){
				System.out.print(j+1);
			}
			System.out.println();
		}
	}
}