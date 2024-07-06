/*

Question :  check if the given number is prime or not

*/

class IsPrimeNumber {
	public static void main(String[] args) {
		int num = 11;
		double sqrtDouble = Math.sqrt(num);
		int sqrt = (int) sqrtDouble;
		boolean isPrime = true;
		for (int i = 2; i <= sqrt  ; i++ ) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
		}
		System.out.print("Given numbe is prime number : "+ isPrime);
	}
}