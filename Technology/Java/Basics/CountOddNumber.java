// Question : Count number of odd digits in a number

class CountOddNumber{
	public static void main(String[] st){
		int number = 123;
		int count = 0;
        while(number > 0){
            if(number % 2 != 0){
                count += 1;
            }
            number = number / 10;
        }
        System.out.println("Number of odd digits present is "+count);
	}
}