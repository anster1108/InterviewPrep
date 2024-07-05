// Question : Find the LCM , HCF[GCD] of two numbers

import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	public static void main(String[] args) {
		int a = 72;
		int b = 144;
		int lcm = findLCM(a, b);
		System.out.println("LCM of "+a+", "+b+" is: "+lcm);
	}

	public static int findLCM(int a, int b){
		 // Handle negative inputs (LCM of negative numbers is undefined)
        if (a < 0 || b < 0) {
            return -1;
        }

        // Find the GCD using Euclidean Algorithm
        int gcd = findGCD(a, b);

        // LCM is calculated as (a * b) / GCD
        return (a * b) / gcd;
	}

	public static int findGCD(int a, int b){
		if (b == 0) {
			return a;
		}

		return findGCD(b, a%b);
	}

}