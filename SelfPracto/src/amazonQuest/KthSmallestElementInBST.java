package amazonQuest;

import java.util.Stack;

/*
 * To find the Kth smallest element in the Binary Search Tree, we can have couple of approaches.
 * One of them is used here. We are using the Inline traversal for going through the BST from the root.
 * Travel to the least value of the BST.
 * Increase the counter by 1.
 * Go to it's parent and check if it has a child node in the right.
 * If yes, then go to the left most element on the right side of the parent node.
 * Increment the counter by 1 every time we encounter a child node.
 * Return the Node when counter = K;
 */

public class KthSmallestElementInBST {
	static binarySearchTreeNode root;

	class binarySearchTreeNode {
		public Integer data = 0;
		public binarySearchTreeNode left;
		public binarySearchTreeNode right;

		public binarySearchTreeNode(Integer data) {
			this.data = data;
		}

	}

	public void addNode(int node) {
		if (root == null) {
			root = new binarySearchTreeNode(node);
			return;
		}

		binarySearchTreeNode refNode = root;
		while (true) {
			if (node < refNode.data) {
				if (refNode.left == null) {
					refNode.left = new binarySearchTreeNode(node);
					break;
				}
				refNode = refNode.left;
			}else{
				if(refNode.right == null){
					refNode.right = new binarySearchTreeNode(node);
					break;
				}
				refNode = refNode.right;
			}
		}
	}
	
	public int kthSmallest(binarySearchTreeNode binaryTreeRoot, int k){
		int result = 0;
		Stack<binarySearchTreeNode> stack = new Stack<binarySearchTreeNode>();
		
		binarySearchTreeNode testNode = binaryTreeRoot;
		
		while(!stack.isEmpty() || testNode!=null){
			if(testNode != null){
				stack.push(testNode);
				testNode = testNode.left;
			}else{
				binarySearchTreeNode stackNode = stack.pop();
				k--;
				if(k == 0){
					return stackNode.data;
				}
				testNode = stackNode.right;
			}
		}
		
		return result;
	}
	
	public static void main(String args[]){
		KthSmallestElementInBST newBST = new KthSmallestElementInBST();
		newBST.addNode(6);
		newBST.addNode(4);
		newBST.addNode(8);
		newBST.addNode(5);
		newBST.addNode(9);
		newBST.addNode(1);
		int kk = 2;
		System.out.println("The "+kk+"th Smallest element in the BST is "+newBST.kthSmallest(root, kk));
	}

}
