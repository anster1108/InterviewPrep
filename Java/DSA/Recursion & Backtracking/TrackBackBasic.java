/*

Question : Backtrack from 1 -> N

I/P : num = 4
O/P :
		1
		2
		3
		4

*/

import java.util.*;

class TrackBackBasic {
	public static void main(String[] args) {
		int num = 12;
        backTrack(num);
	}

	public static void backTrack(int num){
		if (num == 0) {
			return;
		}
		backTrack(num - 1);
		System.out.println(num);
	}
}