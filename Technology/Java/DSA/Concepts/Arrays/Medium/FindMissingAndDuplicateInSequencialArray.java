/*
Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.

Example 1:
Input Format
:  array[] = {3,1,2,5,3}
Result
: {3,4)
Explanation
: A = 3 , B = 4 
Since 3 is appearing twice and 4 is missing

Example 2:
Input Format
: array[] = {3,1,2,5,4,6,7,5}
Result
: {5,8)
Explanation
: A = 5 , B = 8 
Since 5 is appearing twice and 8 is missing

Brute Force : 

	Approach:
	The steps are as follows:

	We will run a loop(say i) from 1 to N.
	For each integer, i, we will count its occurrence in the given array using linear search.
	We will store those two elements that have the occurrence of 2 and 0.
	Finally, we will return the elements.

	Code: 

		public static int[] findMissingRepeatingNumbers(int[] a) {
		    int n = a.length; // size of the array
		    int repeating = -1, missing = -1;

		    //Find the repeating and missing number:
		    for (int i = 1; i <= n; i++) {
		        //Count the occurrences:
		        int cnt = 0;
		        for (int j = 0; j < n; j++) {
		            if (a[j] == i) cnt++;
		        }

		        if (cnt == 2) repeating = i;
		        else if (cnt == 0) missing = i;

		        if (repeating != -1 && missing != -1)
		            break;
		    }
		    int[] ans = {repeating, missing};
		    return ans;
		}


	Time Complexity: O(N2), where N = size of the given array.
	Reason: Here, we are using nested loops to count occurrences of every element between 1 to N.

	Space Complexity: O(1) as we are not using any extra space.

Better : 

	Approach: Hashing 

	Instead of counting the occurrences every time, using the hashing technique, we will store the frequency of each element between 1 to N. Now, the element with frequency 2 will be the repeating number and the element with frequency 0 will be the missing number.

	Note: Here, we can solve this problem using a hash array.

	Approach:
	The steps are as follows:

	The range of the number is 1 to N. So, we need a hash array of size N+1 (as we want to store the frequency of N as well).
	We will iterate all the elements of the given array and update the hash array accordingly i.e. hash[a[i]] = hash[a[i]]+1.
	Now, we will iterate on the hash array and return the two elements with frequencies 2 and 0.
	Note: For a better understanding of intuition, please watch the video at the bottom of the page.

	Code : 
		public static int[] FindMissingAndDuplicate(int[] a){
			int n = a.length; // size of the array
	        int[] hash = new int[n + 1]; // hash array
	        for (int val : a) {
	        	hash[val]++;
	        }

	        int repeating = -1, missing = -1;
	        for (int i = 1; i <= n ; i++) {
	        	if (hash[i] == 0) {
	        		missing = i;
	        	}else if(hash[i] == 2){
	        		repeating = i;
	        	}
	        }

	        int[] ans = {repeating, missing};
	        return ans;
		}

	Time Complexity: O(2N), where N = the size of the given array.
	Reason: We are using two loops each running for N times. So, the time complexity will be O(2N).

	Space Complexity: O(N) as we are using a hash array to solve this problem.


Optimal : 
	As we know that, the numbers present in the array are consecutive,i.e, 1,2,3,4,5,6, ......n
	and one is missing and another is repeating

	So, we will solve this by maths linear equation as we have 2 things to find, 

	Assume the repeating number to be X and the missing number to be Y.
	
	 int[] a = {3, 1, 2, 5, 4, 6, 7, 5}; // length : 8
	
	In the array, the numbers are between 1 to N, and in that range, one number is missing and one number is occurring twice.
	Step 1: Form equation 1:
	 sum of N number : Sn = n * (n+1) / 2

	 Let’s say, S = the summation of all the elements in the given array.

	 S - Sn = (3 + 1 + 2 + 5 + 4 + 6 + 7 + 5) - (1 + 2 + 3 + 4 + 5 + 6 + 7 + 8) = 5 - 8 [ where 5 is rep[eating number & 8 is missing number ]
	 So we can say, S - Sn = X - Y = -3 ....(Equation 1)

	Step 2: Form equation 2:
	 sum of Square on N numbers : S2n = (N*(N+1)*(2N+1))/6
	 Let’s say, S2 = the summation of squares of all the elements in the given array.

	 S2 - S2n = (3^2 + 1^2 + 2^2 + 5^2 + 4^2 + 6^2 + 7^2 + 5^2) - (1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2 + 7^2 + 8^2) = 5^2 - 8^2 = 

	 Therefore, S2-S2n = X^2 - Y^2...................equation 2


	 Solving 2nd equations , X^2 - Y^2 = (X+Y)*(X-Y) // putting equation 1 here
	 (X+Y)*(-3) = -39, X+Y = 13 

	 So, X + Y = 13 & X - Y = -3 [ repeating number to be X and the missing number to be Y. ]

	  Adding both, X + Y + X - Y = -3 + 13 => 2 X = 10 => X = 5 so Y = 8


*/


import java.util.*;

class FindMissingAndDuplicateInSequencialArray{
	 public static long[] FindMissingAndDuplicate(long[] a){
		long n = a.length; // size of the array
		long SN = n*(n+1) / 2;
		long S2N = (n*(n+1)*(2*n+1))/6;
        
        // For Equation 1 
        long S = 0;
        long S2 = 0;
        for (long val : a) {
        	S += val;
        	S2 +=  val * val;
        }

        //S-Sn = X-Y:
        long val1 = S - SN;

        // S2-S2n = X^2-Y^2:
        long val2 = S2 - S2N;
        
        //Find X+Y = (X^2-Y^2)/(X-Y):
        val2 = val2 / val1;

        //Find X and Y: X = ((X+Y)+(X-Y))/2 and Y = X-(X-Y),
        // Here, X-Y = val1 and X+Y = val2:
        long x = (val1 + val2) / 2;
        long y = x - val1;

        long[] ans = {x, y};
        return ans;
	}

	public static void main(String[] args) {
		long[] a = {3, 1, 2, 5, 4, 6, 7, 5};
		long[] ans = FindMissingAndDuplicate(a);
		System.out.println("The repeating and missing numbers are: {"+ ans[0] + ", " + ans[1] + "}");
	}
}