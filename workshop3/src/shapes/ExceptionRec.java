package shapes;

@SuppressWarnings("serial")
public class ExceptionRec extends Exception {
	ExceptionRec(){
		super("Invalid side!");
	}
}


/*package shapes;
@SuppressWarnings("serial")


public class CircleException extends Exception{
	public CircleException(){
		super();
	}
	
	public CircleException(String message){
		super(message);
	}
}
*/