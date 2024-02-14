public class LinkedList {
    // 1. Node structure
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // 2. Push operation
    Node head;

    void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    // 3. Detect loop and print result
    void detectLoopAndPrint() {
        Node slow = head, fast = head;
        boolean loopFound = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Loop found");
                loopFound = true;
                break; // Exit the loop once the loop is detected
            }
        }

        if (!loopFound) {
            System.out.println("Loop not found");
        }
    }

    // 4. Main method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(20);
        list.push(41);
        list.push(5);
        list.push(10);

        // 5. Creating a loop for testing
        // Ensure the list has at least one node before creating a loop
        if (list.head != null && list.head.next != null && list.head.next.next != null && list.head.next.next.next != null) {
            list.head.next.next.next.next = list.head; // Creating a loop for testing
        }

        list.detectLoopAndPrint();
    }
}