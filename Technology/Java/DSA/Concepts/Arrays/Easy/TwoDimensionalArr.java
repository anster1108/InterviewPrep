/*
Question : Iterate over a 2D Array
*/

class TwoDimensionalArr{
	public static void main(String[] args) {
		int[][] a = new int[2][2];
		int[][] arr = {{4,3}, {1,2}};
		int sum = 0;
		for (int i = 0; i < 2 ; i++ ) {
			for (int j = 0; j < 2 ; j++ ) {
				System.out.println(arr[i][j]);
				sum = sum + arr[i][j];
			}
		}
		System.out.println("Sum is "+sum);
	}
}