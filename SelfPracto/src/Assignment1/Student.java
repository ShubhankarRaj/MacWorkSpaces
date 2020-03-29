package Assignment1;

public class Student {
	
	private String nameOfStudent, name = null;
	private int marksOfStudent, marks = 0;
	public Student(String name,int marks){
		setName(name);
		setMarks(marks);
		calculate_Mark();
	}
	private void setName(String name){
		nameOfStudent = name;
	}
	public String getName(){
		return nameOfStudent;
	}
	private void setMarks(int marks){
		marksOfStudent = marks;
	}
	public int getmarks(){
		return marksOfStudent;
	}
	public void calculate_Mark(){
		if(marksOfStudent <= 50 && marksOfStudent >= 40)
			System.out.println(""+nameOfStudent+" has received Third Class marks");
		if(marksOfStudent <= 59 && marksOfStudent >= 51)
			System.out.println(""+nameOfStudent+" has received Secondd Class marks");
		if(marksOfStudent >= 60)
			System.out.println(""+nameOfStudent+" has received First Class marks");
		if(marksOfStudent < 40)
			System.out.println("The student "+nameOfStudent+" has failed");
	}
}
