/*
A
AB
ABC
ABCD
ABCDE
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
		int n = 5;

		for (int i=1; i <= 5  ; i++ ) {
			int a = 65;
			for(int j = 0; j < i; j++ ){
				System.out.print((char)a);
				a = a+1;
			}
			System.out.println();
		}
	}
}