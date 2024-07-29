import java.util.*;

class IsArraySorted{
	public static void main(String[] args) {
		 //int[] a = {1,10,8,2,4,7,5,7,6,10};
        int[] a = {1,1,2,3,4,5,6,6};
        boolean isSorted = true;
        for (int i = 1; i < a.length ; i++) {
        	if (a[i] < a[i-1]) {
        		isSorted = false;
                break;
        	}
        }

       if (isSorted) {
       	System.out.println("Given array is sorted");	
       }else{
       	System.out.println("Given array is not sorted");
       }
	}
}