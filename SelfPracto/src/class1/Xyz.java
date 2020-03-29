package class1;

public class Xyz implements CalcInterface{

	public int add(int a, int b) {
		return a+b;
	}

	public int mult(int a, int b) {
		int result =a;
		for(int i=1;i<=b;i++){
			result = result + result;
		}
		return 0;
	}

}
