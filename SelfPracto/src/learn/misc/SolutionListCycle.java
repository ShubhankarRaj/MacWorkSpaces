package com.learn.misc;

public class SolutionListCycle {
    public ListNode detectCycle(ListNode a) {

        //  Approach - 1. First detect loop in the linked list 2. After detection, count the loop size. 3. Find the start point of the loop.
        ListNode loopStart = null;

        int loopSize = checkLoopExists(a);
        if(a.next == a)
            return a;
        if(loopSize != 1)
        {
            ListNode firstPointer = a;
            ListNode secPointer = a;
            while(loopSize != 1){
                secPointer = secPointer.next;
                loopSize --;
            }
            while(firstPointer != secPointer.next){
                firstPointer = firstPointer.next;
                secPointer = secPointer.next;
            }

            loopStart = firstPointer;
        }

        return loopStart;

    }

    public int checkLoopExists(ListNode list){
        ListNode hare = list;
        ListNode turtle = list;
        boolean loopExists = false;

        int loopSize = 1;

        while(hare.next != null && hare.next.next!=null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare.val == turtle.val){
                loopExists = true;
                break;
            }
        }

        if(loopExists){
            while(hare.next != turtle){
                hare = hare.next;
                loopSize++;
            }
        }

        //  If there is no loop, then return 0
        return loopSize;
    }



    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = first;
        /*first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        first.next.next.next.next.next = new ListNode(6);
        first.next.next.next.next.next.next = first.next.next;*/

        SolutionListCycle sol = new SolutionListCycle();
        System.out.println(sol.detectCycle(first).val);
        }

    }
