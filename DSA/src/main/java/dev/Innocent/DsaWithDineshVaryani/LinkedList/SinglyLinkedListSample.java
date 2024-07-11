package dev.Innocent.DsaWithDineshVaryani.LinkedList;

public class SinglyLinkedListSample {
    private static ListNode head;

    private static class ListNode{
        private final int data; // Generic Type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListSample sll = new SinglyLinkedListSample();
        sll.insertNodeAtPosition(10, 1);
        sll.insertNodeAtPosition(20, 2);
        sll.insertNodeAtPosition(30, 3);
        sll.insertNodeAtPosition(9, 1);
        sll.insertNodeAtPosition(19, 3);
        sll.insertNodeAtPosition(29, 5);
        sll.insertNodeAtPosition(39, 7);
//        sll.insertNodeAtEnd(45);
//        sll.insertNodeAtEnd(34);
//        sll.insertNodeAtEnd(2);
//        head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        // Now will connect them together to form a chain
//        head.next = second;
//        second.next = third;
//        third.next = fourth;

        sll.display();
        System.out.println(sll.deleteFirstNode().data);
        sll.display();
    }

    private void display(){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // How to find the Length of a Singly Linked List
    private int LengthOfSinglyLinkedList(){
        if(head == null){
            return 0;
        }
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    private void insectNode(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    // Insert a node at the end of the singly linked list
    private void insertNodeAtEnd(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current = head;
        while(null != current.next){
            current = current.next;
        }
        current.next = newNode;
    }

    // QA: Implement a method to insert a node at a given position in the singly linked list.
    // assuming that the position is valid t and start from  position 1
    private void insertNodeAtPosition(int value, int position){
        ListNode newNode = new ListNode(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count < position - 1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    public ListNode deleteFirstNode(){
        if(head == null){
            return null;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp;
    }
}
