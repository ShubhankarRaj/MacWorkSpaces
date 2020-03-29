package class1;

public class StringLearning {

	int i = 1;
	
	void abc(){
		System.out.println(i);
	}

	public static void main(String[] args) {
		String abc = "hello";
		
		String xyz = new String("hello");
		if(xyz == abc){
			System.out.println("They are equal using ==");
		}
		else{
			System.out.println("They are not equal");
		}
		
		System.out.println(abc.equals(xyz));
		
		System.out.println(xyz.charAt(2));
		System.out.println(xyz.equals("hexxx"));
		System.out.println(xyz.compareTo("hexxx"));
		System.out.println(xyz.equalsIgnoreCase("HELLO"));
		System.out.println(xyz.startsWith("hel"));
		System.out.println(xyz.endsWith("llo"));
		System.out.println(xyz.length());
		System.out.println(xyz.concat(" how are you"));
		System.out.println(xyz.contains("10000"));
		System.out.println(xyz.substring(2, 4));
		
	}
}
