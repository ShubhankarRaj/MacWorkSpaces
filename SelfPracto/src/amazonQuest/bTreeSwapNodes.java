package amazonQuest;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class bTreeSwapNodes {
	
	public void bTreeSwapNodes(){
		NodeNew root = getNodeNew();
		System.out.println("\n\n Swapping the nodes of Binary Tree");
		HashMap<Integer, NodeNew> Map = new HashMap<Integer, NodeNew>();
		int val1 = 9;
		int val2 = 6;
		
		if (root.data == val1){
			Map.put(val1, root);
		}else if(root.data == val2){
			Map.put(val2,  root);
		}
		
		printBFS(root);
		findToSwap(root, val1, val2, Map);
		
		NodeNew parentNode1 = Map.get(val1);
		NodeNew node1 = parentNode1;
		if(parentNode1 != root){
			if(parentNode1.left.data == val1){
				node1 = parentNode1.left;
			} else if(parentNode1.right.data == val2){
				node1 = parentNode1.right;
			}
		}
		
		NodeNew parent2 = Map.get(val2);
		NodeNew node2 = Map.get(val2);
		if(parent2 == root) {
			node2 = parent2;
		} else if( parent2.left.data == val2 ) {
			node2 = parent2.left;
		} else if( parent2.right.data == val2 ) {
			node2 = parent2.right;
		}
		
		if(parentNode1 != root) {
			if( parentNode1.left.data == val1 ) {
				parentNode1.left = node2;
			} else if( parentNode1.right.data == val1 ) {
				parentNode1.right = node2;
			}
		}

		if(parent2 != root) {
			if( parent2.left.data == val2 ) {
				parent2.left = node1;
			} else if( parent2.right.data == val2 ) {
				parent2.right = node1;
			}
		}

		NodeNew templeft = node1.left;
		NodeNew tempright = node1.right;

		node1.left = node2.left;
		node1.right = node2.right;
		node2.left = templeft;
		node2.right = tempright;
		System.out.println("/n/n After swapping the numbers");
		printBFS(root);		
		
	}
	
	public NodeNew getNodeNew(){
		NodeNew root = new NodeNew(5);
		root.left = new NodeNew(3);
		root.left.left = new NodeNew(1);
		root.left.right = new NodeNew(4);
		root.right = new NodeNew(9);
		root.right.left = new NodeNew(6);
		return root;
	}
	
	private void printBFS(NodeNew root){
		ArrayDeque<NodeNew> que = new ArrayDeque<NodeNew>();
		que.offerLast(root);
		
		while(!que.isEmpty()){
			NodeNew nNode = que.pollFirst();
			System.out.println("\t->\t"+nNode.data);
			
			if(nNode.left != null){
				que.offerLast(nNode.left);
			}
			if(nNode.right != null){
				que.offerLast(nNode.right);
			}
		}
	}
	
	private void findToSwap(NodeNew node, int val1, int val2, Map<Integer, NodeNew> nMap){
		ArrayDeque<NodeNew> que = new ArrayDeque<NodeNew>();
		que.offerLast(node);
		
		while(!que.isEmpty() && nMap.size() < 2){
			NodeNew n = que.pollFirst();
			
			if(n.left != null){
				que.offerLast(n.left);
				
				if(n.left.data == val1){
					nMap.put(val1, n);
				}else if(n.left.data == val2){
					nMap.put(val2, n);
				}
			}
			
			if(n.right != null){
				que.offerLast(n.right);
				
				if(n.right.data == val1){
					nMap.put(val1, n);
				}else if(n.right.data == val2){
					nMap.put(val2, n);
				}
			}
			
			
		}
	}
	
	public static void main(String args[]){
		bTreeSwapNodes swapNodesObj = new bTreeSwapNodes();
		swapNodesObj.bTreeSwapNodes();
	}
}

class NodeNew{
	public Integer data=0;
	public NodeNew right;
	public NodeNew left;
	
	public NodeNew(Integer data){
		this.data = data;
	}
}


