/*
	Question : we have to find an element that occurs more than n/2
				Majority Element ( element occurring > N/2 )

    Brute force : O(n^2);
        int mid = a.length / 2 ;
        for(i = 0 -> n){
            for(j = 0 -> n){
                if(a[i] == a[j]){
                    count++;
                }
            }
            if(count > mid){
                sop
                break;
            }
        }
    Better : We can use hashing, with O(nlogn) & space O(n);
        int mid = a.length / 2 ;
        Hashmap<Integer, Integer> hmap = new Hashmap()<>;
        for(i = 0 -> n){
            if(a[i] present in map's key){
                mapValue++;
            }else{
                map.put(a[i], 1);
            }
            if(map.get(a[i]) > mid){
                sop
                break;
            }
        }
    Optimal : Moore's Voting Algorith
            this algo states that any element occuring will be occuring more, 
            if it has more than n/2 occurenc, so it will not be 0
            when we get the element , we need to verify it once that is it > n/2
*/

import java.util.*;

class FindElementOccuringMoreThanHalf{
	public static void main(String[] args) {
		int[] a = {7,7,5,7,5,1,5,7,5,5,7,7,5,5,5,5};
        int elm = a[0];
        int majorityCount = a.length / 2 ;
        int cnt = 1;
        for (int i = 0; i < a.length ; i++ ) {
            if(cnt == 0){
                elm = a[i];
            }
            
            if(a[i] == elm){
                cnt++;
            }else{
                cnt--;
            }
        }

        // verify the element is > N/2
        int count = 0;
        for (int name : a) {
            if(elm == name){
                count++;
            }
        }

        if(majorityCount < count){
             System.out.println("Element: "+elm+" is the Majority Element");   
        }
	}
}