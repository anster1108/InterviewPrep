/*

O/P :

*
**
***
****
*****
****
***
**
* 

*/


import java.util.*;

class Main{
    public static void main(String[] args) {
        int n = 5;
        int m = 4;

        for (int i = 0; i < n ; i++ ) {
            for(int j = 0; j <= i; j++ ){
                System.out.print("*");
            }
            System.out.println("");
        }

        for (int i = 0; i < m ; i++ ) {
            for(int j = 0; j < m - i ; j++ ){
                System.out.print("*");
            }
            System.out.println("");
        }
    }
}