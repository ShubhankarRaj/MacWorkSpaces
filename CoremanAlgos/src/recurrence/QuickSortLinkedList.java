package recurrence;

import recurrence.LinkedList.LinkedList;
import recurrence.LinkedList.Node;

/**
 * Created by raj8lm on 30/04/18.
 */
public class QuickSortLinkedList {
    static LinkedList myOriginalLinkedList = new LinkedList();

    public static void main(String[] args) {

        myOriginalLinkedList.push(new Node(6));
        myOriginalLinkedList.push(new Node(-15));
        myOriginalLinkedList.push(new Node(1));
        myOriginalLinkedList.push(new Node(3));
        myOriginalLinkedList.push(new Node(-2));
        myOriginalLinkedList.push(new Node(0));
        myOriginalLinkedList.push(new Node(8));

        System.out.println("HEAD: "+myOriginalLinkedList.head.data);
        System.out.println("TAIL: "+myOriginalLinkedList.tail.data);

        Node printStartNode = myOriginalLinkedList.head;
        do{
            System.out.print(printStartNode.data+"->");
            printStartNode = printStartNode.next;
        } while(printStartNode != null);
        System.out.println();

        Node headForOriginalList = myOriginalLinkedList.head;
        Node tailForOriginalList = myOriginalLinkedList.tail;

        quickSortLinkedList(headForOriginalList, tailForOriginalList);

        System.out.println("After SORTING THE Linked List");

        printStartNode = myOriginalLinkedList.head;
        do{
            System.out.print(printStartNode.data+"->");
            printStartNode = printStartNode.next;
        } while(printStartNode != null);
    }

    static void quickSortLinkedList(Node headForUnsortedList, Node tailForUnsortedList){

        if(headForUnsortedList == tailForUnsortedList)
            return;

        int relPosOfHead = 0, relPosOfTail = 0;

        Node relHead, relTail, partitionNode;
        relHead = myOriginalLinkedList.head;
        while(relHead != headForUnsortedList){
            relHead = relHead.next;
            relPosOfHead++ ;
        }
        relTail = relHead;
        while(relTail != tailForUnsortedList){
            relTail = relTail.next;
            relPosOfTail++ ;
        }

        partitionNode = getPartitionForList(headForUnsortedList, tailForUnsortedList);

        /* Printing the Linked List */
        Node printStartNode = myOriginalLinkedList.head;
        do{
            System.out.print(printStartNode.data+"->");
            printStartNode = printStartNode.next;
        } while(printStartNode != null);
        System.out.println();

        if(partitionNode != null) {
            Node newHeadForList, prevNodeOfPartition, newTailForList;
            newHeadForList = myOriginalLinkedList.head;
            while (relPosOfHead != 0) {
                newHeadForList = newHeadForList.next;
                relPosOfHead--;
            }
            newTailForList = newHeadForList;

            while (relPosOfTail != 0) {
                newTailForList = newTailForList.next;
                relPosOfTail--;
            }

            prevNodeOfPartition = newHeadForList;

            if (partitionNode != myOriginalLinkedList.head) {
                while (prevNodeOfPartition.next != partitionNode) {
                    prevNodeOfPartition = prevNodeOfPartition.next;
                }
            }


            if(newHeadForList == partitionNode){
                quickSortLinkedList(partitionNode.next, newTailForList);
            }
            else if(newTailForList == partitionNode){
                quickSortLinkedList(newHeadForList,prevNodeOfPartition);
            }else{
                quickSortLinkedList(newHeadForList, prevNodeOfPartition);
                quickSortLinkedList(partitionNode.next, newTailForList);
            }
        }else
            return;
    }

