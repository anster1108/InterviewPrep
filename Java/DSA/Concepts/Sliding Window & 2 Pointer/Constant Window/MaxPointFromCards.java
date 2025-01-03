/*
	Maximum Points You Can Obtain from Cards
		Given N cards arranged in a row, each card has an associated score denoted by the cardScore array. Choose exactly k cards. In each step, a card can be chosen either from the beginning or the end of the row. The score is the sum of the scores of the chosen cards.
		Return the maximum score that can be obtained.

		Example 1
			Input : cardScore = [1, 2, 3, 4, 5, 6] , k = 3
			Output : 15
			Explanation : Choosing the rightmost cards will maximize your total score. So optimal cards chosen are the rightmost three cards 4 , 5 , 6.
			Th score is 4 + 5 + 6 => 15.

		Example 2
			Input : cardScore = [5, 4, 1, 8, 7, 1, 3 ] , k = 3
			Output : 12
			Explanation : In first step we will choose card from beginning with score of 5.
			In second step we will choose the card from beginning again with score of 4.
			In third step we will choose the card from end with score of 3.
			The total score is 5 + 4 + 3 => 12

		Example 3
			Input : cardScore = [9, 10, 1, 2, 3, 5] , k = 5
			Output: 29

	Time Complexity:O(2*k). Where k is the size of the window.

	Space Complexity: As no additional space is used, so the Space Complexity is O(1)
*/
import java.util.*;

class MaxPointFromCards {
    /* Function to calculate the maximum
    score after picking k cards */
    public int maxScore(int[] cardScore, int k) {
        int lSum = 0, rSum = 0, maxSum = 0;

        // Calculate the initial sum of the first k cards
        for (int i = 0; i < k; i++) {
            lSum += cardScore[i];
            
            /* Initialize maxSum with the
            sum of the first k cards */
            maxSum = lSum;
        }

        // Initialize rightIndex to iterate array from last
        int rightIndex = cardScore.length - 1;
        
        for (int i = k - 1; i >= 0; i--) {
            
            // Remove the score of the ith card from left sum
            lSum -= cardScore[i];   
            
            /* Add the score of the card
            from the right to the right sum */
            rSum += cardScore[rightIndex];  
            
            // Move to the next card from the right
            rightIndex--; 

            // Update maxSum with the maximum sum found so far
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        // Return the maximum score found
        return maxSum; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        
        // Create an instance of the MaxPointFromCards class
        MaxPointFromCards sol = new MaxPointFromCards();

        int result = sol.maxScore(nums, 3);

        // Output the maximum score
        System.out.println("The maximum score is:");
        System.out.println(result);
    }
}
