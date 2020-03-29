package class1;

public class Test1 {
	int a = 10;
	public static void main(String args[]){
		String obj1 = new String("Aa");
		String obj2 = new String("BB");
		System.out.println("hashCode for an String is " + obj1.hashCode());
		System.out.println("hashCode for a String is " + obj2.hashCode());
	}
}
