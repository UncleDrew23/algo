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

    /**
     * @param: list
     * @description: 环的检测
     * @return: boolean
     * @author: ycbron
     * @date: 2021/7/8
     */
    public static boolean checkCircle(Node list) {
        if(list == null){
            return false;
        }
        Node fast = list.next;
        Node slow = list;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param: l1
     * @param: l2
     * @description: 合并两个有序链表
     * @return: linkedlist.LinkedListAlgo.Node
     * @author: ycbron
     * @date: 2021/7/8
     */
    public Node mergeTwoLists(Node l1, Node l2) {
        Node soldier = new Node(0);
        Node p = soldier;
        while (l1 != null && l2 != null){
            if(l1.data < l2.data){
                p.next = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        if(l1 == null) p.next = l2;
        if(l2 == null) p.next = l1;
        return soldier.next;
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }
    }
}
