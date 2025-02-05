import java.util.*;

class FindMissingNumber{
	public static void main(String[] args) {
		/*
			Question : Find the missing Number in an Array of Size N

	            given array of size n-1 and we have to find the missing number
	            {1,3,4,5} , where n = 5, missing no is : 2
	            Brute Force : O(n^2)
	                for(i = 1 -> n){
	                    int flag = 0;
	                    for(j = ar[0 -> n-1]){
	                        if(i exist in ar){
	                            flag = 1;
	                            break;
	                        }
	                    }
	                    if(flag = 0){
	                        sop(i);
	                        break;
	                    }
	                }
	            Better : O(2N) using Hash Array
	                take an hash array of size N + 1
	                fill the array
	                for(i = ar[0 -> n-1]){
	                    hash[ar[i]] = 1;
	                }
	                for(i = hash[1 -> n-1]){
	                    if(val == 0){
	                        sop(i);
	                        break
	                    }
	                }
	            Optimal 1 : O(N)
	                take the sum of all the N natural numbers
	                iterate over the array and subtract it from sum, after the loop ends
	                the sum will be the missing number

	            Optimal 2 : O(N)
	            	take the xor of index and xor of the numbers
	            	int xor1 = 0, xor2 = 0;

			        // Calculate XOR of all array elements
			        for (int i = 0; i < nums.length; i++) {
			            xor1 = xor1 ^ (i + 1); // XOR up to [1...N]
			            xor2 = xor2 ^ nums[i]; // XOR of array elements
			        }

			        // XOR of xor1 and xor2 gives missing number
			        return (xor1 ^ xor2);

			        in xor the numbers exising willget cut and the number that is present once that will remain

			        example : 1 2 4 0

			        xor of index : 0 ^ 1 ^ 2 ^ 3 ^ 4
			        xor of array : 0 ^ 1 ^ 2 ^ 4 ^ 0
			        left nelement when we xor both : 3
        */
		int a[] ={1,3,4,5};
		/* 
			if the numbers range start for 1 : a.length + 1
			if it starts from 0 : a.length
		*/
		int n = a.length + 1; 
		int totalSum = (n * (n+1)) / 2;
		int sum = 0;
		for (int i = 0; i < a.length ; i++ ) {
			sum = sum + a[i];
		}

		int missingNumber = totalSum - sum ;
		System.out.println("Missing Number is "+missingNumber);
	}
}