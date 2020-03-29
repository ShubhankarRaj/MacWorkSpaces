package com.learn.misc;

public class SolMergeSortedLinkedList {
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode mergedSortedList = null;
        ListNode returnHeadNode = null;
        ListNode pointerForListA = A;
        ListNode pointerForListB = B;
        while(pointerForListA != null || pointerForListB != null){

            if((pointerForListA !=null && pointerForListB !=null) && (pointerForListA.val < pointerForListB.val)) {
                if(mergedSortedList == null) {
                    mergedSortedList = new ListNode(pointerForListA.val);
                    returnHeadNode = mergedSortedList;
                }
                else {
                    mergedSortedList.next = new ListNode(pointerForListA.val);
                    mergedSortedList = mergedSortedList.next;
                }

                pointerForListA = pointerForListA.next;

            }
            else if((pointerForListA !=null && pointerForListB !=null) && (pointerForListB.val < pointerForListA.val)){
                if(mergedSortedList == null) {
                    mergedSortedList = new ListNode(pointerForListB.val);
                    returnHeadNode = mergedSortedList;
                }
                else {
                    mergedSortedList.next = new ListNode(pointerForListB.val);
                    mergedSortedList = mergedSortedList.next;
                }
                pointerForListB = pointerForListB.next;

            }
            else if((pointerForListA !=null && pointerForListB !=null) && (pointerForListB.val == pointerForListA.val)){
                if(mergedSortedList == null) {
                    mergedSortedList = new ListNode(pointerForListB.val);
                    returnHeadNode = mergedSortedList;
                    //  Adding the duplicate element
                    mergedSortedList.next = new ListNode(pointerForListA.val);
                    mergedSortedList = mergedSortedList.next;
                }
                else {
                    mergedSortedList.next = new ListNode(pointerForListB.val);
                    mergedSortedList = mergedSortedList.next;
                    //  Adding the duplicate element
                    mergedSortedList.next = new ListNode(pointerForListA.val);
                    mergedSortedList = mergedSortedList.next;
                }
                pointerForListA = pointerForListA.next;
                pointerForListB = pointerForListB.next;
            }
            else if(pointerForListA == null){
                mergedSortedList.next = new ListNode(pointerForListB.val);
                pointerForListB = pointerForListB.next;
                mergedSortedList = mergedSortedList.next;
            }
            else if(pointerForListB == null){
                mergedSortedList.next = new ListNode(pointerForListA.val);
                pointerForListA = pointerForListA.next;
                mergedSortedList = mergedSortedList.next;
            }
        }

       if(pointerForListA != null)
            mergedSortedList.next = pointerForListA;
        else if(pointerForListB != null)
            mergedSortedList.next = pointerForListB;


        return returnHeadNode;
    }

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);


        ListNode sec = new ListNode(1);
        sec.next = new ListNode(6);
        sec.next.next = new ListNode(7);
        sec.next.next.next = new ListNode(8);

        SolMergeSortedLinkedList sol = new SolMergeSortedLinkedList();
        ListNode mergedNode = sol.mergeTwoLists(first, sec);

        System.out.println("First Input");
        while(first != null) {
            System.out.print(first.val + " -> ");
            first = first.next;
        }
        System.out.println("\nSecond Input");
        while(sec != null) {
            System.out.print(sec.val + " -> ");
            sec = sec.next;
        }
        System.out.println("\n Merged Output");
        while(mergedNode != null) {
            System.out.print(mergedNode.val + " -> ");
            mergedNode = mergedNode.next;
        }

    }
}
