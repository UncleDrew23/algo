package queue;

/**
 * @program: algo
 * @description: 链式队列（基于链表实现队列）
 * @author: ycbron
 * @create: 2021-01-30 20:16
 **/
public class QueueBasedLinkedList {
    private class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }

    private Node head = null;
    private Node tail = null;

    public void enqueue(String value) {
        if (tail == null) {
            Node node = new Node(value, null);
            tail = node;
            head = node;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    private String dequeue() {
        if (head == null) return null;
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

}
