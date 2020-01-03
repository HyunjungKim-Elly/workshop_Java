package shapes;

import java.text.DecimalFormat;

public class Parallelogram extends Rectangle {
	
	private static DecimalFormat format = new DecimalFormat("0.0#####");
	
	public Parallelogram(double length, double width) throws ExceptionRec {
		super(length, width);
	}

	@Override
	public String toString() {
		return "Parallelogram {w=" + getWidth() +", " + getLength() + "}" + " Perimeter = " + format.format(getPerimeter());
	}
	

}
