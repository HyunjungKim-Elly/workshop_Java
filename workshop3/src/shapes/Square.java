package shapes;

public class Square extends Rectangle{
	
	public Square(double length) throws ExceptionRec {
			super(length,length);
	}
	
	@Override
	public void setWidth(double side) throws ExceptionRec {
		super.setWidth(side);
		super.setLength(side);
//		System.out.println("print!");
	}
	
	@Override
	public void setLength(double side) throws ExceptionRec {
		super.setWidth(side);
		super.setLength(side);
//		System.out.println("print!");
	}
	
	@Override
	public String toString() {
		return "Square {s=" + getLength() + "}";
	}
}
