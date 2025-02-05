/*

O/P :

***********
 ********* 
  *******  
   *****   
    ***    
     *     

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 6;
        for (int i = 0; i < rows ; i++ ) {
            int stars = 2*(rows-i) - 1;
            int spaces = i ;

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }

            for (int j = 0; j < stars ; j++ ) {
                System.out.print("*");
            }

            for (int j = 0; j < spaces ; j++ ) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}