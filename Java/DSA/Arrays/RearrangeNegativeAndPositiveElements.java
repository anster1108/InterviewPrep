/*
	Rearrange the Positives and negatives integer in alternate patern with Same Length of +ve and -ves

	Array having even no of element with equal of -ve and +ve 
    O/P re arrange pattern : +ve, -ve, +ve, -ve, +ve, -ve

    Brute Force : O(N + N/2) , Space = O(N)
    we will take 2 arrays , one of positive and another of negative
    positiveList , NegativeList
    for (int i = 0; i < a.length ; i++ ) {
        if(a[i] > 0){
            positiveList.add(a[i]);
        }else{
            negativeList.add(a[i]);
        }
    }

    for (int i = 0; i < a.length / 2 ; i++ ) {
        a[2*i] = positiveList.get(i);
        a[2*i + 1] = negativeList.get(i);
    }

    Optimal : O(N) , Space : O(N)
    here we can take an empty array with same size or the array
    -> we know that all +ve will be at even places
    -> all -ve will be at odd places
*/

import java.util.*;

class RearrangeNegativeAndPositiveElements{
	public static void main(String[] args) {
		/* Brute Force
            ArrayList<Integer> positiveList = new ArrayList<>();
            ArrayList<Integer> negativeList = new ArrayList<>();
            for (int i = 0; i < a.length ; i++ ) {
                if(a[i] > 0){
                    positiveList.add(a[i]);
                }else{
                    negativeList.add(a[i]);
                }
            }
    
            for (int i = 0; i < a.length / 2 ; i++ ) {
                a[2*i] = positiveList.get(i);
                a[2*i + 1] = negativeList.get(i);
            }
    
            for (int name : a) {
                System.out.println(name);
            }
        */
		
		int[] a = {3, 1, -2, -5, 2, -4};
        int[] rearrangedArray = new int[a.length];
        int even = 0, odd = 1;
        for (int i = 0; i < a.length ; i++ ) {
            if(a[i] > 0){
                rearrangedArray[even] = a[i];
                even += 2;
            }else{
                rearrangedArray[odd] = a[i];
                odd += 2;
            }
        }

        for (int name : rearrangedArray) {
            System.out.println(name);
        }
	}
}