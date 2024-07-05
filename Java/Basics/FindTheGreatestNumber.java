// Question : Find the greater number from 3 variables using nested if else

import java.util.*;
import java.io.*;
import java.lang.*;

class Main{
	public static void main(String[] args) {
		int a = 21;
		int b = 9;
		int c = 239;

		if (a > b) {
			if (a > c) {
				System.out.println("a is greater than b & c");
			}else{
				System.out.println("c is greater than b & a");
			}
		}else{
			if (b > c) {
				System.out.println("b is greater than a & c");
			}else{
				System.out.println("c is greater than a & b");
			}
		}
	}
}