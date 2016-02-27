package amazonQuest;

public class SequencePoint {
	public static void main(String args[]){
		int a = 20, b = 30, c = 0;
		c = a++ + a++;
		System.out.println(c);
		c = b++ + b++ + c; 
		System.out.println(c);
		c = c++ + ++c + c;
		System.out.println(c);
		c = ++b + ++a + c;
		
		System.out.println(c);
	}
}
