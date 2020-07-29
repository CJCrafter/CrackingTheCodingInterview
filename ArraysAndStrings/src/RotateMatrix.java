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
                        byteColor(255, 255, 255),
                        byteColor(0, 255, 0),
                        byteColor(10, 10, 10)
                }
        };

        System.out.println(Arrays.deepToString(arr));
        System.out.println(Arrays.deepToString(rotate(arr)));
    }

    /**
     * Rotates the given array by 90
     *
     * @param arr The array to rotate
     * @return The rotated array
     */
    public static int[][] rotate(int[][] arr) {

        // If the array has no contents, no rotation can be applied
        if (arr.length == 0) {
            return arr.clone();
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

    /**
     * Formats an RGB color into an integer
     *
     * @param r Red component
     * @param g Green component
     * @param b Blue component
     * @return The RGB int color
     */
    private static int byteColor(int r, int g, int b) {
        return ((0xFF) << 24)| ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | ((b & 0xFF));
    }
}
