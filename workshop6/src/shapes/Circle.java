package shapes;

import static java.lang.Math.PI;

import java.text.DecimalFormat;
public class Circle implements Shape{
	
	private double radius;
	private static DecimalFormat format = new DecimalFormat("0.0#####");

	private Calculater area = () -> PI * getRadius() * getRadius();
	
	public double getAreaMethod() {
		return area.getArea();
	} 
	
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
		return "Circle {r=" + getRadius() + "}" + " Perimeter = " + format.format(getPerimeter())
		 		+ " Area = " + format.format(getAreaMethod());
		
	}
 
	
	
}
