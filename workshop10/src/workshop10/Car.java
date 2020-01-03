package workshop10;

import java.io.Serializable;

public class Car implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String model;
	private String color;
	private double mileage;
	private String registration;
	
	public Car(String model, String color, double mileage) {
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.registration = "unregistered";
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		if(model != null)
			this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		if(color != null)
			this.color = color;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		if(mileage > 0.0)
			this.mileage = mileage;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}
	
	
	@Override
	public String toString() {
		return "Model: " + getModel()+
				" Color: " + getColor()+
				" Mileage: " + getMileage()+
				" Registration: "+ getRegistration();
	}
	public void getRegistration(String plate) {
		this.registration = plate;
	}

}
