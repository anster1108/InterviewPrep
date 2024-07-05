// Question : Print the Table of the given Number

import java.util.*;
import java.io.*;
import java.lang.*;

class Main{
	public static void main(String[] args) {
		int tableNumber = 5;
		for (int i = 1; i <= 10 ; i++ ) {
			int num = tableNumber * i;
			System.out.println(tableNumber + " x "+ i+" = "+num);
		}
	}
}