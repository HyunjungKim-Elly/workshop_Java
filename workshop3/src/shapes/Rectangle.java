package shapes;

public class Rectangle implements Shape{
	private double width, length;
	
	public Rectangle(double length, double width) throws ExceptionRec {
		if(length <= 0 || width <= 0) {
			throw new ExceptionRec();
		}else {
			this.width = width;
			this.length = length;
		}
	}
	
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) throws ExceptionRec {
		if(width > 0)
			this.width = width;
		else
			throw new ExceptionRec();
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) throws ExceptionRec {
		if(length > 0)
			this.length = length;
		else
			throw new ExceptionRec();
	}

	@Override
	public double getPerimeter() {		
		return (2 * getLength()) + (2 * getWidth()) ;
	}
	
	public String toString() {	
		return "Rectangle {w=" + getWidth() + ", " + "h=" + getLength() + "}";
	}

}
