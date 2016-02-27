package amazonQuest;

import java.util.Scanner;

public class Browser_Forward_Back_Stack {
	public static void main(String args[]){
		MyStack forwardStack = new MyStack(10);
		MyStack backwardStack = new MyStack(10);
		String curURL = "", prevURL = "";
		System.out.println("Kindly Enter the ULRs which you want to NAVIGATE: \n");
		Scanner scnInput = new Scanner(System.in);
		String usrInput = scnInput.nextLine();
		while(!usrInput.equals("QUIT")){
			System.out.println(usrInput);
			String curntResponse = usrInput;
			if(curntResponse.split(" ").length >1){
				System.out.println("Current Response is URL");
				String[]res = curntResponse.split(" ");
				curURL = res[1];
			}
			if(curntResponse.startsWith("VISIT")){
				if(prevURL!=""){
					backwardStack.push(prevURL);
				}
				System.out.println(curURL);
			}
			if(curntResponse.startsWith("BACK")){
//				if(!forwardStack.peek().equals(prevURL)){
//					forwardStack.push(prevURL);
//				}
				if(!backwardStack.peek().equals("")){
				System.out.println(backwardStack.peek());
				backwardStack.pop();
				forwardStack.push(prevURL);
				}else
					System.out.println("IGNORE");
			}
			if(curntResponse.startsWith("FORWARD")){
//				if(!backwardStack.peek().equals(prevURL)){
//						backwardStack.push(prevURL);
//				}
				if(!forwardStack.peek().equals("")){
					System.out.println(forwardStack.peek());
					forwardStack.pop();
				}else{
					System.out.println("IGNORE");
				}
			}
			
			prevURL = curURL;
			System.out.println("Enter the next Response");
			usrInput = scnInput.nextLine();
		}
	}
}

class MyStack{
	private int MAXSIZE;
	private String[] stackArray;
	private int top;
	
	public MyStack(int s){
		MAXSIZE = s;
		stackArray = new String[MAXSIZE];
		top = -1;
	}
	
	public void push(String topOfStack){
		stackArray[++top] = topOfStack;
	}
	
	public String pop(){
		return stackArray[top--];
	}
	
	public String peek(){
		if(top == -1){
			return "The Limit is Reached";
		}
		return stackArray[top];
	}
}
