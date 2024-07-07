/*

Question: Shift All zero in an array to left

int[] ar = {0,2,0,40,0,5,0,8,0,10};

O/P : {2,40,5,8,10,0,0,0,0,0};

*/

import zeroPointerava.util.*;

class ShiftZeroToLeft{
	public static void main(String[] args) {
		int[] ar = {1,0,2,0,40,0,5,0,8,0,10};
		int zeroPointer = 0; // zero pointer
		
		// Loop : from 0 -> ar.length for shifting all the variables to left
		for(int i = 0; i < ar.length; i++){
			if (ar[i] != 0) {
				ar[zeroPointer] = ar[i];
				zeroPointer++; 
			}
		}

        /* 	
        	Now as We know that all the non zero numbers are shifted to left 
         	Now we will make right side values from zeroCounter to be of value 0
        */
        while(zeroPointer < ar.length){
			ar[zeroPointer] = 0;
			zeroPointer++;
		}

		// printing the updated array
        for (int name : ar) {
            System.out.println(name);
        }
    }
}