package shapes;

public class Parallelogram extends Rectangle {

	public Parallelogram(double length, double width) throws ExceptionRec {
		super(length, width);
	}

	@Override
	public String toString() {
		return "Parallelogram {w=" + getWidth() +", " + getLength() + "}";
	}
	

}
