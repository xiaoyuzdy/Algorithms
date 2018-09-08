package binary_search;

/**
 * 有序数组，利用二分查找找到最接近目标值的数
 *
 * @author Zcc
 * Create on  2018/9/8
 **/
public class Practice2 {

    private static int findClosest(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < target) {
                left = mid;
            } else if (target < array[mid]) {
                right = mid;
            } else {
                return mid;
            }
        }

        if (Math.abs(array[left] - target) < Math.abs(array[right] - target)) {
            return left;
        } else {
            return right;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 7, 8, 9};
        System.out.println("index--->" + findClosest(array, 5));
    }

}
