package queue;

/**
 * @program: algo
 * @description: TODO
 * @author: ycbron
 * @create: 2021-01-30 18:51
 **/
public class DynamicArrayQueue {
    private String[] items;
    private int n = 0;
    //head：队头下标；tail：队尾下标
    private int head = 0;
    private int tail = 0;

    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public boolean enqueue(String item) {
        if(tail == n) {
            //表示队列已满
            if(head == 0)
                return false;
            //数据搬移
            for(int i = head; i < tail; i++ ) {
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

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
            System.out.println(i + " " +items[i] + " ");
        }
        System.out.println(tail);
    }

    public static void main(String[] args) {
        DynamicArrayQueue arrayQueue = new DynamicArrayQueue(5);
        arrayQueue.enqueue("1");
        arrayQueue.enqueue("2");
        arrayQueue.enqueue("3");
        arrayQueue.enqueue("4");
        arrayQueue.enqueue("5");
        arrayQueue.dequeue();
        arrayQueue.dequeue();
//        arrayQueue.enqueue("6");
        arrayQueue.printAll();
    }
}
