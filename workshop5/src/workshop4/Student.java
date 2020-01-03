package workshop4;
import java.util.ArrayList;


public class Student implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int stdID;
	private String firstName;
	private String lastName;
	private ArrayList<String> courses;
	
	
	//constructor
	public Student() {
		courses = new ArrayList<String>();
	}
		
	//getter and setter	
	public String getFullName() {
		return getFirstName() + ' ' + getLastName();		
	}
	
	public int getStdID() {
		return stdID;
	}
	
	public void setStdID(int stdID) throws StudentException {
		if(stdID > 0)
			this.stdID = stdID;
		else 
			throw new StudentException("Invalid Student ID!");
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) throws StudentException {
		if(firstName.isEmpty())
			throw new StudentException("Invalid First Name!");
		else
			this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) throws StudentException {
		if(lastName.isEmpty())
			throw new StudentException("Invalid Last Name!");
		else
			this.lastName = lastName;
	}
	
	public ArrayList<String> getCourses() {
		return this.courses;
	}
	
	public void setCourses(String course) throws StudentException {
		if(course.isEmpty()) 
			throw new StudentException("Invalid Courses!");
		else 
			this.courses.add(course);
		
	}

	public void setCourses(ArrayList<String> courses) throws StudentException {
		if(courses.isEmpty()) 
			throw new StudentException("Invalid Courses!");
		else {
			for(String course:courses) {
				this.courses.add(course);
			}
		}
			
		
	}
		
}
