import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class GetShorterString {
    public static void main(String[] args) {
        System.out.println(Main.shorter("HHSCCCC").equals("MH"));
    }

    public static String shorter(String st){
        LinkedHashMap<Character, Integer> hmap = new LinkedHashMap<>();
        hmap.put('X', 1000);
        hmap.put('M', 500);
        hmap.put('H', 200);
        hmap.put('S', 100);
        hmap.put('C', 50);
        hmap.put('T', 10);
        hmap.put('A', 1);

        int result = 0;
        String res = "";

        for(int i = 0; i < st.length(); i++){
            result += hmap.get(st.charAt(i));
        }
        System.out.println("result : "+ result);

        // loop on the map
        int div = 0;
        for(Map.Entry<Character, Integer> entry : hmap.entrySet()){
            if(result >= entry.getValue()){
                div = result / entry.getValue();
                for(int k = 0; k < div; k++){
                    res = res + entry.getKey();
                }
                result = result % entry.getValue();
            }
        }
        
        // 1000, 500 , 200, 100, 50 , 10 ,1
        // int div = 0;
        // if(result >= 1000){
        //     div = result / 1000;
        //     for(int k = 0; k < div; k++){
        //         res = res + "X";
        //     }
        //     result = result % 1000;
        // }
        
        // if(result >= 500){
        //     div = result / 500;
        //     for(int k = 0; k < div; k++){
        //         res = res + "M";
        //     }
        //     result = result % 500;
        // }
        
        // if(result >= 200){
        //     div = result / 200;
        //     for(int k = 0; k < div; k++){
        //         res = res + "H";
        //     }
        //     result = result % 200;
        // }
        
        // if(result >= 100){
        //     div = result / 100;
        //     for(int k = 0; k < div; k++){
        //         res = res + "S";
        //     }
        //     result = result % 100;
        // }

        // if(result >= 50){
        //     div = result / 50;
        //     for(int k = 0; k < div; k++){
        //         res = res + "C";
        //     }
        //     result = result % 50;
        // }

        // if(result >= 10){
        //     div = result / 10;
        //     for(int k = 0; k < div; k++){
        //         res = res + "T";
        //     }
        //     result = result % 10;
        // }

        // if(result >= 1){
        //     for(int k = 0; k < result; k++){
        //         res = res + "A";
        //     }
        // }

        return res;
    }
}