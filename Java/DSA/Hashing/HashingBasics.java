import java.util.Scanner;

public class HashingBasics {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        System.out.println("value inserted is "+arrSize);
    
        // Creating an Array and using Scanner class to input the array size and values
        int[] arr = new int[arrSize];
        for(int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
    
        // Creating hash of the given array
        int[] hash = new int[arrSize];
        for(int val : arr) {
            hash[val] = hash[val] + 1;
        }
    
        // output of the hash array
        for(int i = 0; i < arr.length ; i++ ) {
            System.out.println(i+" : "+hash[i]);
        }
    
        // checking the number of values present in the hash array
        int inp = sc.nextInt();
        System.out.println(inp+" is having hash value of "+hash[inp]);
        sc.close();
    }
}
