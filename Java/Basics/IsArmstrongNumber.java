/*
	Question : is the given integer armstrong number or not

	these are those numbers whose cube is same as of the number
	
	371 =  (3*3*3) + (7*7*7) + (1*1*1) = 371 [thus its a armstrong number]

*/

class IsArmstrongNumber{
	public static void main(String[] args) {
		int num = 371;
		int armCheck = 0;
		int dup = num;
		while(num > 0){
            int lastDigit = num % 10;
			armCheck = (lastDigit * lastDigit * lastDigit) + armCheck;
            num = num / 10;
		}
		if (dup == armCheck) {
			System.out.println("Given Number's is an armstrong number");
		}else{
			System.out.println("Given Number's is not an armstrong number");
		}
	}
}