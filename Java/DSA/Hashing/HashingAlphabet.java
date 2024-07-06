import java.util.*;

class HashingAlphabet{
	public static void main(String[] args) {
		// get the number of character repeating in the given string
        // pre condition
        int[] arr = new int[26];

        // a == 97 & z == 122 ASCII Value
        // A == 65 & z == 91  ASCII Value
        String a = "abcdabehf";
        int aAsciiValue = 97;
        for (int i=0;i < a.length(); i++) {
            int j = a.charAt(i);
            int val = arr[j - aAsciiValue];
            arr[j - aAsciiValue] = val + 1;
        }

        // for (int i = 0;i < arr.length ; i++ ) {
        //     System.out.print(arr[i]+" ");
        // }

        /*
            a
            j
            c
            a
        */
        Scanner sc = new Scanner(System.in);
        char x = sc.next().charAt(0);
        char y = sc.next().charAt(0);
        char z = sc.next().charAt(0);
        char b = sc.next().charAt(0);

        System.out.println(x+" occurence is "+arr[(int)x - aAsciiValue]);
        System.out.println(y+" occurence is "+arr[(int)y - aAsciiValue]);
        System.out.println(z+" occurence is "+arr[(int)z - aAsciiValue]);
        System.out.println(b+" occurence is "+arr[(int)b - aAsciiValue]);
	}
}