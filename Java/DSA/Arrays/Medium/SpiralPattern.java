/*
Print the matrix in spiral manner

Given an M * N matrix, print the elements in a clockwise spiral manner. Return an array with the elements in the order of their appearance when printed in a spiral manner.

Example 1
Input: matrix = [[1, 2, 3], [4 ,5 ,6], [7, 8, 9]]

Output: [1, 2, 3, 6, 9, 8, 7, 4, 5]

Explanation: The elements in the spiral order are 1, 2, 3 -> 6, 9 -> 8, 7 -> 4, 5

Example 2
Input: matrix = [[1, 2, 3, 4], [5, 6, 7, 8]]

Output: [1, 2, 3, 4, 8, 7, 6, 5]

Explanation: The elements in the spiral order are 1, 2, 3, 4 -> 8, 7, 6, 5

Example 3
Input: matrix = [[1, 2], [3, 4], [5, 6], [7, 8]]

Output:
[1, 2, 4, 6, 8, 7, 5, 3]


    Intuition
    The idea is to use four separate loops to print the array elements in spiral. 1st loop will print the elements from left to right. 2nd loop will print the elements from top to bottom. 3rd loop will print the elements from right to left. 4th loop will print the elements from bottom to top.

    Approach 
    - Initialize four variables top as 0, left as 0, bottom as TotalRow - 1, right as ToatalColumn - 1.
    - Iterate till top is less than or equal to bottom and left less than or equal to right
    - For moving left to right use a loop(say i) and add the elements. Increment top by 1.
    - For moving top to bottom use another loop and add the elements in answer. Decrement right by 1.
    - If top is less than or equal to bottom then for moving right to left use another loop and add the elements in answer. Decrement bottom by 1.
    - If left is less than or equal to right the for moving bottom to top take another loop and add the elements in answer. Increment left by 1. Lastly, return the answer.


*/

import java.util.*;

class SpiralPattern {
    //Function to print matrix in spiral manner
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        
        // Number of rows
        int n = matrix.length;

        // Number of columns
        int m = matrix[0].length;
        
        // Initialize pointers for traversal
        int top = 0, left = 0;      
        int bottom = n - 1, right = m - 1;
        
        // Traverse the matrix in spiral order
        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; ++i) {
                ans.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom
            for (int i = top; i <= bottom; ++i) {
                ans.add(matrix[i][right]);
            }
            right--;
            
            // Traverse from right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            // Traverse from bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        //Return the ans
        return ans;
    }
    
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        
        // Create an instance of the SpiralPattern class
        SpiralPattern finder = new SpiralPattern();
        
        // Get spiral order using class method
        List<Integer> ans = finder.spiralOrder(mat);
       
        System.out.print("Elements in spiral order are: ");
        for (int i = 0; i < ans.size(); ++i) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }
}
