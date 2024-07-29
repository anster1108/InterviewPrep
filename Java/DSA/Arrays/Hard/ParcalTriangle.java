/*

ParcalTriangle : 
							| Rows
	      1 				| 1	
	     1  1 				| 2
	   1  2   1				| 3
    1   3   3   1			| 4	
  1  4   6   4   1 			| 5
1   5  10   10  5   1 		| 6


There are 3 basic question from this Pascal triangle 

Q1. Given the row and column number print the element
	Row = 5 , Column : 3 
	O/P: 6
Q2. Print the given row, where row is given 
	Row :  5
	O/P: 1   5  10   10  5   1

Q3. Print the whole pascal triagnle tillgiven row
	Row : 3
	0/P : 
							| Rows
	      1 				| 1	
	   1  2   1				| 2
    1   3   3   1			| 3	


Question 1 Soltion : 

		Formulas : 

		Brute Force : 
			-> If we are given the row : R
			-> If we are given the row : C

			we will subtract by 1 , so Row : R - 1 & Column : C - 1

			Now we will apply it to combination formula of nCr (row C column) =       n!
																				 -------------
																				 r! * (n - r)!

																 		where n = R-1 & r = C-1

					So, for Question 1. : Row = 5 , Column : 3
					Solution : 4C2 = 4*3*2*1 / (2*1) (2*1)  => 6 [Output] 

		Better :
		So to make it more easier

		nCr =          n!				10 C 2 => 10 * 9 / 2*1 = 45
				 -------------    => 
				 r! * (n - r)!

		So as per the conclusion,  the n umeratior will only got till the column tahts why = 10 * 9
		and the denominator will stay with only , r! , i.e, 2 * 1

		so numerator will be working witha a loop till r : 10( 1st iteration ) , 9( 2nd iteration )

		colclusion , 10/1 * 9/2


		Func NCR(Row r, Column c){
			result = 1
			for(i = 0 : i < c, i++){
				res = res * (r - 1); // res * (10 - 0), res * (10 - 1)
				res = res / (i+1);   // res * (10 - 0) / (0+1) , res * (10 - 1) / (1+1) // 10/1 * 9/2 
			}

			return res;
		}

		Time Complexity = O(c)

		Note : Take Datatype to be long

Question 2 : Given the row number print me the whole row :
Row = 5

Solution : 
r = 5

Brute Force : 
	for(c = 1 : c <= r, c++){
		SOP(NCR(r - 1, c-1));
	}

	Time Complexity = O(r) * O(c)


Better : 

ROW = 6

O/P :  1   5  10   10   5   1 
INDEX: 0   1   2    3   4   5

Observation : First and last element is 1 at any how.

	Considering 1st element as 1, and print others with a formula , 
		O/P :  1   5  10   10   5   1 
		5 = 5 / 1
		10 = 5 * 4 / 1 * 2
		10 = 5 * 4 * 3 / 1 * 2 * 3
		5 = 5 * 4 * 3 * 2 / 1 * 2 * 3 * 2
		1 = 5 * 4 * 3 * 2 * 1 / 1 * 2 * 3 * 2 * 1

		So, formula will be 

		ans = 1
		SOP(1);
		for( i = 1: i < row; i++ ){
			ans = ans * (r-i);
			ans = ans / i
			SOP(ans);
		}
	
	Time Complexity = O(r)


Question 3 : Print the whole triangle with given row

This will be same as above, and printing eachb row till nth row


*/

import java.util.*;

class ParcalTriangle{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		List<List<Integer>> pascalTriangle = pascalTriangle(n);
		for (List<Integer> it : pascalTriangle) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
	}

	public static List<List<Integer>> pascalTriangle(int row){
		List<List<Integer>> pascalTriangle = new ArrayList<>();
		for (int i = 0; i < row ; i++) {
			pascalTriangle.add(getPascalTriangleRow(i));
		}
		return pascalTriangle;
	}

	public static List<Integer> getPascalTriangleRow(int row){
		List<Integer> ansRow = new ArrayList<>();
		long ans = 1;
		ansRow.add(ans); //inserting the 1st element
		for (int col = 1; col <= row ; col++) {
			ans = ans * (row - col);
			ans = ans * col;
		}
		return ansRow;
	}
}