package array;

/**
 * @program: algo
 * @description: 范型数组
 * @author: ycbron
 * @create: 2021-06-27 16:02
 **/
public class GenericArray<T> {
    private T[] data;
    private int size;

    public GenericArray(int capacity){
        this.data =(T[]) new Object[capacity];
        this.size = 0;
    }

    //无参构造方法
    public GenericArray() {
        this(10);
    }

    /**
     * @param:
     * @description: 获取数组容量
     * @return: int
     * @author: ycbron
     * @date: 2021/6/27
     */
    public int getCapacity(){
        return data.length;
    }

    /**
     * @param:
     * @description: 获取当前元素个数
     * @return: int
     * @author: ycbron
     * @date: 2021/6/27
     */
    public int count() {
        return size;
    }

    /**
     * @param:
     * @description: 判断数组是否为空
     * @return: boolean
     * @author: ycbron
     * @date: 2021/6/27
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @param: index
     * @description: 获取对应 index 位置上的元素
     * @return: T
     * @author: ycbron
     * @date: 2021/6/27
     */
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Add failed! Require index >=0 and index < size.");
        }
        return data[index];
    }

    /**
     * @param: index
     * @param: e
     * @description: 修改对应 index 位置上的元素
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    public void set(int index, T e){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Set failed! Require index >=0 and index < size.");
        }
        data[index] = e;
    }
    /**
     * @param: e
     * @description: 查看数组是否包含元素 e
     * @return: boolean
     * @author: ycbron
     * @date: 2021/6/27
     */
    public boolean contains(T e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return true;
            }
        }
        return false;
    }

    /**
     * @param: e
     * @description: 获取对应元素 e 的下标，若未找到，则返回 -1
     * @return: int
     * @author: ycbron
     * @date: 2021/6/27
     */
    public int find(T e){
        for(int i = 0; i < size; i++){
            if(data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    /**
     * @param: capacity
     * @description: 数组扩容
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    private void resize(int capacity){
        T[] newData =(T[]) new Object[capacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * @param: index
     * @param: e
     * @description: 在数组的 index 位置插入元素 e
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    public void add(int index, T e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed! Require index >= 0 and index <= size .");
        }
        if(size == data.length){
            resize(2 * size);
        }
        for(int i = size -1; i >= index; i--){
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * @param: e
     * @description: 数组头插入元素 e
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    public void addFirst(T e){
        add(0, e);
    }

    /**
     * @param: e
     * @description: 数组尾部插入元素 e
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    public void addLast(T e){
        add(size, e);
    }

    /**
     * @param: index
     * @description: 删除索引为 index 的元素并返回
     * @return: T
     * @author: ycbron
     * @date: 2021/6/27
     */
    public T remove(int index){
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed! Require index >=0 and index < size.");
        }
        T ret = data[index];
        for(int i = index + 1 ; i < size; i++){
            data[i -1] = data[i];
        }
        size--;
        data[size] = null;

        //缩容
        if(size == data.length / 4 && data.length / 2 != 0){
            resize(data.length / 2);
        }

        return ret;
    }

    /**
     * @param:
     * @description: 删除数组第一个元素
     * @return: T
     * @author: ycbron
     * @date: 2021/6/27
     */
    public T removeFirst(){
        return remove(0);
    }

    /**
     * @param:
     * @description: 删除数组最后一个元素
     * @return: T
     * @author: ycbron
     * @date: 2021/6/27
     */
    public T removeLast(){
        return remove(size - 1);
    }

    /**
     * @param: e
     * @description: 从数组中删除指定元素 e
     * @return: void
     * @author: ycbron
     * @date: 2021/6/27
     */
    public void removeElement(T e){
        int index = find(e);
        if(index != -1){
            remove(index);
        }
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Array size = %d, capacity = %d", size, data.length));
        stringBuilder.append("[");
        for(int i = 0; i < size; i++){
            stringBuilder.append(data[i]);
            if(i != size -1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
