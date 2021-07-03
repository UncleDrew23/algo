package linkedlist;

/**
 * @program: algo
 * @description: TODO
 * @author: ycbron
 * @create: 2021-07-03 13:36
 **/
public class SinglyLinkedList {

    // 构造单链表结点
    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }
        public int getData() {
            return data;
        }
    }
    //头结点
    private Node head = null;

    public Node findByValue(int value){
        Node p = head;
        while(p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    public Node findByIndex(int index){
        int pos = 0;
        Node p = head;
        while(p != null && pos != index){
            p = p.next;
            pos++;
        }
        return p;
    }

    //头部插入 逆序
    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if(head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head = newNode;
        }
    }

    //尾部插入 顺序
    public void insertTail(int value){
        Node newNode = new Node(value,null);
        if(head == null){
            head = newNode;
        }
        else {
            Node p = head;
            while (p.next != null){
                p = p.next;
            }
            newNode.next = null;
            p.next = newNode;
        }
    }

    //在结点后插入
    public void insertAfter(Node p, Node newNode){
        if(p == null) return;
        newNode.next = p.next;
        p.next = newNode;
    }
    public void insertAfter(Node p ,int value){
        Node newNode = new Node(value,null);
        insertAfter(p, newNode);
    }

    //在结点前插入
    public void insertBefore(Node p,int value){
        Node newNode = new Node(value,null);
        insertBefore(p, newNode);
    }
    public void insertBefore(Node p,Node newNode){
        if(p == null) return;
        if(head == p){
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if(q == null){
            return;
        }
        newNode.next = q.next;
        q.next = newNode;
    }

    //根据结点删除
    public void deleteByNode(Node p){
        if(p == null || head == null) return;
        if(head == p){
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }
        if(q == null) return;
        q.next = p.next;
    }
    //根据结点值删除
    public void deleteByValue(int value){
        if(head == null) return;
        Node p = head;
        Node q = null;

        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }
        if(p == null) return;
        if(p == head){
            head = head.next;
        }
        else {
            q.next = q.next.next;
        }
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }
    //判断是否是回文
    public boolean palindrome(){
        if(head == null){
            return false;
        }
        else {
            System.out.println("开始查找中间结点！");
            Node p = head;
            Node q = head;
            if(p.next == null){
                System.out.println("只有一个元素！");
                return true;
            }
            while (p.next != null && p.next.next != null){
                p = p.next.next;
                q = q.next;
            }
            System.out.println("中间结点 " + q.data);
            Node left = null;
            Node right = null;
            //链表结点数目为奇数
            if(p.next == null){
                right = q.next;
                left = inverseLinkList(q).next;
            }
            else {
                right = q.next;
                left = inverseLinkList(q).next;
            }
            return TFResult(left, right);
        }
    }

    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;
        boolean flag = true;
        while (l != null && r != null){
            if(l.data == r.data){
                l = l.next;
                r= r.next;
                continue;
            }
            else {
                flag = false;
                break;
            }
        }
        return flag;
    }
    //链表反转
    public Node inverseLinkList(Node p){
        //前驱结点
        Node pre = null;
        //后继结点
        Node next = null;
        //当前结点
        Node cur = head;
        while (cur != p){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur.next = pre;
        return  cur;
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList();
        int[] data = {1,2,3,2,3};
        for(int i = 0; i < data.length; i++){
            linkedList.insertTail(data[i]);
        }
        linkedList.printAll();
        if(linkedList.palindrome()){
            System.out.println("回文！");
        }
        else {
            System.out.println("不是回文！");
        }
    }
}
