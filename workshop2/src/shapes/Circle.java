package shapes;

public class Circle implements Shape{
	
	private double radius;
	
	Circle(){
		radius = 0;
	}
	
	public Circle(double radius){
		if(radius > 0) {
			this.radius = radius;
		}else {
			System.out.println("Invalid radius!");
		}
	}
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		if(radius > 0)
			this.radius = radius;
	}

	@Override
	public double perimeter() {
		return 2 * Math.PI * getRadius();
	}
	
	@Override
	public String toString() {
		return "Circle {r=" + getRadius() + "}";
		
	}
 
	
	
}
