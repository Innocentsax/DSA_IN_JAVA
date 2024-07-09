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
        sll.insertNodeAtEnd(45);
        sll.insertNodeAtEnd(34);
        sll.insertNodeAtEnd(2);
//        head = new ListNode(10);
//        ListNode second = new ListNode(1);
//        ListNode third = new ListNode(8);
//        ListNode fourth = new ListNode(11);
//
//        // Now will connect them together to form a chain
//        head.next = second;
//        second.next = third;
//        third.next = fourth;

//         Print it on the console
        ListNode current = head;
        while(current != null){
            int result = current.data;
            System.out.print(result + " ---> ");
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
}
