import java.util.*;

class UnionOfSortedArrays{
	public static void main(String[] args) {
		int arr1[] = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int arr2[] = {2, 3, 4, 4, 5, 11, 12};
		// O/P : 1 2 3 4 5 6 7 8 9 10 11 12
		/*
			Brute Force : we can use hashing
				Time Complexity : O(2n + 2m)
				Space Complexity : O(2n + 2m)
							
				Approach/Pseudocode : 
					HashMap<Integer, Integer> map = new HashMap<>();
					for (int val : arr1) {
						map.put(val, map.getOrDefault(val, 0) + 1);
					}

					for (int val : arr2) {
						map.put(val, map.getOrDefault(val, 0) + 1);
					}

					ArrayList<Integer> union = new ArrayList<>();
					for (int val : map.keySet() ) {
						union.add(val);
					}

			Optimal : Two Pointer approach
				Time Complexity : O(n + m)
				Space Complexity : O(n + m)
		*/

		ArrayList<Integer> union = new ArrayList<>();
		int n = arr1.length;
		int m = arr2.length;
		int i = 0, j = 0;
		while(i < n && j < m){
			if (arr1[i] <= arr2[j]) {
				if (union.size == 0 || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);	
				}
				i++;
			}else if(arr2[j] <= arr1[i]) {
				if (union.size == 0 || union.get(union.size() - 1) != arr2[j]) {
					union.add(arr2[j]);
				}
				j++;
			}
		}

		while(i < n){
			if (union.size == 0 || union.get(union.size() - 1) != arr1[i]) {
				union.add(arr1[i]);	
			}
			i++;
		}

		while(j < m){
			if (union.size == 0 || union.get(union.size() - 1) != arr2[j]) {
				union.add(arr2[j]);
			}
			j++;
		}

		for (int val : union) {
            System.out.print(val+" ");   
        }
	}
}