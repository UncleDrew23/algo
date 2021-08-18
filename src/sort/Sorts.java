package sort;

/**
 * @program: algo
 * @description: 冒泡排序、插入排序、选择排序
 * @author: ycbron
 * @create: 2021-08-18 23:28
 **/
public class Sorts {
    /**
     * @param: a
     * @param: n
     * @description: 冒泡排序
     * @return: void
     * @author: ycbron
     * @date: 2021/8/18
     */
    public static void bubbleSort(int[] a, int n) {
        if(n <= 1) return;
        for(int i = 0; i < n; i++) {
            //  提前退出标志位
            boolean flag = false;
            for(int j = 0; j < n - i - 1; j++){
                if(a[j] > a[j + 1]){    //数据交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;
                }
            }
            if(!flag){
                break;  //无数据交换，直接退出
            }
        }
    }

    /**
     * @param: a
     * @param: n
     * @description: 冒泡排序改进:在每一轮排序后记录最后一次元素交换的位置,作为下次比较的边界,对于边界外的元素在下次循环中无需比较.
     * @return: void
     * @author: ycbron
     * @date: 2021/8/19
     */
    public static void bubbleSort2(int[] a, int n) {
        if(n <= 1) return;
        int lastExchange = 0; //最后一次交换的位置
        int sortBorder = n - 1; //无序数据的边界，每次比较到这里即可
        for(int i = 0; i < n; i++){
            boolean flag = false;
            for(int j = 0; j < sortBorder; j++){
                if(a[j] > a[j + 1]) {
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;
                    lastExchange = j;
                }
            }
            sortBorder = lastExchange;
            if(!flag) break;
        }
    }


    public static void insertionSort(int[] a, int n) {
        if(n <= 1) return;
        for(int i = 1; i < n; i++){
            int value = a[i];
            int j = i -1;
            for(; j >= 0; --j) {
                if(a[j] > value) {
                    a[j + 1] = a[j];
                }
                else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }
}
