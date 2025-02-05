/*

O/P:

0 | E
1 | D E
2 | C D E
3 | B C D E
4 | A B C D E

rows : 5
alpha strt : 65 + rows - i - 1

*/

import java.util.*;

class Main{
    public static void main(String[] arg){
        int rows = 5;
        for (int i = 0; i < rows ; i++ ) {
            int alphabet = 65;
            alphabet = alphabet + rows - i - 1;
            for (int j = 0; j <= i ; j++ ) {
                System.out.print((char)alphabet +" ");
                alphabet = alphabet + 1;
            }
            System.out.println("");
        }
    }
}