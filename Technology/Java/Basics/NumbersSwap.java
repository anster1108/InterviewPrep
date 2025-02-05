// Question : Write a program to swap two numbers without using 3rd number

import java.lang.*;
import java.util.*;
import java.io.*;

class NumbersSwap{
	public static void main(String[] args) {
		int a = 10;
		int b = 5;
		System.out.println("Before Swapping values of a: "+a+", b: "+b);
		a = a + b;
		b = a - b;
		a = a - b; 
		System.out.println("After Swapping values of a: "+a+", b: "+b);
	}
}