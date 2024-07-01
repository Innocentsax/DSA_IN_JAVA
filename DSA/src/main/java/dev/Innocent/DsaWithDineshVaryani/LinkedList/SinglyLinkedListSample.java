package dev.Innocent.DsaWithDineshVaryani.LinkedList;

public class SinglyLinkedListSample {
    private ListNode head;

    private static class ListNode{
        private int data; // Generic Type
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListSample sll = new SinglyLinkedListSample();
        sll.head = new ListNode(10);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);

        // Now will connect them together to form a chain
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
    }
}
