package workshop1;

public class Palindrome {

	/** main method */
	public static void main(String[] args){	
		
		boolean result = false;
		Stack stack = new Stack(args.length);
		Stack temp = new Stack(args.length);
		
		//receives a string as a command-line argument	
		for (int i = 0; i < args.length; i++) {
			stack.push(args[i]);//push the command-line argument to the stack object	
		} 
		
		//repeat push and peek to copy the stack to temp
		for(int j = 0; j < args.length -1; j++) {			
			temp.arr[j] = stack.peek();
			stack.pop();
		}	
		temp.arr[args.length - 1] = stack.peek();//this is to peek the last character
		
		//print the string in reverse once
		for(int j = 0; j < args.length; j++) {		
			System.out.println(temp.arr[j]); 
		}	
		
		//checking if it is palindrome
		for (int i = 0; i < args.length; i++) {
			if(temp.arr[i] == stack.arr[i]) { //if the temp and stack array is the same, it's true
				result = true;
			}else {
				result = false;
			}
		}
			
		if(result == true) {
			System.out.println("This string is a Palindrome\n");
		}else {
			System.out.println("This string is not a Palindrome\n");
		}
		
		
	}

}
