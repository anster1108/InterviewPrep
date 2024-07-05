/*

O/P:

****
*  *
*  *
****


rows = 4

we are printing stars on the boundary, thus when i == 0 , j == 0, j == row - 1, i == row - 1

*/

import java.util.*;

class Main{
    public static void main(String[] args) {
        int rows = 4;
        for (int i = 0 ; i < rows ; i++ ) {
        	for (int j = 0 ; j < rows ; j++ ) {
        		if(i == 0 || j == 0 || i == rows-1 || j == rows-1){
        			System.out.print("*");
        		}else{
        			System.out.print(" ");
        		}
        	}
        	System.out.println("");
        }
    }
}