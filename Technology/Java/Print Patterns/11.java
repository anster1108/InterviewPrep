/*

O/P :

    *    
   ***   
  *****  
 ******* 
*********

*/

import java.util.*;

class Main{
	public static void main(String[] args) {
		int n = 5;
		for (int i = 0; i < n ; i++ ) {
			
			int spaces = n - i - 1;
			
			int stars = (2 * i) + 1 ;
			
			for (int j = 0; j < spaces ; j++ ) {
				System.out.print(" ");
			}
			
			for (int j = 0; j < stars ; j++ ) {
				System.out.print("*");
			}

			for (int j = 0; j < spaces ; j++ ) {
				System.out.print(" ");
			}
			
			// for new line
			System.out.println();
		}
	}
}