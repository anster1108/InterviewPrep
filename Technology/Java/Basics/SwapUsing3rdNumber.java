// Question : Write a program to swap two numbers using 3rd number

import java.lang.*;

class SwapUsing3rdNumber{
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		System.out.println("Before Swapping values of a: "+a+", b: "+b);
		int temp;
		temp = a;
		a = b;
		b = temp;
		System.out.println("After Swapping values of a: "+a+", b: "+b);
	}
}