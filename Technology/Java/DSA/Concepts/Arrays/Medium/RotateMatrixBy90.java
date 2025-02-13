/*
	Question : Given a matrix for size n, your task is to rotate the matrix 90 degrees clockwise.
	Example 1:
	Input: [[1,2,3],[4,5,6],[7,8,9]]

	Output: [[7,4,1],[8,5,2],[9,6,3]]
	
	Explanation: Rotate the matrix simply by 90 degree clockwise and return the matrix.
	
	Brute Force : Time Complexity: O(N*N).
				  Space Complexity: O(N*N).
		
		Approach: Take another dummy matrix of n*n, and then take the first row of the matrix and put it in the last column of the dummy matrix, 
				  take the second row of the matrix, and put it in the second last column of the matrix and so.


		import java.util.*;
		class RotateMatrixBy90 {
		    static int[][] rotate(int[][] matrix) {
		        int n = matrix.length;
		        int rotated[][] = new int[n][n];
		        for (int i = 0; i < n; i++) {
		            for (int j = 0; j < n; j++) {
		                rotated[j][n - i - 1] = matrix[i][j];
		            }
		        }
		        return rotated;
		    }

		    public static void main(String args[]) {
		        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		        int rotated[][] = rotate(arr);
		        System.out.println("Rotated Image");
		        for (int i = 0; i < rotated.length; i++) {
		            for (int j = 0; j < rotated.length; j++) {
		                System.out.print(rotated[i][j] + " ");
		            }
		            System.out.println();
		        }

		    }
		}


		
	Optimal : 

		Intuition: By observation, we see that the first column of the original matrix is the reverse of the first row of the rotated matrix, so that’s why we transpose the matrix and then reverse each row, and since we are making changes in the matrix itself space complexity gets reduced to O(1).

		Approach:

		Step 1: Transpose the matrix. (transposing means changing columns to rows and rows to columns)

		Step 2: Reverse each row of the matrix.


*/


import java.util.*;
class RotateMatrixBy90 {
    static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        int arr[][] =  {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

