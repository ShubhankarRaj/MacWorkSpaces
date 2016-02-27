package geekForGeek;

public class viewForBST {
	public static void main(String args[]){
		//	Creating the root node
		BSTnode newBST = new BSTnode(20);
		
		// Adding nodes to the root node
		newBST.left = new BSTnode(10);
		newBST.right = new BSTnode(25);
		
		newBST.left.left = new BSTnode(8);
		newBST.left.right = new BSTnode(12);
		
		newBST.right.right = new BSTnode(40);
		newBST.right.left = new BSTnode(22);
		
		//	Creating the RIGHT view of the tree.
		printRightView(newBST);
		
		printLeftView(newBST);
		
	}
	
	private static void printRightView(BSTnode tree){
		System.out.println("Printing the Right View");
		while(tree != null){
			System.out.println(tree.nodeData);
			tree = tree.right;
		}
	}
	
	private static void printLeftView(BSTnode tree){
		System.out.println("Printing the Left View");
		while(tree != null){
			System.out.println(tree.nodeData);
			tree = tree.left;
		}
	}
}
class BSTnode{
	Integer nodeData;
	BSTnode left, right;
	
	public BSTnode(int value){
		this.nodeData = value;
	}
}
