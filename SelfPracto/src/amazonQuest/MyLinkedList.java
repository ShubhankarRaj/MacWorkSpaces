package amazonQuest;

public class MyLinkedList {
	public static void main(String args[]){
		LinkedListPvt lList = new LinkedListPvt();
		lList.add("1");
		lList.add("2");
		lList.add("3");
		lList.add("5");
		lList.add("10");
		lList.add("101");
		lList.add("21");
		lList.add("12");
		lList.add("69");
		System.out.println("lList - print linkedlist: " + lList);
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.remove(2) - remove 2nd element: " + lList.remove(2));
        System.out.println("lList.get(3) - get 3rd element: " + lList.get(3));
        System.out.println("lList.size() - print linkedlist size: " + lList.size());
        System.out.println("lList - print linkedlist: " + lList);

		
	}
	
}
class LinkedListPvt{
		//	Reference to the Head node
		private Node head;
		private int listCount;
	public LinkedListPvt(){
		//	At the beginning, any of the list would be empty
		head = new Node(null);
		listCount = 0;
	}
	public void add(Object data){
		Node linkedListTemp = new Node(data);
		Node linkedListCurrent = head;
		
		while(linkedListCurrent.next != null){
			linkedListCurrent = linkedListCurrent.getNext();
		}
		
		//	We are setting the new node as the next node of the last node of the current linked list
		linkedListCurrent.setNext(linkedListTemp);
		listCount++;
	}
	
	//	Returns the element of the specified position in the list
	public Object get(int index){
		//	index must be 1 or higher
		if(index <= 0)
			return null;
		
		Node linkedListCurrent = head.getNext();
		for(int i=1; i < index; i++){
			if(linkedListCurrent.getData() == null)
				return null;
			linkedListCurrent = linkedListCurrent.getNext();
			
		}
		return linkedListCurrent.getData();
	}
	
	public boolean remove(int index){
		//	Removing the element at the specified position in the list
		//	If the index is out of range, then Exit
		if(index < 1 || index > size()){
			return false;
		}
		Node linkedListCurrent = head;
		for(int i = 1; i < index; i++){
			if(linkedListCurrent.getNext() == null)
					return false;
			linkedListCurrent = linkedListCurrent.getNext();
		}
		linkedListCurrent.setNext(linkedListCurrent.getNext().getNext());
		listCount--;
		return true;
	}
	public int size(){
		return listCount;
	}
	public String toString(){
		Node linkedListCurrent = head.getNext();
		String output = "";
		while(linkedListCurrent != null){
			output += "[" + linkedListCurrent.getData().toString() + "]";
			linkedListCurrent = linkedListCurrent.getNext();
		}
		return output;
	}
	
	private class Node{
		//	A node will have two things: Data and reference to the next node
		Node next;
		// 	The data of the node can be of any type. Hence the type should be Object
		Object data;
		
		//	Node constructor
		public Node(Object dataValue){
			next = null;
			data = dataValue;
		}
		//	Node can also be created, where the next value of the Node is pre-determined
		public Node(Object dataValue, Node nextValue){
			next = nextValue;
			data = dataValue;
		}
		public Object getData(){
			return data;
		}
		public void setData(Object dataValue){
			data = dataValue;
		}
		public void setNext(Node nextValue){
			next = nextValue;
		}
		public Node getNext(){
			return next;
		}
	}
	
}
