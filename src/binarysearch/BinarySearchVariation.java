package binarysearch;

/**
 * @program: algo
 * @description:  二分查找变体
 * @author: ycbron
 * @create: 2021-10-31 22:47
 **/
public class BinarySearchVariation {

    /**
     * @param: a
     * @param: n
     * @param: value
     * @description: 查找第一个值等于给定值的元素
     * @return: int
     * @author: ycbron
     * @date: 2021/10/31
     */
    public static int binarySearchFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] < value) {
                low = mid + 1;
            }
            else {
                // mid == 0 表示数组中的第一个元素等于给定值，满足要求；若 mid != 0，且a[mid]的前一个元素不等于value，说明a[mid]就是要找的第一个等于给定值的元素，否则在mid前面寻找
                if((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

   /**
    * @param: a
    * @param: n
    * @param: value
    * @description: 查找最后一个值等于给定值的元素
    * @return: int
    * @author: ycbron
    * @date: 2021/10/31
    */
    public static int binarySearchLast(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if(a[mid] > value) {
                high = mid - 1;
            } else if(a[mid] < value) {
                low = mid + 1;
            } else {
                // mid == n - 1 表示数组中的最后一个元素等于给定值，满足要求；若 mid != n - 1，且a[mid]的后一个元素不等于value，说明a[mid]就是要找的最后一个等于给定值的元素，否则在mid后面寻找
                if((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
}
