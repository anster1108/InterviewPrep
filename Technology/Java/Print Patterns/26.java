/*

O/P:

j   | 0 1 2 3 4 5 6
-------------------
i 	| - - - - - - -
0	| 4 4 4 4 4 4 4
1	| 4 3 3 3 3 3 4
2	| 4 3 2 2 2 3 4
3	| 4 3 2 1 2 3 4 
4	| 4 3 2 2 2 3 4
5	| 4 3 3 3 3 3 4
6	| 4 4 4 4 4 4 4


rows : 4

loop : loop : i from 0 -> 2rows - 1 (till 7)

top		=> i [ element distance from top ]
left	=> j [ element distance from left ]
bottom  => 2*(row - 1) - i [ element distance from bottom ]
right	=> 2*(row - 1) - j [ element distance from bottom ]

int num = rows - Math.min(Math.min(top, bottom), Math.min(right, left));

*/

import java.util.*;

class Main{
	public static void main(String[] args) {
		int rows = 4;

		for (int i = 0; i < (2*rows - 1) ; i++) {
			for (int j = 0; j < (2*rows - 1) ; j++) {
				int top = i;
				int left = j;
				int bottom = 2*(rows - 1) - i;
				int right = 2*(rows - 1) - j;
				int num = rows - Math.min(Math.min(top, bottom), Math.min(left, right));
				System.out.print(num);
			}
			System.out.println("");
		}
	}
}

