package linkedlist;

/**
 * @program: algo
 * @description: TODO
 * @author: ycbron
 * @create: 2021-07-06 23:11
 **/
public class LinkedListAlgo {

    /**
     * @param: list
     * @description: 单链表反转
     * @return: linkedlist.LinkedListAlgo.Node
     * @author: ycbron
     * @date: 2021/7/6
     */
    public static Node reverse(Node list) {
        //当前结点，前一个结点，后一个结点
        Node cur = list, pre = null, next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
