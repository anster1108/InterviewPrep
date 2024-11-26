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

		/*
			As sqaure root takes time we can loop it from 
			for (int i = 2; i * i <=  num; i++ ) {
				and check for both the divisor
				1 × 28 = 28
				2 x 14 = 28
				4 x 7 = 28
			}
		*/

		System.out.print("Given numbe is prime number : "+ isPrime);
	}
}