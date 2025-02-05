import java.util.*;

class RearrangeUniqueInAscSort{
	public static void main(String[] args) {
		int[] a = {1,1,2,2,2,2,3,3,3,4,4,5}; // OP: {1,2,3,4,5,2,3,3,3,4,4,5}
		int uniqueElements = 1;
		for (int i = 1; i < a.length ; i++ ) {
			if (a[i] > a[i - 1]) {
				a[uniqueElements] = a[i];
				uniqueElements += 1;
			}
		}
		
		System.out.println("Unique Element count : "+ uniqueElements);
		for (int val : a) {
			System.out.println(val);
		}

	}
}