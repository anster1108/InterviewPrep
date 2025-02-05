/* 
    Question : Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s.

    The number returned should not have leading zero's. But the given input string may have leading zero.
*/

class LargeOddNuminString{
    public static void main(String[] args) {
        String s = "0214638";
        int startIndex = 0;
        int endIndex = s.length() - 1;

        while(endIndex > startIndex){
            if(s.charAt(startIndex) != '0' && s.charAt(endIndex) % 2 != 0){
                break;
            }

            if(s.charAt(startIndex) == '0'){
                startIndex += 1;
            }

            if(s.charAt(endIndex) % 2 == 0){
                endIndex -= 1;
            }
        }

        System.out.println("large Odd Number in given String :"+s.substring(startIndex, endIndex + 1));
    }
}
