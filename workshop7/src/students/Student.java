package students;

import java.text.DecimalFormat;

public class Student {
	
	private static DecimalFormat format = new DecimalFormat("0.00");
	private String firstName;
	private String lastName;
	private double grade;
	private String department;
	
	public Student(String f, String l, double g, String d) throws Exception {
		if(f != null && f != " " && l != null && l != " " && g >= 0 && d != null && d != " ") {
			this.firstName = f;
			this.lastName = l;
			this.grade = g;
			this.department = d;
		}else
			throw new Exception("Invalid data!");
	}
	
	public String getName() {		
		return getFirstName() + " " + getLastName();
		
	}
	
	boolean equal(Object obj) {
		return super.equals(obj);
		
	}
	
	@Override
	public String toString() {
		return String.format("%-9s", getFirstName()) +
		        String.format("%-12s", getLastName()) +
		        String.format("%-8s", format.format(getGrade()))+
		        String.format("%-12s", getDepartment());
		
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) throws Exception {
		if(firstName != null)
			this.firstName = firstName;
		else
			throw new Exception("Invalid data!");
			
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) throws Exception {
		if(lastName != null)
			this.lastName = lastName;
		else
			throw new Exception("Invalid data!");
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		if(grade >= 0)
			this.grade = grade;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) throws Exception {
		if(department != null)
			this.department = department;
		else
			throw new Exception("Invalid data!");
	}

	
}
