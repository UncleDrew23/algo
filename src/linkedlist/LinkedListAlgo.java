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

    /**
     * @param: list
     * @param: k
     * @description: 删除链表倒数第 K 个结点
     * @return: linkedlist.LinkedListAlgo.Node
     * @author: ycbron
     * @date: 2021/7/10
     */
    public static Node deleteLastKth(Node list, int k){
        Node fast = list;
        int i = 1;
        while (fast != null && i < k){
            fast = fast.next;
            i++;
        }
        if(fast == null) {
            return list;
        }

        Node pre = null;
        Node slow = list;
        while (fast.next != null){
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if(pre == null) {
            list = list.next;
        }
        else {
            pre.next = pre.next.next;
        }
        return list;
    }

    /**
     * @param: list
     * @param: k
     * @description: 删除链表倒数第 K 个结点（添加哨兵结点）
     * @return: linkedlist.LinkedListAlgo.Node
     * @author: ycbron
     * @date: 2021/7/10
     */
    public static Node deleteLastKth1(Node list, int k){
        if(list == null) return list;
        Node soldier = new Node(0, list);
        Node fast = soldier.next;
        Node slow = soldier;
        while ( k > 0){
            fast = fast.next;
            k--;
        }
        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return  soldier.next;
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
