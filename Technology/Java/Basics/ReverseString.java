class ReverseString{
	public static void main(String[] args) {
        Solution solution = new Solution();
        Vector<Character> str = new Vector<>();
        str.add('h');
        str.add('e');
        str.add('l');
        str.add('l');
        str.add('o');

        Vector<Character> reversedStr = solution.reverseString(str);

        for (char c : reversedStr) {
            System.out.print(c);
        }
        System.out.println();
    }

    public static Vector<Character> reverseString(Vector<Character> s){
    	Stack stack = new Stack();

    	for(var st: s){
    		stack.push(st);
    	}

    	for(int i = 0; i < s.size(); i++){
            s.set(i, st.pop());
        }

        return s;

    }
}