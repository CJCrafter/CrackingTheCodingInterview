import java.util.Arrays;

/**
 * Given an image represented by an NxN matrix, where each pixel
 * in the image is 4 bytes. Write a method to rotate the image
 * by 90 degrees. Can you do this in place?
 *
 * This implementation supports both NxN matrices, and NxM (Or,
 * rectangular) matrices.
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                new int[] {
                        byteColor(255, 255, 255, 255),
                        byteColor(255, 0, 255, 0),
                        byteColor(255, 10, 10, 10)
                }
        };

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(rotate(arr)));
    }

    public static int[][] rotate(int[][] arr) {

        // If the array has no contents, no rotation can be applied
        if (arr.length == 0) {
            return arr;
        }

        // Create an array to store the rotated image
        int[][] temp = new int[arr[0].length][arr.length];

        // Fill the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                // This is where the actual rotation occurs
                temp[j][i] = arr[i][j];
            }
        }

        return temp;
    }

    private static int byteColor(int a, int r, int g, int b) {
        return a << 24 | r << 16 | g << 8 | b;
    }
}
