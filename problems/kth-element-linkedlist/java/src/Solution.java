public class Solution {
    /**
     * Problem:
     *  Return the kth element from the end of a singly linked list.
     *
     * Example:
     *
     *   Given the linked list:
     *      4 -> 5 -> 3 -> 9 -> 7 -> 10 -> 3 -> 9 -> 9
     *
     *      findKthElementFromEnd(1) == 9
     *      findKthElementFromEnd(2) == 9
     *      findKthElementFromEnd(5) == 7
     *      findKthElementFromEnd(6) == 9
     */
    public static void main(String... args) {
        final Node linkedList = initLinkedList();

        Node output = linkedList.findKthElementFromEnd(5);

        System.out.println(output.data); // 7
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

    // Runtime complexity O(N)
    // Space complexity O(1)
    Node findKthElementFromEnd(int index) {
        int count = 0;

        Node current = this;
        while(current != null) {
            count++;
            current = current.next;
        }

        int pointInList = count - index;

        current = this;
        while(pointInList != 0) {
            current = current.next;
            pointInList--;
        }

        return current;
    }
}