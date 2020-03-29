package com.learn.misc;

import java.util.HashMap;
import java.util.Map;

public class SolLinkedListIntersection {
    public ListNode getIntersectionNode(ListNode a, ListNode b) {
        ListNode intersectionNode = null;
        Map<Integer, Integer> mapOfKeyAndRecurrence = new HashMap<>();
        if(a.val == b.val){
            intersectionNode = a;
            return intersectionNode;
        }
        int occurence = 1;
        mapOfKeyAndRecurrence.put(b.val, occurence);
        mapOfKeyAndRecurrence.put(a.val, occurence);
        ListNode nextA = a.next;
        ListNode nextB = b.next;
        while(nextA != null || nextB != null){
            if(nextA.val == nextB.val) {
                intersectionNode  = nextA;
            }
            else{
                if(!mapOfKeyAndRecurrence.containsKey(nextA.val))
                    mapOfKeyAndRecurrence.put(nextA.val,1);
                else{
                    intersectionNode = nextA;
                    return intersectionNode;
                }
                if(!mapOfKeyAndRecurrence.containsKey(nextB.val))
                    mapOfKeyAndRecurrence.put(nextB.val, 1);
                else {
                    intersectionNode = nextB;
                    return intersectionNode;
                }
            }
            if(nextA.next != null)
                nextA = nextA.next;
            if(nextB.next != null)
                nextB = nextB.next;
        }
        return intersectionNode;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);

        ListNode second = new ListNode(-1);
        second.next = new ListNode(0);
        second.next.next = new ListNode(1);
        second.next.next.next = new ListNode(2);
        second.next.next.next.next = new ListNode(3);

        SolLinkedListIntersection sol = new SolLinkedListIntersection();
        sol.getIntersectionNode(first, second);
    }

}
class ListNode{
    public int val;
    public ListNode next;

    ListNode(int x){
        val = x; next = null;
    }

}

