package binary_search;

/**
 * 有序数组，利用二分查找在二维数组中查找一个数
 *
 * @author Zcc
 * Create on  2018/9/8
 **/
public class Practice1 {

    private static String findTargetIndex(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length * matrix[0].length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int column = mid % matrix[0].length;
            int row = mid / matrix[0].length;
            if (matrix[row][column] < target) {
                left = mid + 1;
            } else if (matrix[row][column] > target) {
                right = mid - 1;
            } else {
                return "row :" + row + "  column: " + column;
            }
        }
        return "-1";
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        System.out.println(findTargetIndex(matrix, 8));
    }
}
