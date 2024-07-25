/*
	Question : Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

		You may assume that each input would have exactly one solution, and you may not use the same element twice.

		You can return the answer in any order.
		
	Brute Force :
		int target = 14;
        int[] a = {2,6,5,8,11};
        for (int i = 0; i < a.length ; i ++ ) {
            for (int j = i+1; j < a.length ; j ++ ) {
                int sum = a[i] + a[j];
                if(sum == target){
                    System.out.println("We found the two sum of target: "+ sum);
                    System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+j+" with value: "+a[j]);
                    break;
                }
            }
        }

    Better : 
    	ArrayList<Integer> al = new ArrayList<>();
        for (int name : a) {
            al.add(name);
        }

        for (int i = 0; i < a.length ; i++ ) {
            int rem = target - a[i];
            if(al.contains(Integer.valueOf(rem))){
                System.out.println("We found the two sum of target: "+ target);
                System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+al.indexOf(rem)+" with value: "+al.get(al.indexOf(rem)));
                break;
            }
        }

    Better :
    	HashMap<Integer, Integer> al = new HashMap<>();
        for (int i = 0; i < a.length ; i++ ) {
            int rem = target - a[i];
            if(al.containsKey(Integer.valueOf(rem))){
                System.out.println("We found the two sum of target: "+ target);
                System.out.println("Index: "+i+" with value: "+a[i]+" and index: "+al.get(rem)+" with value: "+rem);
                break;
            }else{
                al.put(a[i], i);
            }
        }

*/

import java.util.*;

class TwoSum{
	public static void main(String[] args) {
		int target = 14;
        int[] a = {2,6,5,8,11};
        int j = a.length - 1;
        Arrays.sort(a);
        int i = 0;
        while(i < j) {
            int t1 = a[i] + a[j];
            if(target == t1){
                System.out.println("We found the two sum of target: "+ target);
                System.out.println("value: "+a[i]+" and value: "+a[j]);
                break;
            }else if(target < t1){
                j--;
            }else{
                i++;
            }
        }
	}
}