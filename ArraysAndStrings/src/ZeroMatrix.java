import java.util.Arrays;

/**
 * Write an algorithm such that if an element is an
 * MxN matrix is 0, it's entire row and column are set to 0.
 */
public class ZeroMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                new int[] {1, 1, 1, 1, 1, 0},
                new int[] {1, 1, 1, 1, 1, 1},
                new int[] {1, 1, 1, 0, 1, 1},
                new int[] {1, 1, 1, 1, 1, 1}
        };

        System.out.println(arrayToString(arr));
        System.out.println();
        System.out.println(arrayToString(populate(arr)));
    }

    public static int[][] populate(int[][] arr) {
        int[][] clone = copy(arr);

        if (arr.length == 0) {
            return clone;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    populateZero(clone, i, j);
                }
            }
        }

        return clone;
    }

    /**
     * Populates the given row and column with zeroes
     *
     * @param arr Array to populate
     * @param i Row to populate
     * @param j Column to populate
     */
    private static void populateZero(int[][] arr, int i, int j) {
        for (int y = 0; y < arr.length; y++) {
            arr[y][j] = 0;
        }
        for (int x = 0; x < arr[0].length; x++) {
            arr[i][x] = 0;
        }
    }

    /**
     * Copies the given 2 dimensional array. Since
     * java.util.Arrays doesn't support multi-dimensional
     * array copying, I have to create my own.
     *
     * @param arr Array to copy
     * @return Copied array
     */
    private static int[][] copy(int[][] arr) {

        int[][] copy = new int[arr.length][];

        for (int i = 0; i < arr.length; i++) {
            copy[i] = new int[arr[i].length];
            System.arraycopy(arr[i], 0, copy[i], 0, arr[i].length);
        }
        return copy;
    }

    /**
     * User readable version of Arrays.deepToString
     *
     * @param arr Array to print
     * @return user readable version of the array
     */
    private static String arrayToString(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        for (int[] array : arr) {
            builder.append(Arrays.toString(array)).append(",\n");
        }

        // Remove the comma and new line character
        builder.setLength(builder.length() - ",\n".length());
        return builder.toString();
    }
}
