/*

	Question :  Given an character array, consisting of alphabets and special character, 
				we need to reverse the positio of the alphabets without changing special characters place.
	
	Input :  {'A','b',',','d','e','!','$'};
	Output : {'e','d',',','b','A','!','$'};
*/

import java.util.*;

class ReverseArrayWithoutMovingSpecialCharacter{
	public static void main(String[] args) {
		Character[] arr = {'A','b',',','d','e','!','$'};
		// output = {'e','d',',','b','A','!','$'};
		int i = 0, j = arr.length - 1;
		
		while(i < j){
			if (!Character.isLetter(arr[i])) {
				i++;
			}else if (!Character.isLetter(arr[j])){
				j--;
			}else{
				char temp = ar[i];
				a[i] = a[j];
				a[j] = temp;
				j--;
				i++;
			}
		}

		// Printing array after reversing
		for (char ch : arr) {
			System.out.println(ch);
		}
	}
}