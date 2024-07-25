/*
    Brute Force : Sort the array and we will get the output
        Arrays.sort(a)
    Better : 
        Create 3 variable of 0, 1, 2 count
        Run a loop and save count of every number in their respective array
        now run the loop 0 -> count0 - 1
        now run the loop count0 -> count1 - 1
        now run the loop count1 -> count2 - 1
        and it sorted
    Optimal : 
        Here we will be using Dutch Flag Algorith, which states that
        All the 0 will occur at place between [ 0 -> low - 1 ] [ Extreme left ]
        All the 1 will occur at place between [ low -> mid - 1 ]
        All unsorted numbers(0,1,2) between [ mid -> high ]
        All the 2 will occur at place between [ high + 1 -> n - 1 ] [ Extreme right ]
        0        low-1 | low      mid - 1 | mid [ UNSORTED] high | high+1      n-1
        0 0 0 0 0 0 0  |  1 1 1 1 1 1 1 1 | 0 2 1 1 2 1 0 1 0 1  |  2 2 2 2 2 2 2


        So,
            a[mid] == 0
                swap(a[mid], a[low])
                low++ , mid++ 
            a[mid] == 1
                mid++
            a[mid] == 2
                swap(a[mid], a[hight])
                high-- ;
*/

import java.util.*;

class Sort012s{
	public static void main(String[] args) {
		int[] a = {0,1,0,1,1,0,1,2,2,2,1,0,2,0};
        int low = 0, mid = 0, high = a.length - 1;
        while (mid <= high) {
            if(a[mid] == 0){
                // swap(a[mid], a[low])
                int temp = a[mid];
                a[mid] = a[low];
                a[low] = temp;
                low++;
                mid++;
            }else if(a[mid] == 1){
                mid++;
            }else if(a[mid] == 2){
                // swap(a[mid], a[high])
                int temp = a[mid];
                a[mid] = a[high];
                a[high] = temp;
                high--;
            }
        }


        for (int name : a) {
            System.out.print(name+" ");
        }
	}
}