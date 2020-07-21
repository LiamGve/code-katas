import static java.lang.String.format;

public class Solution {
    /**
     * Problem: given a <em>singly</em> linked list, write a function with input of
     * type Node that is the node you wish to delete from the linked list. This function
     * should not return anything. This function should also have no knowledge of previous
     * nodes in linked list.
     *
     * Example:
     *  Given linked list:
     *      {1} -> {2} -> {3} -> {4} -> {5}
     *
     *  If we call
     *      removeNthNode({3})
     *
     *  Then linked list should be:
     *      {1} -> {2} -> {4} -> {5}
     */
    public static void main(String... args) {
        final Node linkedList = initLinkedList();

        System.out.println(linkedList);

        removeNthNode(linkedList.next.next); // Remove 3

        System.out.println(linkedList);
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

    // Runtime: O(1)
    // Space: O(1)
    private static void removeNthNode(final Node nthNode) {
        Node newNext = nthNode.next.next;
        int newData = nthNode.next.data;

        nthNode.next = newNext;
        nthNode.data = newData;
    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
    }

    // Runtime O(N)
    void addNode(int data) {
        final Node newNode = new Node(data);

        Node current = this;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    public String toString() {
        final StringBuilder linkedList = new StringBuilder();
        linkedList.append(format("{%s}", data));
        Node current = this;
        while (current.next != null) {
            current = current.next;
            linkedList.append(format("->{%s}", current.data));
        }
        return linkedList.toString();
    }
}