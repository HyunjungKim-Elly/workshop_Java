package workshop1;

public class Stack {
	
	/** field */
	int top;
	char arr[];

	/** constructor */
	Stack(int size) {
		this.arr = new char[size];
		this.top = -1;
	}
	
	/** methods */
	
    public void push(String data) {
    	//when the data is pushed, data will be assigned to the array and top will be increased
    	arr[++top] = data.charAt(0);    
    } 
    
    public char pop() {	
    	//when pop()is called, return the array that its top is decreased
    	return arr[--top];
    }	
    
    public char peek() {
    	//return the top array
		return arr[top];
	}
    

    
}

 