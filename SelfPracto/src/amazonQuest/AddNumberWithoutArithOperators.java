package amazonQuest;

public class AddNumberWithoutArithOperators {
	public static void main(String args[]){
		int a = 3270, b= 567880;
		System.out.println("The sum of two numbers is "+addWithoutOperator(a, b));;
	}
	static int addWithoutOperator(int x, int y){
			if(y == 0) return x;
			int sum = x ^ y;
			System.out.println("Value of \"SUM\" :"+sum);
			int carry = (x & y) << 1;
			System.out.println("Value of \"carry\" with left shift: "+carry);
			return addWithoutOperator(sum, carry);
	}
}
