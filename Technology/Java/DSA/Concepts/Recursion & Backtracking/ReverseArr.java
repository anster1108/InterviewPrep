/*

Question : Reverse the given Array

Input : {1, 2, 3, 4, 5} 

Output : {5, 4, 3, 2, 1}

*/

class ReverseArr {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		arr = rec(arr, 0 , arr.length - 1);

		for (int val : arr) {
			System.out.println(val);
		}
	}

	public static int[] rec(int[] arr, int i, int j){
		if (i == j) {
			return arr;
		}

		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
		arr = rec(arr, i+1, j-1);
		return arr;
	}
}