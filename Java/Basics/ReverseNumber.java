// Question : Reverse a number

import java.lang.*;

class ReverseNumber{
	public static void main(String[] args){
		int i = 12345;
		int rev = 0;
		while(i != 0){
			rev = (rev * 10) + (i % 10);
            i = i / 10;
		}
		System.out.println("Reverse Number is "+ rev);
	}
}