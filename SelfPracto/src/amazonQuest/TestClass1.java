package amazonQuest;

public class TestClass1 {
	void test1(){
		System.out.println("Class1 Test1");
	}
	void test2(){
		System.out.println("Class 1 Test2");
	}
	public static void main(String args[]){
		TestClass1 tc1 = new TestClass2();
		System.out.println("In tc1 ");
		tc1.test1();
		tc1.test2();
		System.out.println("In tc2");
		TestClass2 tc2 = new TestClass2();
		tc2.test1();
		tc2.test2();
		tc2.test3();
		
	}
}
class TestClass2 extends TestClass1{
	void test1(){
		System.out.println("Class2 Test1");
	}
	void test3(){
		System.out.println("Class 2 Test3");
	}
	
}
