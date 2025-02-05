/*

O/P:

0 |        A
1 |      A B A    
2 |    A B C B A  
3 |  A B C D C B A

rows : 4

space    { 3, 2 , 1, 0 } [ rows - i - 1 ]
alphabet { 1, 3, 5, 7 }  [ 2i + 1 ] [Alphabet logic : when j reaches the breakpoint we will subtract from alphabhet not add ]
space    { 3, 2 , 1, 0 } [ rows - i - 1 ]


*/

import java.util.*;

class Main{
	public static void main(String[] arg){
		int rows = 4;
		for (int i = 0; i < rows ; i++ ) {
			for (int j = 0; j < rows - i - 1 ; j++ ) {
				System.out.print(" ");
			}

			int alphabet = 65;
			int iter = 2 * i + 1;
			int breakpoint = i ;
			for (int j = 0; j < iter ; j++ ) {
				System.out.print((char)alphabet);
				if (j >= breakpoint) {
					alphabet = alphabet - 1;
				}else{
					alphabet = alphabet + 1;
				}
			}

            for (int j = 0; j < rows - i - 1 ; j++ ) {
				System.out.print(" ");
			}
			System.out.println("");
		}
	}
}