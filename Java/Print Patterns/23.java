/*

O/P:

**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********


Split this to two parts

1)

**********
****  ****
***    ***
**      **
*        *

rows = 5

stars { 5, 4, 3, 2, 1 }  [ row - i ]
space { 0, 2 , 4, 6, 8 } [ 2i ]
stars { 5, 4, 3, 2, 1 }  [ row - i ]

2. 

*        *
**      **
***    ***
****  ****
**********

rows = 5

stars { 1, 2, 3, 4, 5 }  [ i + 1 ]
space { 8, 6, 4, 2, 0 }  [ 2(rows - i - 1) ]
stars { 1, 2, 3, 4, 5 }  [ i + 1 ]

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows ; i ++ ) {
            for(int j = 0; j < rows - i ;j++){
                System.out.print("*");
            }

            for(int j = 0; j < 2*i ;j++){
                System.out.print(" ");
            }

            for(int j = 0; j < rows - i ;j++){
                System.out.print("*");
            }
            System.out.println(""); 
        }

        for (int i = 0; i < rows ; i ++ ) {
            for(int j = 0; j < i + 1 ;j++){
                System.out.print("*");
            }

            for(int j = 0; j < 2*(rows - i - 1) ;j++){
                System.out.print(" ");
            }

            for(int j = 0; j < i + 1 ;j++){
                System.out.print("*");
            }
            System.out.println(""); 
        }
    }
}