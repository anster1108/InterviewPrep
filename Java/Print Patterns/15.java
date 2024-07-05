/*

O/P :

1
01
101
0101
10101

*/


import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 5;
        int start = 1;
        for (int i = 0; i < rows ; i++ ) {
            /* if i 
                odd  : start with 0
                even : start with 1
            */
            start = i % 2 == 0 ? 1 : 0;
            for (int j = 0; j <= i ; j++ ) {
                System.out.print(start);
                start = 1 - start;
            }
            System.out.println("");
        }
    }
}