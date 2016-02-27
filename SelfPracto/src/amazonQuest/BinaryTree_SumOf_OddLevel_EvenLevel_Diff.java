package amazonQuest;

public class BinaryTree_SumOf_OddLevel_EvenLevel_Diff {
/*	5 -2 -6 + 1 + 4 + 8 - 3 - 7 -9
	(5+1+4+8)-(2+6+3+7+9) = 18 - 27 = -9*/
	static diffNode head;
	public static void main(String args[]){
		head = new diffNode(1);
		
		head.left = new diffNode(2);
		head.right = new diffNode(6);
		
		head.left.left = new diffNode(4);
		head.left.right = new diffNode(10);
		
		head.right.left = new diffNode(8);
		head.right.right = new diffNode(3);
		
		System.out.println("Calculated Difference between sum of Even and Odd Levels: "+getLevelDiff(head));
	}
	
	public static int getLevelDiff(diffNode node){
		
		if(node == null){
			return 0;
		}
		
		return node.data - getLevelDiff(node.left) - getLevelDiff(node.right);
		
	}
}

class diffNode{
	Integer data;
	diffNode left, right;
	
	public diffNode(int value){
		this.data = value;
	}
}
