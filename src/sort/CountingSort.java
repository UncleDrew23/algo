package sort;

/**
 * @program: algo
 * @description: 计数排序
 * 计数排序只能用在数据范围不大的场景中，如果数据范围 k 比要排序的数据 n 大很多，就不适合用计数排序了。
 * 而且，计数排序只能给非负整数排序，如果要排序的数据是其他类型的，要将其在不改变相对大小的情况下，转化为非负整数。
 * @author: ycbron
 * @create: 2021-10-26 23:16
 **/
public class CountingSort {

    public static void countingSort(int[] a, int n) {
        if(n <= 1) return;

        // 查找数组中数据的范围
        int max = a[0];
        for(int i = 1; i < n; ++i) {
            if(max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组 c, 下标范围为 [0, max]
        int[] c = new int[max + 1];

        // 计算数组 a 中每个元素的个数，放入数组 c 中
        for(int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 顺序累加数组 c 中的元素
        for(int i = 1; i <= max; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组 r, 用来存储排序之后的结果
        int[] r = new int[n];
        for(int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1; // 找到在排序数组中的位置
            r[index] = a[i];
            c[a[i]]--; // 计数数组中相应位置上的数据个数少1
        }

        // 将排序后的结果拷贝回原数组
        for(int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }
}
