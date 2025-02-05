/*
	This ia an example for recursion works

	Recursion : Recursion in programming is a technique where a function directly or indirectly calls itself 
				to solve a problem by breaking it down into smaller versions of the same problem. 
				This continues until a base case is reached, which is solved directly. 
				It's like a set of nesting dolls solving problems together.
*/

class Basic{
	public static void main(String[] args) {
		int num = 1;
		recursion(num);
	}

	public static void recursion(int num){
		if (num == 3) {
			return;
		}
		System.out.println(num);
        num += 1;
        recursion(num);
	}
}