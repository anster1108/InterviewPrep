import java.util.*;

class MaximumConsecutiveNumber{
	public static void main(String[] args) {
		/*
			Q. Find the Maximum Consecutive Number occuring in an array
		*/
		int[] a ={1,1,0,1,1,1,1,0,0,1,2,2,2,2,2,2,2,1,1,1,3,2,1,2}; 
        int maxOccurence = 1, occuringNumber = -1, temp = 1;
		for (int i = a.length - 1; i > 0 ; i-- ) {
            if(a[i] == a[i-1]){
                temp += 1;
            }else{
                if(maxOccurence < temp){
                    maxOccurence = temp;
                    occuringNumber = a[i];
                }
                temp = 1;
            }
		}

		System.out.println("Max occuring number is "+occuringNumber);
        System.out.println("Max count is "+maxOccurence);
	}
}