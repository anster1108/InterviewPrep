/*

O/P :

    *    
   ***   
  *****  
 ******* 
*********
 ******* 
  *****  
   ***   
    *    

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int n = 5;
        int m = 4;
        int spaces = 0, stars = 0;

        for (int i = 0; i < n ; i++ ) {
            spaces = n - i - 1;
            stars = 2 * i + 1;

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }

            for (int j = 0; j < stars ; j++ ) {
                System.out.print("*");
            }

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }
            System.out.println("");
        }

        for (int i = 0; i < m ; i++ ) {
            spaces = i + 1;
            stars = 2 * (m - i) - 1;

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }

            for (int j = 0; j < stars ; j++ ) {
                System.out.print("*");
            }

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}