/*
	Find Nth root of a number
		Given two numbers N and M, find the Nth root of M. The Nth root of a number M is defined as a number X such that when X is raised to the power of N, it equals M. If the Nth root is not an integer, return -1.

		Example 1
			Input: n = 36

			Output: 6

			Explanation: 6 is the square root of 36.

		Example 2
			Input: n = 28

			Output: 5

			Explanation: The square root of 28 is approximately 5.292. So, the floor value will be 5.
*/

class FindNthRoot {
    /* Helper function to check the power of mid
    with respect to m Returns: 1 - if mid^n == m,
    0 - if mid^n < m and 2 - if mid^n > m*/ 
    private int func(int mid, int n, int m) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= mid;
            if (ans > m) return 2;
        }
        if (ans == m) return 1;
        return 0;
    }

    /* Function to find the nth root
    of m using binary search*/
    public int NthRoot(int N, int M) {
        // Binary search on the answer space
        int low = 1, high = M;

        while (low <= high) {
            int mid = (low + high) / 2;
            int midN = func(mid, N, M);
            if (midN == 1) {
                // Return mid if mid^N == M
                return mid;
            } else if (midN == 0) {
                // Move to the right half if mid^N < M
                low = mid + 1;
            } else {
                // Move to the left half if mid^N > M
                high = mid - 1;
            }
        }
        // Return -1 if no nth root found
        return -1;
    }
    
    public static void main(String[] args) {
        int n = 3, m = 27;
        
        // Create an object of the FindNthRoot class
        FindNthRoot sol = new FindNthRoot();
        
        int ans = sol.NthRoot(n, m);
        
        // Print the result
        System.out.println("The answer is: " + ans);
    }
}

