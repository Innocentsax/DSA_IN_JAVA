/*
Write a function that takes in the head of a Singly Linked List, reverses the list in place (i.e., doesn't create a brand new list), and returns its new head.

Each LinkedList node has an integer value as well as a next node pointing to the next node in the list or to None / null if it's the tail of the list.

You can assume that the input Linked List will always have at least one node; in other words, the head will never be None / null.

Sample Input
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 // the head node with value 0
Sample Output
5 -> 4 -> 3 -> 2 -> 1 -> 0 // the new head node with value 5
*/



import java.util.*;

class Program {
    public static LinkedList reverseLinkedList(LinkedList head) {
        LinkedList prev = null;
        LinkedList current = head;
        LinkedList nextNode;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    static class LinkedList {
        int value;
        LinkedList next = null;

        public LinkedList(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // Creating the linked list: 0 -> 1 -> 2 -> 3 -> 4 -> 5
        LinkedList head = new LinkedList(0);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(4);
        head.next.next.next.next.next = new LinkedList(5);

        LinkedList newHead = reverseLinkedList(head);

        // Printing the reversed linked list: 5 -> 4 -> 3 -> 2 -> 1 -> 0
        LinkedList current = newHead;
        while (current != null) {
            System.out.print(current.value + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
