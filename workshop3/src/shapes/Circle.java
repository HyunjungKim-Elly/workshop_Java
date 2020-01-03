package shapes;

public class Circle implements Shape{
	
	private double radius;
	
	public Circle(double radius) throws ExceptionRadius{
		if(radius > 0) {
			this.radius = radius;
		}else {
			throw new ExceptionRadius();
		}
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) throws ExceptionRadius {
		if(radius > 0)
			this.radius = radius;
		else 
			throw new ExceptionRadius();
	}
	
	@Override
	public double getPerimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	@Override
	public String toString() {
		return "Circle {r=" + getRadius() + "}";
		
	}
 
	
	
}
