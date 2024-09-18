package org.example.array;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void displaysll(ListNode current) {
        int count = 0;
        while (current != null) {
            System.out.print(current.data + " ---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int sllLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null) {
            count++;
            current = current.next;
        }
        System.out.println(count);
        return count;
    }

    public void insertAtHead(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        this.head = newNode;
    }

    public void insertAtEnd(ListNode head, int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void insertAtPos(ListNode head, int value, int pos) {
        ListNode newNode = new ListNode(value);
        ListNode previous = head;
        int count = 0;

        if(pos == 0) {
            newNode.next = head;
            this.head = newNode;
        } else {
            while (count < pos - 1) {
                count++;
                previous = previous.next;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }

    }

    public void deleteHead(ListNode head){
        if(head==null){
            return ;
        }
        this.head = head.next;
    }

    public void deleteEnd(ListNode head){
        if(head == null || head.next == null) {
            return;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }

    public void deleteAtPosition(ListNode head, int pos){
        if(head == null){
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        int count = 0;

        if(pos == 0) {
            this.head = head.next;
        }else {
            while (count != pos) {
                count++;
                previous = current;
                current = current.next;
            }
            previous.next = current.next;
        }

    }

    public int findValue(ListNode head, int value) {

        int count = 0;
        ListNode current = head;

        while (current != null) {
            if(current.data == value) {
                System.out.println(count);
                return count;
            }
            count++;
            current = current.next;
        }
        count=-1;
        System.out.println(count);
        return count;
    }

    //loop through the list and perform the following reversal steps
    //Keep next in holding
    //make the current point to the previous
    //make the current guy become previous(push him to the past theirby shifting cursor)
    //then make the next guy we were holding before become current and then let the flow continue
    //when we get to the last guy set the head to the previous
    public void reverseList(ListNode head) {

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        this.head = previous;
    }

    public void forLoopLinkedList(ListNode head) {

        for(ListNode current = head; current != null; current = current.next) {
            System.out.print(current.data + " ---->> ");
        }
        System.out.println(" ");
    }

    //using two pointers a fast and slow pointer
    //fast transverses twice as fast as slow point
    //by the time fast gets to the end the slow must be half way
    public int sllMiddleFinder (ListNode head) {

        ListNode slowPtr = head;
        ListNode fastPtr = head;
        int count = 0;

        while(fastPtr != null && fastPtr.next != null) {
            count++;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        System.out.println("middle index is >> " + count);
        return count;
    }

    public void inverseNthNode (ListNode head, int n) {
        ListNode refPtr = head;
        ListNode mainPtr = head;
        int count = 0;

        while (count < n) {
            count++;
            refPtr = refPtr.next;
        }

        while (refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }

        System.out.println(mainPtr.data);
    }

    public static void main(String[] args) {
        SinglyLinkedList sll =new SinglyLinkedList();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(20);
        ListNode fourth = new ListNode(4);

        sll.head.next = second;
        second.next = third;
        third.next = fourth;

//        ListNode current = sll.head;
        sll.deleteHead(sll.head);
        sll.insertAtHead(sll.head, 77);
        sll.insertAtEnd(sll.head, 3);
        sll.insertAtPos(sll.head, 0, 4);
//        sll.deleteEnd(sll.head);
//        sll.deleteAtPosition(sll.head, 4);
        sll.findValue(sll.head, 4);
        sll.reverseList(sll.head);
        sll.displaysll(sll.head);
//        sll.forLoopLinkedList(sll.head);
        sll.sllMiddleFinder(sll.head);
        sll.sllLength(sll.head);

    }
}
