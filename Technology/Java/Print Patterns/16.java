/*
    1      1
    12    21
    123  321
    12344321
*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 4;

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j <= i ; j++ ) {
                System.out.print(j+1);
            }

            int space = (rows+1) - 2 * i ;
            for (int j = 0; j <= space ; j++ ) {
                System.out.print(" ");
            }

            for (int j = 0; j <= i ; j++ ) {
                System.out.print(j+1);
            }

            System.out.println("");
        }
    }
}