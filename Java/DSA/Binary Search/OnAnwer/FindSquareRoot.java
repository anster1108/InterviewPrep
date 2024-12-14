/*
	Find square root of a number
		Given a positive integer n. Find and return its square root. If n is not a perfect square, then return the floor value of sqrt(n).

		Example 1
			Input: n = 36

			Output: 6

			Explanation: 6 is the square root of 36.

		Example 2
			Input: n = 28

			Output: 5

			Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.
*/

class FindSquareRoot {
    /* Function to compute the floor of
       square root of a given integer */
    public long floorSqrt(long n) {
        long low = 1, high = n;
        
        // Binary search on the answer space
        while (low <= high) {
            long mid = (long)(low + high) / 2;
            long val = mid * mid;
            
            // Check if val is less than or equal to n
            if (val <= (long)(n)) {
                // Move to the right part
                low = (int)(mid + 1);
            } else {
                // Move to the left part
                high = (int)(mid - 1);
            }
        }
        
        // Return the floor of square root
        return high;
    }

    public static void main(String[] args) {
        int n = 28;
        
        // Create an object of the FindSquareRoot class
        FindSquareRoot sol = new FindSquareRoot();
        
        int ans = sol.floorSqrt(n);
        
        // Print the result
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
}
