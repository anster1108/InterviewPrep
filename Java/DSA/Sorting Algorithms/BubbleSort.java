/*
    Bubble Sort:
    -> Here we move the largest element to the right
    -> This is done by individual comparison

    => here we move from 0 -> length of array, and shist the largest to right
        -> compare 0 with 1 , 1 with 2, 2 with 3, 3 wiht 4 and if any largest swap, swap and swap
        -> do this till ar.length == 0

    Time complexity : O(n^2)
*/

class BubbleSort{
    public static void main(String[] args) {
        int ar[] = {13,46,24,52,20,9};
        int max = ar.length;
        int j = 0;
        while(j < max){
            for (int i = 0; i < max - 1 ; i++ ) {
                if (ar[i] > ar[i+1]) {
                    int temp = ar[i];
                    ar[i] = ar[i+1];
                    ar[i+1] = temp;
                }
            }
            max--;
        }

        for (int name : ar) {
            System.out.println(name);
        }
    }
}