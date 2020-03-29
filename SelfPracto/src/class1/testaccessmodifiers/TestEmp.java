package class1.testaccessmodifiers;

import class1.AbsExample;
import class1.Employee;

public class TestEmp extends Employee {

	public static void main(String[] args) {
		Employee emp = new Employee(100, "sam", "test", 30);
		
		(new TestEmp()).help();
	}

	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int mult(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	public void help(){
		String newDept = deptName;
		System.out.println(newDept);
		System.out.println("Hey This is PUBLIC");
	}
}
