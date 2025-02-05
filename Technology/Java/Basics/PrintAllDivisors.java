/*
Question : Find all the divisor of the given number

Ex : 
	int a = 36
	Output : 1, 2, 3, 4, 6, 9, 12, 18, 36
*/

class PrintAllDivisors{
	public static void main(String[] args) {
		int num = 36;
		for (int i = 1; i <= 36 ; i++ ) {
			int rem = num % i;
			if(rem == 0){
				System.out.println(i+ " is a divisor");
			}
		}
	}
}