/*
	Question : Find the number that appears once, and other numbers twice.

	Example : {1,1,2,3,3,4,4}
	O/P: 2 is number that has occured only once

	Brute Force : O(n^2)
         run a loop from (0 - n-1)
         check the given number if present on the array twice or not
         for(i -> 0 -> n-1){
             number = a[i]
             count = 1;
             for(j -> 0 -> n-1){
                 if(j == i){
                     continue
                 }else if(a[j] == a[i]){
                     cnt += 1; 
                 }
             }
             if(cnt == 1){
                 sop(a[i] is not twice)
             }
         }

    Better 1: using hashing array O(3N)
                find the max no. in the array
                int max = 0;
                for(i on a [0 -> n-1] ){
                    if(a[i] >  max){
                        max = a[i];
                    }
                }

                int[] hash = new int[max+1];
                for(i on a [0 -> n-1] ){
                    hash[a[i]] = hash[a[i]] + 1; 
                }

                for(i on hash [1 -> length] ){
                    if(hash[i] == 1){
                        sop(hash[i] is not twice)
                    }
                }

    Better 2: using maps O(NlogN)
                HashMap<Integer, Integer> hmap = new HashMap<>();
                for(i on arr(0 -> n - 1)){
                    int val = hmap.getOrDefault(a[i], 0);
                    hmap.put(a[i],val+1);
                }

                for(MapEntry<Integer, Integer> key : hmap.entrySet()){
                    if(hmap.getValue == 1){
                        sop(map.get(key) is not twice)
                    } 
                }

    Optimal : it can be achieved by Xor, if any problem states that the number are twice,
            we use xor, in order to get the non repeating value
        a ^ a = 0
        a ^ a ^ b = b

*/
import java.util.*;

class FindNumberApperaringOnce{
	public static void main(String[] args) {
		int xor = 0;
        for (int name : a) {
            xor = xor ^ name;
        }
        System.out.println(xor);
	}
}