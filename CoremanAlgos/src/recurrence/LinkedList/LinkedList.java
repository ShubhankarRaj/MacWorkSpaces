package recurrence.LinkedList;


/**
 * Created by raj8lm on 30/04/18.
 */
public class LinkedList {
    public Node head, tail;

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
}
