/*

Question : Find number of triplets with sum less than the given sum

*/

import java.util.*;

class TripletSumLesser{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = sc.nextInt();
		sc.close();

		int[] a = {5,1,3,4,7};
		Arrays.sort(a); // sorting the array in asc order

		int n = a.length;
        int ans = 0;
		for (int i = 0; i < n - 2 ; i++) {
			int j = i + 1;
			int k = n - 1;
			while(j < k){
                int totalSum = a[i] + a[j] + a[k]; 
                if(totalSum >= sum){
                    k--;
                }else{
                    /* this is important for current i & j
                        there can be total k-j third element 
                        with sum less than total sum
                    */
                    ans += k - j;
                    j++;
                }
            }
		}
		System.out.println(ans);
	}
}