package queue;

/**
 * @program: algo
 * @description: 顺序队列
 * @author: ycbron
 * @create: 2021-01-30 17:18
 **/
public class ArrayQueue {

    private String[] items;
    private int n = 0;
    //head：队头下标；tail：队尾下标
    private int head = 0;
    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * @param: item
     * @description: 入队
     * @return: boolean
     * @author: ycbron
     * @date: 2021/1/30
     */
    public boolean enqueue(String item) {
        if(tail == n){
            // tail == n && head == 0 队列已满
            if(head == 0){
                return false;
            }
            for(int i = head; i < tail; i++){
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }
    /**
     * @param:
     * @description: 出队
     * @return: java.lang.String
     * @author: ycbron
     * @date: 2021/1/30
     */
    public String dequeue() {
        //如果head == tail,表示队列为空
        if(head == tail)
            return null;
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for(int i = head; i < tail; i++) {
            System.out.println(items[i] + "");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
        arrayQueue.printAll();
    }
}