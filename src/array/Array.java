package array;

/**
 * @program: algo
 * @description: 数组的插入、删除、下标随机访问
 * @author: ycbron
 * @create: 2021-06-27 14:47
 **/
public class Array {
    //定义整形数据 data 保存数据
    public int data[];
    //数组长度
    private int n;
    //数组实际存储数据的个数
    private int count;

    //数组的构造方法
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }
    
    /**
     * @param: index
     * @description: 根据索引，查找数组中的元素并返回
     * @return: int
     * @author: ycbron
     * @date: 2021/6/27
     */
    public int find(int index){
        if(index < 0 || index >= count) return -1;
        return data[index];
    }

    /**
     * @param: index
     * @param: value
     * @description: 插入元素到 index
     * @return: boolean
     * @author: ycbron
     * @date: 2021/6/27
     */
    public boolean insert(int index, int value){
        //位置满了
        if(n == count){
            System.out.println("没有可以插入的位置！");
            return false;
        }
        //插入位置不合法
        if(index < 0 || index > count){
            System.out.println("插入的位置不合法！");
            return false;
        }
        //插入位置合法
        for(int i = count; i > index; --i){
            data[i] = data[i-1];
        }
        data[index] = value;
        ++count;
        return true;
    }
    /**
     * @param: index
     * @description: 删除下标为  index 的元素
     * @return: boolean
     * @author: ycbron
     * @date: 2021/6/27
     */
    public boolean delete(int index){
        if(index < 0 || index >= n){
            System.out.println("删除的位置不合法！");
            return false;
        }
        for(int i = index; i < count-1; ++i){
            data[i] = data[i+1];
        }
        --count;
        return true;
    }

    public void printAll(){
        for(int i = 0; i < count; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0,3);
        array.insert(1,5);
        array.insert(2,6);
        array.insert(1,19);
        array.printAll();
        array.delete(2);
        array.printAll();
        array.delete(0);
        array.printAll();
    }
}
