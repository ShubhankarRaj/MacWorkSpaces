package InterviewBit.LinkedListImpl;

/**
 * Created by raj8lm on 19/09/18.
 */
public class SolReverseLinkListBetIndexes {

    public ListNode reverseBetween(ListNode A, int B, int C) {
        int startPointer = 1;
        ListNode head = A;
        ListNode prevNodeOfPointOfReversal = null;
        ListNode nodeAlreadyReversed = null;
        ListNode nodeToBereversed = null;
        ListNode headOfReveresedNode = new ListNode(0);
        ListNode currentNode = null;

        while(A != null){

            if(B < startPointer && startPointer < C){
                currentNode = nodeToBereversed;
                nodeToBereversed = A.next;
                currentNode.next = nodeAlreadyReversed;
                nodeAlreadyReversed = currentNode;
            }

            else if(startPointer == B - 1){
                prevNodeOfPointOfReversal = A;
            }

            else if(startPointer == B){
                currentNode = A;
                prevNodeOfPointOfReversal.next = null;
                headOfReveresedNode.val = A.val;
                nodeAlreadyReversed = headOfReveresedNode;
                nodeToBereversed = currentNode.next;
            }

            else if(startPointer == C){
                headOfReveresedNode.next = nodeToBereversed.next;
                currentNode = nodeToBereversed;
                currentNode.next = nodeAlreadyReversed;
                prevNodeOfPointOfReversal.next = currentNode;
            }

            else if(startPointer == B && startPointer ==1){
                headOfReveresedNode = A;
                nodeToBereversed = A;
                nodeAlreadyReversed = A;
                nodeToBereversed = nodeToBereversed.next;
            }

            if(A.next != null)
                A = A.next;
            else
                break;

            startPointer++;
        }
        if(B > 1)
            return head;
        else{
            if(C == startPointer)
                return A;
            if(C < startPointer)
                return head;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode newNode = new ListNode(2);
        newNode.next = new ListNode(3);
        newNode.next.next = new ListNode(4);
        newNode.next.next.next = new ListNode(5);
        newNode.next.next.next.next = new ListNode(6);

        SolReverseLinkListBetIndexes sol = new SolReverseLinkListBetIndexes();
        ListNode reversedNode = sol.reverseBetween(newNode, 2, 4);
        while (reversedNode != null){
            System.out.print(reversedNode.val+"->");
            reversedNode = reversedNode.next;
        }


    }


}



