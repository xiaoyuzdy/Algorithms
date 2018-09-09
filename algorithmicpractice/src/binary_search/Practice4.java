package binary_search;

/**
 * 给定一个未知边界的有序数组，确定target是否在数组内，两倍扩容，再进入查找，找不到继续扩容，继续查找，如此反复
 * 时间复杂度O（lgN）(确定范围的时间复杂度)+O(lgN)（二分查找的时间复杂度）
 * 空间复杂度O（1）
 *
 * @author Zcc
 * Create on  2018/9/8
 **/
public class Practice4 {

    private static int findTargetIndex(int[] array, int target) {
        int left = 0;
        int right = 1;
        //是否触到边界
        boolean arrivals = false;
        while (right < array.length) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (array[mid] < target) {
                    left = mid + 1;
                } else if (target < array[mid]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
            left = right;
            right = right * 2;
            if (right > array.length - 1 && !arrivals) {
                right = array.length - 1;
                arrivals = true;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        System.out.println("index--->" + findTargetIndex(array, 10));
    }
}
