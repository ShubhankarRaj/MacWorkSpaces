package com.interview.bit.linkedlist;

import java.util.Stack;

public class ReorderList {
    public static ListNode reorderList(ListNode A) {
        Stack<ListNode> stack = new Stack<>();

        if(A.next == null)
            return A;

        ListNode pointer = A;

        stack.push(pointer);
        int counter = 0;
        while(pointer.next != null){
            counter++;
            pointer = pointer.next;
            stack.push(pointer);
        }

        int mergeCounter = counter/2;

        ListNode head = A;
        ListNode next = A.next;
        while(mergeCounter > 0){
            if((stack.peek().val != head.val) && (stack.peek().val != next.val)) {
                ListNode node = stack.pop();
                head.next = node;
                node.next = next;
                mergeCounter--;
                if(mergeCounter == 0){
                    head = node.next;
                    if(counter%2 != 0)
                     head.next.next = null;
                    else{
                     head.next = null;
                    }
                    break;
                }
                head = node.next;
                next = next.next;
            }else{
                next.next = null;
                break;
            }


        }

        return A;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = new ListNode(7);

        ListNode response = reorderList(root);
    }
}
