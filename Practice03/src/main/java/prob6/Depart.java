package prob6;

public class Depart extends Employee {
	String department;
	
	public Depart(String name, int salary, String department) {
		super(name, salary);
		this.department = department;
	}	

	public void getInformation() {
		System.out.printf("이름: %s   연봉: %d  부서:%s \n", getName(), getSalary(),department);
	}
}
