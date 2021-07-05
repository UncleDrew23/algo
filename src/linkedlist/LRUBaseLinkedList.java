package linkedlist;

import java.util.Scanner;

/**
 * @program: algo
 * @description: 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历链表.
 *
 * @author: ycbron
 * @create: 2021-07-05 22:32
 **/
public class LRUBaseLinkedList<T> {

    public class SNode<T>{
        private T element;
        private SNode next;

        public SNode(T element, SNode next) {
            this.element = element;
            this.next = next;
        }

        public SNode(T element){
            this.element = element;
        }

        public SNode(){
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public SNode getNext() {
            return next;
        }

        public void setNext(SNode next) {
            this.next = next;
        }
    }

    // 默认链表容量
    private final static Integer DEFAULT_CAPACITY = 10;

    //头结点
    private SNode<T> headNode;

    //链表长度
    private Integer length;

    //链表容量
    private Integer capacity;

    public LRUBaseLinkedList(){
        this.headNode = new SNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }

    public LRUBaseLinkedList(Integer capacity){
        this.headNode = new SNode<>();
        this.capacity = capacity;
        this.length = 0;
    }

    /**
     * @param: data
     * @description: 获取查找元素的前一个结点
     * @return: linkedlist.LRUBaseLinkedList<T>.SNode
     * @author: ycbron
     * @date: 2021/7/5
     */
    private SNode findPreNode(T data){
        SNode node = headNode;
        while (node.getNext() != null){
            if(data.equals(node.getNext().getElement())){
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * @param: preNode
     * @description: 删除 preNode 结点的下一个结点
     * @return: void
     * @author: ycbron
     * @date: 2021/7/5
     */
    private void deleteNextElem(SNode preNode){
        SNode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * @param: data
     * @description: 链表头部插入结点 头结点不动
     * @return: void
     * @author: ycbron
     * @date: 2021/7/5
     */
    private void insertElemAtBegin(T data){
        SNode node = headNode.getNext();
        headNode.setNext(new SNode(data, node));
        length++;
    }

    /**
     * @param:
     * @description: 删除尾部结点
     * @return: void
     * @author: ycbron
     * @date: 2021/7/6
     */
    private void deleteElemAtLast(){
        SNode node = headNode;
        //头结点为哨兵
        if(node.getNext() == null){
            return;
        }
        //倒数第二个结点
        while (node.getNext().getNext() != null){
            node = node.getNext();
        }
        SNode tmp = node.getNext();
        node.setNext(null);
        tmp = null;
        length--;
    }

    public void add(T data){
        //如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部
        SNode node = findPreNode(data);
        if(node != null){
            deleteNextElem(node);
            insertElemAtBegin(data);
        }
        else {
            //如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部
            if(length >= capacity){
                deleteElemAtLast();
            }
            //如果此时缓存未满，则将此结点直接插入到链表的头部
            insertElemAtBegin(data);
        }
    }

    private void printAll(){
        SNode node = headNode.getNext();
        while (node != null){
            System.out.print(node.getElement() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUBaseLinkedList linkedList = new LRUBaseLinkedList();
        Scanner scanner = new Scanner(System.in);
        while (true){
            linkedList.add(scanner.nextInt());
            linkedList.printAll();
        }
    }
}
