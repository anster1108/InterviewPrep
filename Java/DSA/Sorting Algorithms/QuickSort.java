import java.util.*;

 /*
    Quick Sort
        Time Complexity : O(nlogn)
        Space Complexity : O(1)

    Steps :
        - Pick up the first element(pivot) 
            and put it at its correct place in the sorted array.
        - Smaller on the left & larger on the right
        - using recursion

    Explaination : 
        array : {4,6,2,5,7,9,1,3}
         - we will use pointer concept : low[1st element of arr] , high[last element of arr]
         - pivot = a[low]
         - move using while loop:  from low & also from high
         - check if an index is having a[i] > pivot(stop) and check from j place check,
             a[j] < pivot & swap a[i] with a[j] and j > i

         - once j < i ,means that all the places from i not is greater than pivot 
         and all places from low to j is smaller than pivot  
             -> swap the pivot(a[low]) with a[j]
             -> now index of pivot is a partition place as
                 -> array 1, i.e, 0 to piv - 1, is smaller array
                 -> array 2, i.e, piv + 1 to high, is greater array

    PseudoCode :
        QuickSort(arr, low, high){
            if low < high{
                partitionIndex =  logicfn(arr, low, high) // return the index of the pivot
                QuickSort(arr, low, partitionIndex - 1)
                QuickSort(arr, partitionIndex + 1, high)
            }
        }

        int logicfn(a, low, high){
            pivot = low;
            i = low;
            j = high;
            while (i < j) {
                while (a[i] <= a[pivot] && i <= high) {
                    i++;
                }
                while (a[j] > a[pivot] && j >= low) {
                    j--;
                }
                if(i < j){
                    swap(a[i], a[j]) 
                }
            }

            swap(a[j], pivot)
            return j;
        }
*/


class QuickSort{
	public static void main(String[] args) {
		System.out.print("Before Sorting the array: ");
        List<Integer> a = new ArrayList<>();
        // {4,6,2,5,7,9,1,3}
        a = Arrays.asList(new Integer[] {4,6,2,5,7,9,1,3});
        for (int i = 0; i < a.size() ; i++ ) {
            System.out.print(a.get(i)+" ");
        }
        
        Solution.quickSort(a);

        System.out.println("");
        for (int i = 0; i < a.size() ; i++ ) {
            System.out.print(a.get(i)+" ");
        }	
	}
}

	class Solution{
	    public static List<Integer> quickSort(List<Integer> a){
	        qs(a, 0, a.size() - 1);
	        return a;
	    }

	    public static void qs(List<Integer> a, int low, int high){
	        if (low < high) {
	            int partitionIndex = partition(a, low, high);
	            qs(a, low, partitionIndex - 1);
	            qs(a, partitionIndex + 1, high);
	        }
	    }

	    public static int partition(List<Integer> a, int low, int high){
	        int pivot = a.get(low);
	        int i = low;
	        int j = high;
	        while (i < j) {
	            while (a.get(i) <= pivot && i < high) {
	                i++;
	            }
	            while (a.get(j) > pivot && j > low) {
	                j--;
	            }
	            if(i < j){
	                int temp = a.get(i);
	                a.set(i, a.get(j));
	                a.set(j, temp);
	            }
	        }
	        int temp = a.get(low);
	        a.set(low, a.get(j));
	        a.set(j, temp);
	        return j;
	    }
	}