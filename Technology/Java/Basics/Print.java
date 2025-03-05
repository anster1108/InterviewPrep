import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Print {
    public static void main(String[] args) {
        String st = "qwerty";
        for(int i = 0; i < st.length(); i++){
            System.out.print(st.charAt(i)+" ");
        }
        System.out.println();
        int[] ar = {1,2,3,4,5};
        for(int i = 0; i < ar.length; i++){
            System.out.print(ar[i]+" ");
        }
        System.out.println();
        int[] ar1 = new int[5];
        ar1[0] = 0;
        ar1[1] = 1;
        ar1[2] = 2;
        ar1[3] = 3;
        ar1[4] = 4;
        for(int i = 0; i < ar1.length; i++){
            System.out.print(ar1[i]+" ");
        }
        System.out.println();
        List<Character> lst = new ArrayList<>();
        lst.add('p');
        lst.add('r');
        lst.add('i');
        lst.add('n');
        lst.add('t');
        for(int i = 0; i < lst.size(); i++){
            System.out.print(lst.get(i)+" ");
        }
        System.out.println();

        Map<Integer, Character> map = new HashMap<>();
        map.put(12, 'h');
        map.put(11, 's');
        map.put(15, 'm');
        map.put(14, 'a');
        map.put(17, 'p');
        for(Integer it : map.keySet()){
            System.out.print(it +" ");
        }
        System.out.println();
        for(Character ch : map.values()){
            System.out.print(ch +" ");
        }
        System.out.println();
        
        HashMap<Character, Integer> lt = new HashMap<>();
        lt.put('A',18);
        lt.put('B',1);
        lt.put('C',2);
        lt.put('D',3);
        lt.put('k',8);
        lt.put('g',9);
        for(Map.Entry<Character, Integer> entry : lt.entrySet()){
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
    }
}