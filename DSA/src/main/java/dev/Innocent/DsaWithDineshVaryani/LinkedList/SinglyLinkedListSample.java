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
        sll.insectNode(45);
        sll.insectNode(34);
        sll.insectNode(2);
        head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Now will connect them together to form a chain
        head.next = second;
        second.next = third;
        third.next = fourth;

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
}
