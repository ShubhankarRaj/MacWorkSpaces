package recurrence;

/**
 * Created by raj8lm on 29/04/18.
 */
public class QuicksortSingleLinkedList {
    static QuicksortSingleLinkedList linkedList;
    Node head, tail;

    static class Node{
        int data;
        Node next;

        public Node (int value){
            this.data = value;
            this.next = null;
        }

    }

    public void push(Node node){
        if (head != null){
            if(head.next == null){
                head.next = node;
            }
            if (tail == null) {
                tail = node;
                tail.next = null;
            }else{
                tail.next = node;
                tail = node;
                tail.next = null;
            }

        }else{
            head = node;
        }
    }

    public static void main(String[] args){
        QuicksortSingleLinkedList myLinkedList = new QuicksortSingleLinkedList();
        myLinkedList.push(new Node(6));
        myLinkedList.push(new Node(15));
        myLinkedList.push(new Node(1));
        myLinkedList.push(new Node(3));
        myLinkedList.push(new Node(-2));
        myLinkedList.push(new Node(10));
        myLinkedList.push(new Node(8));

        System.out.println("HEAD: "+myLinkedList.head.data);
        System.out.println("TAIL: "+myLinkedList.tail.data);

        Node currentNode = myLinkedList.head;
        System.out.println("Before Sorting the");
        while(currentNode != null){
            System.out.print(currentNode.data+" -> ");
            currentNode = currentNode.next;
        }
        System.out.println();
        myLinkedList = quickSortSinglyLinkedList(myLinkedList);

        currentNode = myLinkedList.head;
        System.out.println("After Sorting the");
        while(currentNode != null){
            System.out.print(currentNode.data+" -> ");
            currentNode = currentNode.next;
        }

    }

    public static QuicksortSingleLinkedList quickSortSinglyLinkedList(QuicksortSingleLinkedList unsortedLinkedList){
        linkedList = unsortedLinkedList;
        quickSort(linkedList.head, linkedList.tail);
        return linkedList;
    }

    static void quickSort(Node h, Node t){

        if(h == null || t == null){
            return;
        }

        Node listToPartedAt = partition(h,t);

        Node partitionPrevNode;
        if(listToPartedAt == linkedList.head) {
            partitionPrevNode = null;
        }
        else{
            partitionPrevNode = h;
            while(partitionPrevNode.next != listToPartedAt){
                partitionPrevNode = partitionPrevNode.next;
            }
        }
        quickSort(h, partitionPrevNode);
        quickSort(listToPartedAt.next, t);

    }

    static Node partition(Node a, Node b){

        if(a == b){
            return a;
        }

        Node currentHeadNode, currentTailNode, currentNode, previousNode, pivotNode;

        currentHeadNode = previousNode = linkedList.head;
        boolean previousNodeIncrementIndicator = false;

        while(currentHeadNode != a){
            currentHeadNode = currentHeadNode.next;
            if(previousNodeIncrementIndicator)
                previousNode = previousNode.next;

            previousNodeIncrementIndicator = true;
        }
        currentTailNode = currentHeadNode;
        while(currentTailNode != b){
            currentTailNode = currentTailNode.next;
        }
        currentNode = currentHeadNode;
        pivotNode = currentTailNode;

        while(currentNode != pivotNode) {
            if (currentNode.data > pivotNode.data) {
                    if(currentNode != linkedList.head) {
                        previousNode.next = currentNode.next;
                        currentNode.next = currentTailNode.next;
                        currentTailNode.next = currentNode;
                        currentTailNode = currentTailNode.next;
                        currentNode = previousNode.next;
                    }else{
                        linkedList.head = linkedList.head.next;
                        currentNode.next = currentTailNode.next;
                        currentTailNode.next = currentNode;
                        currentTailNode = currentTailNode.next;
                        currentNode = linkedList.head;
                    }


            }else{
                if(currentNode == linkedList.head){
                    previousNode = linkedList.head;
                }else {
                    previousNode = previousNode.next;
                }
                currentNode = currentNode.next;
            }
        }
        return pivotNode;

    }
}
