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
        sll.deleteEnd(sll.head);
        sll.deleteAtPosition(sll.head, 4);
        sll.displaysll(sll.head);
        sll.sllLength(sll.head);

    }
}
