package binarysearch;

import java.util.Arrays;

/**
 * @program: algo
 * @description: 二分查找
 * @author: ycbron
 * @create: 2021-10-31 18:13
 **/
public class BinarySearch {
    /**
     * @param: a
     * @param: n
     * @param: value
     * @description: 二分查找非递归实现
     * @return: int
     * @author: ycbron
     * @date: 2021/10/31
     */
    public static int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
//            int mid = (low + high) / 2;
//            int mid = low + (high - low) / 2;
            int mid = low + ((high - low) >> 1);
            if(a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return  -1;
    }

    /**
     * @param: a
     * @param: n
     * @param: value
     * @description: 二分查找递归实现
     * @return: int
     * @author: ycbron
     * @date: 2021/10/31
     */
     public static int binarySearchInterval(int[] a, int n, int value) {
        return binarySearchInternally(a, 0, n - 1, value);
     }

     public static int binarySearchInternally(int[] a, int low, int high, int value) {
        if(low > high) return -1;

        int mid = low + ((high - low) >> 1);
        if(a[mid] == value){
            return mid;
        } else if(a[mid] < value) {
            return binarySearchInternally(a, mid + 1, high, value);
        } else {
            return binarySearchInternally(a, low, mid - 1, value);
        }
     }

    public static void main(String[] args) {
        int[] a = {12, 16, 48, 87, 97};
        System.out.println(Arrays.toString(a));
//        int value = binarySearch(a, a.length, 48);
        int value = binarySearchInterval(a, a.length, 48);
        System.out.println(value);
    }
}
