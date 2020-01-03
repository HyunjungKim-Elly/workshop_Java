package shapes;

public class Square extends Rectangle{
	
	public Square(double length) {
			super(length,length);
	}
	
	@Override
	public void setWidth(double side) {
		super.setWidth(side);
		super.setLength(side);
		System.out.println("print!");
	}
	
	@Override
	public void setLength(double side) {
		super.setWidth(side);
		super.setLength(side);
		System.out.println("print!");
	}
	
	@Override
	public String toString() {
		return "Square {s=" + getLength() + "}";
	}
}
