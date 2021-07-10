package stack;

/**
 * @program: algo
 * @description: 基于链表实现栈
 * @author: ycbron
 * @create: 2021-07-10 13:39
 **/
public class StackBaseOnLinkedList {

    private Node top = null;

    public void push(int value){
        Node newNode = new Node(value, null);
        if(top == null){
            top = newNode;
        }
        else {
            //头部插入 后进先出
            newNode.next = top;
            top = newNode;
        }
    }

    public int pop(){
        if(top == null) return -1;
        int value = top.data;
        top = top.next;
        return value;
    }

    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
