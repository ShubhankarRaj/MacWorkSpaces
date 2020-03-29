package com.learn.misc;

public class DeleteDuplicateNodes {
    public ListNode deleteDuplicates(ListNode A) {

        ListNode head = null;
        ListNode first = A;
        ListNode middle = null;
        ListNode last = null;
        if(first.next != null) {
            middle = first.next;
        }else {
            //  This is when there is only one element in the Linked List
            return first;
        }

        if(middle.next != null)
            last = middle.next;
        else{
            //  This is when there are only two elements in the Linked List
            if(first.val == middle.val)
                return null;
            else {
                head = first;
                return head;
            }
        }

        //  All of this will happen when there are more than or equal to 3 nodes
        while(first.val == middle.val) {
            while (middle.val == last.val) {
                if(first.val != middle.val)
                    break;
                while (last.next != null && last.val == last.next.val) {
                    last = last.next;
                }
                if (last.next == null)
                    return head;
                else {
                    first = last.next;
                    if (first.next == null) {
                        head = first;
                        return head;
                    } else {
                        middle = first.next;
                    }
                    if (middle.next != null)
                        last = middle.next;
                    else {
                        if (first.val == middle.val)
                            return null;
                        else {
                            head = first;
                            return head;
                        }
                    }
                }
            }
            if(first.val == middle.val) {
                if(last.next != null)
                    first = last;
                else
                    return null;
                if(first.next != null)
                    middle = first.next;
                else{
                    head = first;
                    return head;
                }
                if(middle.next != null)
                    last = middle.next;
            }
        }
        System.out.println("First->"+first.val+" Middle->"+middle.val+" Last->"+last.val);

        if(first.val == middle.val && middle.val != last.val){
            first = last;
            head = first;
            if(last.next != null)
                middle = last.next;
            else
                return head;
            if(middle.next != null)
                last = middle.next;
            else {
                if(first.val == middle.val)
                    return null;
                else {
                    return head;
                }
            }
        }
        head = first;
        //  At this point, the first two elements are unique and head is sorted. Lets fix the remaining Linked List
        while(last != null){

            if(middle.val == last.val){
                while(last.next != null && middle.val == last.val)
                    last = last.next;
                if(last.next == null) {
                    first.next = null;
                    break;
                }
                else{
                    middle = last;
                    first.next = middle;
                    if(middle.next != null)
                        last = middle.next;
                }
            }else{
                first = middle;
                middle = last;
                last = last.next;
            }

        }

        return head;
    }

    public static void main(String[] args) {

            ListNode first = new ListNode(1);
            first.next = new ListNode(1);
            first.next.next = new ListNode(1);
            first.next.next.next = new ListNode(1);
            first.next.next.next.next = new ListNode(1);
            first.next.next.next.next.next = new ListNode(1);
            first.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next.next.next.next.next = new ListNode(2);
            first.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(7);
            first.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(8);
            first.next.next.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(8);

            DeleteDuplicateNodes del = new DeleteDuplicateNodes();

            ListNode nonDuplicate = del.deleteDuplicates(first);
            while(nonDuplicate != null) {
                System.out.print(nonDuplicate.val+"-");
                nonDuplicate = nonDuplicate.next;
            }


        }

}
