package shapes;

public class Triangle implements Shape{
	
	private double s1,s2,s3;

	public Triangle(double s1, double s2, double s3) throws ExceptionTriangle {
		if(checkTriangle(s1,s2,s3) == true) {
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
		}else {
			throw new ExceptionTriangle();
		}
	}
	
	public boolean checkTriangle(double s1, double s2, double s3) {
		boolean result = false;
		if(s1 > 0 && s2 > 0 && s3 > 0) {			
			if(((s1 + s2) > s3) && ((s1 + s3) > s2) && ((s3 + s2) > s1)) {
				result = true;
			}
			
		}else {
			result = false;
		}
		return result;
	}

	
	public double getS1() {
		return s1;
	}


	public void setS1(double s1) throws ExceptionTriangle {
		if(s1 > 0 && getS2() + getS3() > s1)
			this.s1 = getS1();
		else
			throw new ExceptionTriangle();
	}


	public double getS2() {
		return s2;
	}


	public void setS2(double s2) throws ExceptionTriangle {
		if(s2 > 0 && getS1() + getS3() > s2)
			this.s2 = getS2();
		else
			throw new ExceptionTriangle();
	}


	public double getS3() {
		return s3;
	}


	public void setS3(double s3) throws ExceptionTriangle {
		if(s3 > 0 && getS2() + getS1() > s3)
			this.s3 = getS3();
		else
			throw new ExceptionTriangle();
	}


	@Override
	public double getPerimeter() {
		return getS1() + getS2() + getS3();
	}
	
	@Override
	public String toString() {
		return "Triangle {s1=" + getS1() + ", " + "s2=" + getS2() + ", " + "s3=" + getS3() + "}";
	}
	
	
}

