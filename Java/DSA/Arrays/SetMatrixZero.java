/*
	Question : Given a matrix if an element in the matrix is 0 then you will have to set its entire column 
			   and row to 0 and then return the matrix.

	BruteForce : Time Complexity = O(N^3)
				Approach and pseudocode : 
					1. Iterate over the matrix from 0,0 -> n,m
					2. If we find any zero, update the columns and rows to be -1 & not updating 0, if it is present in the same row or column
					3. We will perform step 2 for every cell containing 0.
					4. Finally, we will mark all the cells containing -1 with 0.
					Thus the given matrix will be modified according to the question.

				Note: Here, we are assuming that the matrix does not contain any negative numbers. But if it contains negatives,
				 we need to find some other ways to mark the cells instead of marking them with -1.

			Code : 

				import java.util.*;

				public class tUf {
				    static void markRow(ArrayList<ArrayList<Integer>> matrix, int n, int m, int i) {
				        // set all non-zero elements as -1 in the row i:
				        for (int j = 0; j < m; j++) {
				            if (matrix.get(i).get(j) != 0) {
				                matrix.get(i).set(j, -1);
				            }
				        }
				    }

				    static void markCol(ArrayList<ArrayList<Integer>> matrix, int n, int m, int j) {
				        // set all non-zero elements as -1 in the col j:
				        for (int i = 0; i < n; i++) {
				            if (matrix.get(i).get(j) != 0) {
				                matrix.get(i).set(j, -1);
				            }
				        }
				    }

				    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
				        // Set -1 for rows and cols that contains 0. Don't mark any 0 as -1:
				        for (int i = 0; i < n; i++) {
				            for (int j = 0; j < m; j++) {
				                if (matrix.get(i).get(j) == 0) {
				                    markRow(matrix, n, m, i);
				                    markCol(matrix, n, m, j);
				                }
				            }
				        }
				        // Finally, mark all -1 as 0:
				        for (int i = 0; i < n; i++) {
				            for (int j = 0; j < m; j++) {
				                if (matrix.get(i).get(j) == -1) {
				                    matrix.get(i).set(j, 0);
				                }
				            }
				        }
				        return matrix;
				    }

				    public static void main(String[] args) {
				        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
				        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
				        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
				        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

				        int n = matrix.size();
				        int m = matrix.get(0).size();

				        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

				        System.out.println("The Final matrix is: ");
				        for (ArrayList<Integer> row : ans) {
				            for (Integer ele : row) {
				                System.out.print(ele + " ");
				            }
				            System.out.println();
				        }
				    }
				}

	Better : Time Complexity = O(2*n*m) Space Complexity = O(N) + O(M)
		Approach and pseudocode : 
			We will take 2 arrays, one of length n and another m
			col[m] = {0} & row[n] = 0
			1. Iterate over the matrix and as we find the zero update the above array, row and colmn
			2. once array is poppulated , iterate over the matrix and check if the row or column matrix are 1, if yes update the element

		col[m] = {0} & row[n] = {0}
		Iterate over the matrix
		for(int i = 0; i < n ; i++){
			for(int j = 0; j < m ; j++){
				if(a[i][j] == 0){
					col[j] = 1;
					row[i] = 1;
				}
			}
		}

		for(int i = 0; i < n ; i++){
			for(int j = 0; j < m ; j++){
				if(row[i] == 1 || col[j] == 1){
					a[i][j] = 0;
				}
			}
		}
	
	Optimal Approach =  Time Complexity = O(2*n*m) Space Complexity = O(1)
	
	Approach and pseudocode : 
		In the previous approach, the time complexity is minimal as the traversal of a matrix takes at least O(N*M)(where N = row and M = column).
		In this approach, we can just improve the space complexity. 

		So, instead of using two extra matrices row and col, we will use the 1st row and 1st column of the given matrix to keep a track of the cells that need to be marked with 0. 
		But here comes a problem. If we try to use the 1st row and 1st column to serve the purpose, the cell matrix[0][0] is taken twice. 
		To solve this problem we will take an extra variable col0 initialized with 1. Now the entire 1st row of the matrix will serve the purpose of the row array. 
		And the 1st column from (0,1) to (0,m-1) with the col0 variable will serve the purpose of the col array.


		The steps are as follows:

		1. First, we will traverse the matrix and mark the proper cells of 1st row and 1st column with 0 accordingly. The marking will be like this: if cell(i, j) contains 0, we will mark the i-th row i.e. matrix[i][0] with 0 and we will mark j-th column i.e. matrix[0][j] with 0.
			If i is 0, we will mark matrix[0][0] with 0 but if j is 0, we will mark the col0 variable with 0 instead of marking matrix[0][0] again.
		2. After step 1 is completed, we will modify the cells from (1,1) to (n-1, m-1) using the values from the 1st row, 1st column, and col0 variable.
		We will not modify the 1st row and 1st column of the matrix here as the modification of the rest of the matrix(i.e. From (1,1) to (n-1, m-1)) is dependent on that row and column.
		3. Finally, we will change the 1st row and column using the values from matrix[0][0] and col0 variable. Here also we will change the row first and then the column.
		If matrix[0][0] = 0, we will change all the elements from the cell (0,1) to (0, m-1), to 0.
		If col0 = 0, we will change all the elements from the cell (0,0) to (n-1, 0), to 0.

*/


class SetMatrixZero{
	public static void main(String[] args) {
		static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m) {
	        // int[] row = new int[n]; --> matrix[..][0]
	        // int[] col = new int[m]; --> matrix[0][..]

	        int col0 = 1;
	        // step 1: Traverse the matrix and
	        // mark 1st row & col accordingly:
	        for (int i = 0; i < n; i++) {
	            for (int j = 0; j < m; j++) {
	                if (matrix.get(i).get(j) == 0) {
	                    // mark i-th row:
	                    matrix.get(i).set(0, 0);

	                    // mark j-th column:
	                    if (j != 0)
	                        matrix.get(0).set(j, 0);
	                    else
	                        col0 = 0;
	                }
	            }
	        }

	        // Step 2: Mark with 0 from (1,1) to (n-1, m-1):
	        for (int i = 1; i < n; i++) {
	            for (int j = 1; j < m; j++) {
	                if (matrix.get(i).get(j) != 0) {
	                    // check for col & row:
	                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
	                        matrix.get(i).set(j, 0);
	                    }
	                }
	            }
	        }

	        //step 3: Finally mark the 1st col & then 1st row:
	        if (matrix.get(0).get(0) == 0) {
	            for (int j = 0; j < m; j++) {
	                matrix.get(0).set(j, 0);
	            }
	        }
	        if (col0 == 0) {
	            for (int i = 0; i < n; i++) {
	                matrix.get(i).set(0, 0);
	            }
	        }

	        return matrix;
	    }

	    public static void main(String[] args) {
	        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
	        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
	        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
	        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

	        int n = matrix.size();
	        int m = matrix.get(0).size();

	        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

	        System.out.println("The Final matrix is: ");
	        for (ArrayList<Integer> row : ans) {
	            for (Integer ele : row) {
	                System.out.print(ele + " ");
	            }
	            System.out.println();
	        }
	    }
	}
}