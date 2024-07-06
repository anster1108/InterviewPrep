/*
Question : Print a character x number times the digit next to it
*/

import java.util.*;

class EachCharacterXtimes {
	public static void main(String[] args) {
		String st = "a1b3c7d2e";
		for (int i = 0; i < st.length() ; i++ ) {
			char ch = st.charAt(i);
			if((i+1) < st.length() && Character.isDigit(st.charAt(i+1)) ){
				int iter = Character.getNumericValue(st.charAt(i+1));
				for (int j = 0; j < iter ; j++ ) {
					System.out.println(ch);
				}
			}else if(Character.isDigit(ch)){
				continue;
			}else{
                 System.out.println(ch);
             }
		}
	}
}