import java.util.*;

class PrintDigits{
	public static void main(String[] args) {
		int a = 12345;
		int count = 0;
		while(a > 0){
			System.out.println(a%10);
			a = a / 10;
			count += 1; 
		}

		System.out.println("Total Number of digits found in the gien integer is: "+count);
	}
}