package binary_search;

/**
 * 有序数组，找出第一次出现target元素的index
 *
 * @author Zcc
 * Create on  2018/9/8
 **/
public class Practice3 {
    private static int findFirstIndex(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else {
                if (array[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 3, 8, 8, 8, 8, 9, 9};
        System.out.println("index--->" + findFirstIndex(array, 8));
    }
}
