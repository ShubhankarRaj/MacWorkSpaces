package class1;

public class TestCalculator{
	public static void main(String args[]){
		CalculatorImpl ci = new CalculatorImpl();
		System.out.println(ci.add(5, 6));
		System.out.println(ci.mult(3, 4));
		
		CalculatorImpl2 ci2 = new CalculatorImpl2();
		System.out.println(ci2.add(5, 6));
		System.out.println(ci2.mult(3, 4));
	}

}
