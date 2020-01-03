package shapes;

public class Rectangle implements Shape{
	private double width, length;
	
	Rectangle(){
		width = 0;
		length = 0;
	}
	
	public Rectangle(double length, double width) {
		if(length <= 0 || width <= 0) {
			System.out.println("Invalid side!");
		}else {
			this.width = width;
			this.length = length;
		}
	}
	
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		if(width > 0)
			this.width = width;
	}


	public double getLength() {
		return length;
	}


	public void setLength(double length) {
		if(length > 0)
			this.length = length;
	}

	@Override
	public double perimeter() {		
		return (2*length) + (2*width) ;
	}
	
	public String toString() {	
		return "Rectangle {w=" + width + ", " + "h=" +length + "}";
	}

}
