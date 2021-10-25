package sort;

import java.util.Arrays;

/**
 * @program: algo
 * @description: 快速排序（先分区，再处理子问题）自上而下
 * @author: ycbron
 * @create: 2021-10-06 22:54
 **/
public class QuickSort {
    // 快速排序， a 代表数组， n 表示数组大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n -1);
    }

    // 快速排序递归函数
    private static void quickSortInternally(int[] a, int p, int r) {
        if(p >= r) return;
        // 获取分区点
        int q = partition(a, p, r);
        quickSortInternally(a, p ,q - 1);
        quickSortInternally(a, q + 1, r);
    }

    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for(int j = p; j < r; j++) {
            if(a[j] < pivot) {
                if(i == j){
                    ++i;
                }
                else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i = " + i);
        return i;
    }

    /**
     * @param: a
     * @param: l
     * @param: r
     * @param: k
     * @description: 求无序数组中第 K 大的元素 （利用快排分区的思想）
     * @return: int
     * @author: ycbron
     * @date: 2021/10/26
     */
    private static int getKthSmallest(int[] a, int l, int r, int k) {
        if(l >= r) return 0;
        int p = partition(a, l ,r);
        if(p + 1 == k) {
            return a[p];
        } else if(p + 1 > k) {
            return getKthSmallest(a, p + 1, r, k);
        } else {
            return getKthSmallest(a, l, p - 1, k);
        }
    }

    public static void main(String[] args) {
        int[] a = {8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        quickSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}


