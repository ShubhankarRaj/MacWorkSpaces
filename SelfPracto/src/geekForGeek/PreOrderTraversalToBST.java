
package geekForGeek;

/**
 * @author raj8lm
 *   10
   /   \
  5     40
 /  \      \
1    7      50
For a binary tree as mentioned above, the pre-order traversal would be in this order:
ROOT-LESS THAN ROOT VALUE-Same as Before for Child Node-Greater THAN ROOT VALUE
For the above tree the output of the PreOrderTraversal would be - [10,5,1,7,40,50]

To construct BST from the traversal, it should be like this - [1,5,7,10,40,50]

 *
 */

public class PreOrderTraversalToBST {
	class Node{
		int value;
		Node left, right;
		
		Node(int d){
			value = d;
			left = right = null;
		}
	}
	
	class Index{
		int index = 0;
	}
	class BinaryTree{
		Index index = new Index();
		
		Node constructTreeFromPreOrderTraversalAndReturnRoot(int[] preOrder, int sizeOfArray){
			
		}
		
	}
	
	public static void main(String args[]){
		PreOrderTraversalToBST potToBST = new PreOrderTraversalToBST();
		BinaryTree tree = potToBST.new BinaryTree();
		int pre[] = new int[]{12,10,5,1,3,11,25,23,26};
		int size = pre.length;
		//Node root
	}
}
