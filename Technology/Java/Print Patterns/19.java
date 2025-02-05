/*

O/P:

A B C D E
A B C D 
A B C
A B 
A

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 5;
        for (int i = 0; i < rows ; i++ ) {
            int alphabet = 65;
            for (int j = rows - i; j > 0 ; j-- ) {
                System.out.print((char)alphabet + " ");
                alphabet = alphabet + 1;
            }
            System.out.println("");
        }
    }
}