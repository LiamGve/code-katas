import java.util.HashSet;
import java.util.Set;

import static java.lang.String.format;

public class Solution {
    /**
     * Given an unsorted linked list. Remove the duplicates. Provide 2 solutions where:
     *
     *  Solution 1: Use of a buffer is allowed
     *  Solution 2: Solution must have no buffer and run in O(1) Space
     *
     * Example:
     *
     *  Input:
     *    {4}->{5}->{3}->{9}->{7}->{10}->{3}->{9}->{9}
     *  Output:
     *    {4}->{5}->{3}->{9}->{7}->{10}
     *
     */
    public static void main(String... args) {
        // Solution 2
        final Node linkedList = initLinkedList();
        linkedList.print();
        linkedList.removeDuplicatesNoBuffer();
        linkedList.print();

        // Solution 1
        final Node linkedList2 = initLinkedList();
        linkedList2.print();
        linkedList2.removeDuplicatesBuffer();
        linkedList2.print();
    }

    // Purely for testing. Change these numbers to whatever you like...
    private static Node initLinkedList() {
        Node head = new Node(4);
        head.addNode(5);
        head.addNode(3);
        head.addNode(9);
        head.addNode(7);
        head.addNode(10);
        head.addNode(3);
        head.addNode(9);
        head.addNode(9);
        return head;
    }
}

class Node {
    private Node next;
    private int data;

    Node(int data) {
        this.data = data;
    }

    // Runtime O(N)
    void addNode(int data) {
        final Node newNode = new Node(data);

        Node current  = this;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Runtime O(N)
    void print() {
        System.out.print(format("{%s}", data));
        Node current = this;
        while (current.next != null) {
            current = current.next;
            System.out.print(format("->{%s}", current.data));
        }
        System.out.println();
    }

    // Runtime O(N^2)
    // Space O(1)
    void removeDuplicatesNoBuffer() {
        if (next == null) {
            return;
        }

        Node p1 = this;

        while (p1 != null) {

            Node p2 = p1.next;
            Node prev = p1;

            while (p2 != null) {
                if (p1.data == p2.data) {
                    prev.next = p2.next;
                } else {
                    prev = p2;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }

    // Runtime O(N)
    // Space O(N)
    void removeDuplicatesBuffer() {
        if (next == null) {
            return;
        }
        final Set<Integer> seenInt = new HashSet<>();

        seenInt.add(data);

        Node current = next;
        Node prev = this;

        while (current != null) {
            if (seenInt.contains(current.data)) {
                prev.next = current.next;
            } else {
                seenInt.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
}