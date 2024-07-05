// Question : Factorial of a number

import java.io.*;
import java.util.*;
import java.lang.*;

class Main{
	public static void main(String[] args) {
		int a = 5;
		int fact = 1;
		for (int i = a; i > 0 ; i-- ) {
			fact = fact * i;
		}
		System.out.println("Factorial of "+a+" is "+ fact);
	}
}