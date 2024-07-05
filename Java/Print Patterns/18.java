/*

O/P:

A
A B
A B C
A B C D
A B C D E

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 5;

        for (int i = 0; i < rows ; i++ ) {
            int alphabet = 65;
            for (int j = 0; j <= i ; j++ ) {
                System.out.print((char)alphabet + " ");
                alphabet = alphabet + 1;
            }
            System.out.println("");
        }
    }
}