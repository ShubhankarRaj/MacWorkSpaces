package amazonQuest;

import java.util.HashMap;
import java.util.Map;

public class CloneLinkedListWithNextAndRandomPointer {
	public static void main(String args[]){
		//	Pushing data in the LINKED LIST
		LinkedList list = new LinkedList(new Node(5));
		list.push(4);
		list.push(3);
		list.push(2);
		list.push(1);
		list.push(10);
		
		//	Setting up random references
		list.head.random = list.head.next.next;
		list.head.next.random = list.head.next.next.next;
		list.head.next.next.random =list.head.next.next.next.next.next;
		list.head.next.next.next.random = list.head.next;
		list.head.next.next.next.next.random = list.head.next.next.next.next.next;
		list.head.next.next.next.next.next.random = list.head.next.next.next.next;
		
		//	Making a clone of the linked list
		LinkedList clone = list.clone();
		
		System.out.println("Printing the Original linked List: ");
		list.print();
		System.out.println("Printing the CLONED linked list: ");
		clone.print();
	}
}
class Node{
	int data;
	Node next, random;
	
	public Node(int data){
		this.data = data;
		this.next = this.random = null;
	}
}
class LinkedList{
	Node head;
	
	public LinkedList(Node head){
		this.head = head;
	}
	
	//	In Linked list, we push the new data always at the head
	public void push(int data){
		Node node = new Node(data);
		node.next = this.head;
		this.head = node;
	}
	
	//	Print the Linked List
	void print(){
		Node temp = head;
		while(temp != null){
			Node random = temp.random;
			int randomData = (random != null) ? random.data:-1;
			System.out.println("Data = "+temp.data+" and RandomData = "+random.data);
			temp = temp.next;
		}
	}
	
	//	Actual clone method which returns
	//	head reference of cloned linked list
	public LinkedList clone(){
		//	Initialize two references, one with original
		//	list's head
		Node origCurr = this.head, cloneCurr = null;
		
		Map<Node, Node> map = new HashMap<Node, Node>();
		
		while(origCurr != null){
			cloneCurr = new Node(origCurr.data);
			map.put(origCurr, cloneCurr);
			origCurr = origCurr.next;
		}
		
		origCurr = this.head;
		
		while(origCurr != null){
			cloneCurr = map.get(origCurr);
			cloneCurr.next = map.get(origCurr.next);
			cloneCurr.random = map.get(origCurr.random);
			origCurr = origCurr.next;
		}
		
		// Return the head reference of the CLONE list
		return new LinkedList(map.get(this.head));
	}
	
	
}