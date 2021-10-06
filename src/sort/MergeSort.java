package sort;

import java.util.Arrays;

/**
 * @program: algo
 * @description: 归并排序
 * @author: ycbron
 * @create: 2021-10-06 20:56
 **/
public class MergeSort {
    /**
     * @param: a
     * @param: n
     * @description: a 表示数组，n 表示数组大小
     * @return: void
     * @author: ycbron
     * @date: 2021/10/6
     */
    private static void mergeSort(int[] a, int n) {
        mergeSortInternally(a, 0, n-1);
    }
    /**
     * @param: a
     * @param: p
     * @param: r
     * @description: 递归调用函数
     * @return: void
     * @author: ycbron
     * @date: 2021/10/6
     */
    private static void mergeSortInternally(int[] a, int p, int r) {
        // 递归终止条件
        if(p >= r) return;
        int q = p + (r - p)/2;
        // 分治
        mergeSortInternally(a, p, q);
        mergeSortInternally(a, q + 1, r);
        // 将 a[p...q] 和 a[q+1...r] 合并成 a[p...r]
        merge(a, p, q, r);
    }
    /**
     * @param: a
     * @param: p
     * @param: q
     * @param: r
     * @description: 合并数组
     * @return: void
     * @author: ycbron
     * @date: 2021/10/6
     */
    private static void merge(int[] a, int p, int q, int r) {
        int i = p, j = q + 1, k = 0;
        // 申请和原数组同样空间大小的数组
        int[] tmp = new int[r-p+1];
        while (i <= q && j <= r) {
            if(a[i] <= a[j]) {
                tmp[k++] = a[i++];
            }
            else {
                tmp[k++] = a[j++];
            }
        }
        // 判断前后两个子数组中哪个数组有剩余数据
        int start = i, end = q;
        // 若j <= r,说明后半部分数组有剩余数据
        if(j <= r) {
            start = j;
            end = r;
        }
        // 将剩余数据拷贝到临时数组尾部
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        for(i = 0; i <= r - p; i++){
            a[p + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] a = {8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(a));
        mergeSort(a, a.length);
        System.out.println(Arrays.toString(a));
    }
}
