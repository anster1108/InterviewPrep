import java.util.*;

class FindMissingNumber{
	public static void main(String[] args) {
		/*
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
            Optimal : O(N)
                take the sum of all the N natural numbers
                iterate over the array and subtract it from sum, after the loop ends
                the sum will be the missing number
        */
		int a[] ={1,3,4,5};
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