package class1;

public class Employee {

	private int id;

	protected String name;

	protected String deptName = "C.S.E.";

	protected float sal;

	// setter method to set value of id
	void setId(int empId) {
		id = empId;
	}
	
	void setId() {

	}
	
	int getId() {
		return id;
	}

	void setName(String nameOfTheEmployee) {
		name = nameOfTheEmployee;
	}

	public void setDepartment(String dp) {
		deptName = dp;
	}

	public void setSal(float s) {
		sal = s;
	}



	

	// int Employee(int i) {
	// return id;
	// }

	// user defined default constructor
	// by default java will create this
	public Employee() {
		
	}

	// Employee(int empid, String empName, String dept) {
	// id = empid;
	// name = empName;
	// deptName = dept;
	// }

	
	// overloaded constructors
	public Employee(int empid, String empName, String dept, float empSal) {
		id = empid;
		name = empName;
		deptName = dept;
		sal = empSal;
	}

	// overloaded constructors
	Employee(String empName, int empid, String dept, int empSal) {
		id = empid;
		name = empName;
		deptName = dept;
		sal = empSal;
	}

	public static void main(String[] args) {
		// Employee emp = new Employee("Ram", 100, "Dev", 3);
		// System.out.println(emp.id);
		// System.out.println(emp.name);
		// System.out.println(emp.deptName);
		// System.out.println(emp.sal);
		//
		// Employee emp2 = new Employee();
		// System.out.println(emp2.id);
		// System.out.println(emp2.name);
		// System.out.println(emp2.deptName);
		// System.out.println(emp2.sal);

		Employee emp11 = new Employee();
		emp11.setId(100);
		emp11.setId(3999);
		
		// int id = emp11.Employee(10);
		System.out.println(emp11.getId());
		System.out.println(emp11.name);
		System.out.println(emp11.deptName);
		System.out.println(emp11.sal);

	}

}
