package shapes;

@SuppressWarnings("serial")
public class ExceptionTriangle extends Exception {
	ExceptionTriangle(){
		super("Invalid side(s)!");
	}
}