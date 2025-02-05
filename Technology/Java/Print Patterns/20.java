/*

O/P:

A
B B
C C C
D D D D
E E E E E

*/

import java.util.*;

class Main{
	public static void main(String[] arg){
		int rows = 5;
		int alphabet = 65;
		for (int i = 0; i < rows ; i++ ) {
			for (int j = 0; j <= i ; j++ ) {
				System.out.print((char)alphabet+" ");
			}
            alphabet = alphabet + 1;
			System.out.println("");
		}
	}
}