    static Node getPartitionForList(Node headForThisList, Node tailForThisList){


        Node pivot = tailForThisList;
        Node currentNode, prevNode;
        currentNode = headForThisList;

        //  Search for the previous Node in the actual LinkedList
        prevNode = myOriginalLinkedList.head;
        if(currentNode != prevNode) {
            while (prevNode.next != currentNode) {
                prevNode = prevNode.next;
            }
        }



        if(currentNode.next == pivot){
            //  This means that it is a linked List of length 2
            if(currentNode != myOriginalLinkedList.head){
                if(currentNode.data > pivot.data){
                    //  Cutting the link with CurrentNode
                    prevNode.next = pivot;
                    //  Setting the Current Node between pivot and pivot.next
                    currentNode.next = pivot.next;
                    //  Setting the next element of pivot as currentNode
                    pivot.next = currentNode;
                    return null;

                }else{
                    //  The sublist is already sorted. Return null
                    return null;
                }
            }else{
                //  This means that there is no previous node
                if(currentNode.data > pivot.data){
                    //  Setting the currentNode after Pivot
                    currentNode.next = pivot.next;
                    //  Setting the pivot before current Node
                    pivot.next = currentNode;
                    //  Setting PIVOT as the head
                    myOriginalLinkedList.head = pivot;
                    return null;
                }else{
                    //  The sublist is already sorted
                    return null;
                }
            }
        }else if(currentNode.next.next == pivot){
            //  This means this it is a linked list of Size 3 and once we get the position of the partition, this sub-list would be auto sorted
            if(currentNode != myOriginalLinkedList.head) {
                while (currentNode != pivot) {
                    if (currentNode.data > pivot.data) {
                        //  Cutting the link with CurrentNode
                        prevNode.next = currentNode.next;
                        //  Setting the current Node between pivot and pivot.next
                        currentNode.next = pivot.next;
                        //  Setting the next element of pivot as current Node
                        pivot.next = currentNode;
                        // Setting the new currentNode
                        currentNode = prevNode.next;
                    } else {
                        currentNode = currentNode.next;
                        prevNode = prevNode.next;
                    }
                }
                return pivot;
            }else{
                //  This means there is no prevNode
                while(currentNode != pivot){
                    if(currentNode.data > pivot.data && currentNode == myOriginalLinkedList.head){
                        //  Shifting the HEAD to the next node
                        myOriginalLinkedList.head = currentNode.next;
                        //  Putting the currentNode which is the Head after Pivot
                        currentNode.next = pivot.next;
                        //  Setting the pivot before the current Node
                        pivot.next = currentNode;
                        //  Setting the new current Node
                        currentNode = myOriginalLinkedList.head;
                        prevNode = currentNode;

                    } else if(currentNode.data > pivot.data && currentNode != myOriginalLinkedList.head){
                        //  This means that we are evaluating the 2nd element with the pivot
                        prevNode = myOriginalLinkedList.head;
                        //  Setting the prevNode to PIVOT
                        prevNode.next = pivot;
                        //  setting the currentNode between pivot
                        currentNode.next = pivot.next;
                        pivot.next = currentNode;
                        currentNode = prevNode.next;
                    } else{
                        currentNode = currentNode.next;

                    }
                }
            }
            return null;
        }else{
            //  This means that the sublist is greater than 3 items. And so a partition Node would be needed to be returned
                while (currentNode != pivot) {
                    if(currentNode != myOriginalLinkedList.head) {
                        if(currentNode.data > pivot.data){
                            //  Cutting the link of the current node
                            prevNode.next = currentNode.next;
                            //  Moving the current node between PIVOT and others
                            currentNode.next = pivot.next;
                            pivot.next = currentNode;
                            currentNode = prevNode.next;
                        }else{
                            currentNode = currentNode.next;
                            prevNode = prevNode.next;
                        }
                    }else{
                        if(currentNode.data > pivot.data){
                            //  Shifting the HEAD to the next node
                            myOriginalLinkedList.head = currentNode.next;
                            //  Putting the currentNode which is the Head after Pivot
                            currentNode.next = pivot.next;
                            //  Setting the pivot before the current Node
                            pivot.next = currentNode;
                            //  Setting the new current Node
                            currentNode = myOriginalLinkedList.head;
                            prevNode = currentNode;
                        }else{
                            currentNode = currentNode.next;
                            prevNode = myOriginalLinkedList.head;

                        }
                    }
                }


        }
        return pivot;
    }
}
