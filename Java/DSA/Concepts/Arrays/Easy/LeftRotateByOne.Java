import java.util.*;

class LeftRotateByOne{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5}; // output : { 2,3,4,5,1 }
        int end = arr[0];
        for (int i = 1; i < arr.length ; i++ ) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length  - 1] = end;

        // For Printing the end result
        for (int name : arr) {
            System.out.print(name+" ");
        }
	}
}