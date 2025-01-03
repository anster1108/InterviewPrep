import java.util.*;

class IntersactionOfArrays{
	public static void main(String[] args) {
		int A[]= {1,2,3,3,4,5,6,7};
  		int B[]= {3,3,4,4,5,8};
		ArrayList<Integer> intersactionList = new ArrayList<>();
  		/*
  			Brute Force : we can use hashing
				Time Complexity : O(n*m)
				Space Complexity : O(m)

				Approach/Pseudocode : 
					int[] visited = new int[B.length];
			  		for(int i = 0; i < A.length; i++){
			  			for(int j = 0; j < B.length; j++){
			  				if (A[i] == B[j] && visited[j] == 0) {
			  					intersactionList.add(B[j]);
			                    visited[j] = 1;
			                    break;
			  				}else if(B[j] > A[i]){
			                    // as Array is sorted
			                    break;
			                }
			  			}
			  		}

			  		// for printing list
			  		for (int val : intersactionList) {
			  			System.out.println(val);
			  		}

  		*/
  		int i = 0, j = 0;
  		while(i < A.length && j < B.length){
  			if (A[i] == B[j]) {
  				intersactionList.add(A[i]);
  				i++;
  				j++;
  			}else if(A[i] > B[j]) {
  				j++;
  			}else if(A[i] < B[j]) {
  				i++;
  			}
  		}

  		// for printing list
  		for (int val : intersactionList) {
  			System.out.println(val);
  		}
	}
}