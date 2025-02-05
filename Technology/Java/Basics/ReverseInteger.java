/*
Question : reverse the given integer

Input :  12345
Output : 54321


// these are those numbers whose cube is same as of the number
// 371 =  (3*3*3) + (7*7*7) + (1*1*1) = 371 [thus its a armstrong number]

*/

import java.util.*;

class ReverseInteger{
	public static void main(String[] args) {
		int num = 12345;
		int rev = 0;
		while(num > 0){
			rev = (rev * 10) + (num % 10);
            num = num / 10;
		}
		System.out.println("Given Number's reverse number will be "+rev);
	}
}