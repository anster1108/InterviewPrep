import java.util.*;

class LeftRotateByDPlaces{
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5}; 
        Scanner sc = new Scanner(System.in);
        int places = sc.nextInt();
        places = places % arr.length;
        
        /*
            Brute Force :
                Time Complexity : O(3N)

                Approach/Pseudocode :

                    int temp[] = new int[places];
                    // move to temp array
                    for (int i = 0; i < places; i++ ) {
                        temp[i] = arr[i];
                    }
                    
                    // left shifting from places
                    for (int i = places; i < arr.length ; i++ ) {
                        arr[i - places] = arr[i];
                    }

                    for (int i = (arr.length - places); i < arr.length ; i ++ ) {
                        int val = i - (arr.length - places);
                        arr[i] = temp[val];
                    }
                    
                    // For Printing the end result
                    for (int name : arr) {
                        System.out.print(name+" ");
                    }
        */
        /*
            Optimal :
            Time Complexity : O(2N)

            Approach/Pseudocode :
                Here we will be reversing the array into 2 halves
                    -> First riverse the given array till places
                    -> Then reverse the array from places to n
                    -> Then reverse the whole array
        */
        for (int i = 0; i < places ; i++ ) {
            int j = places - 1 -i;
            if (i < j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }

        int k = 0;
        for (int i = places; i < arr.length ; i++ ) {
            int j = arr.length - 1 - k;
            if (i < j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
                k++;
            }
        }

        for (int i = 0; i < arr.length ; i++ ) {
            int j = arr.length - 1 -i;
            if (i < j) {
                arr[i] = arr[i] + arr[j];
                arr[j] = arr[i] - arr[j];
                arr[i] = arr[i] - arr[j];
            }
        }

        // For Printing the end result
        for (int name : arr) {
            System.out.print(name+" ");
        }

	}
}