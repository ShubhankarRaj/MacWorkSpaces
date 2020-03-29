package class1;

public class TestEmp {
	public static void main(String[] args) {

		ContractEmp contEmp = new ContractEmp();

		contEmp.setDepartment("test");
		contEmp.setEnddate("2014 march 31");
		contEmp.setId(10);
		contEmp.setName("contEMp");

		PermEmp perEmp = new PermEmp();

		perEmp.setDepartment("test");
		perEmp.setBenifits("med, transp");
		perEmp.setId(10);
		perEmp.setName("contEMp");

	}
}
