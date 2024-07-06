/*

Question : given the input print the Fibonacci series till the given input

Fibonacci series : 0 , 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 ... n

*/

class Fibonacci{
	public static void main(String[] args) {
		int n = 7;
		int first = 0;
		int second = 1;
		for (int i = 0; i < n ; i++ ) {
			System.out.print(second+", ");
			int next = first + second;
			first = second;
			second = next;
		}
		System.out.println("Nth element is : "+first);
	}
}