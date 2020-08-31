/**
 * You have an integer and you can flip exactly 1 bit from a 0 to a 1.
 * Write code to find the length of the longest sequence of 1s you could
 * create.
 *
 * Example:
 *   Input:  1775 (11011101111)
 *   Output: 8
 */
public class FlipBitToWin {

    public static void main(String[] args) {
        System.out.println(flipBit(1775));
    }

    public static int flipBit(int bits) {
        String binary = Integer.toBinaryString(bits);

        // The variable storing how many bits are in the row
        int count = 0;

        // The position we flipped the zero at
        int zeroPos = -1;

        // The longest string of 1s found
        int max = 0;


        for (int i = 0; i < binary.length(); i++) {
            char c = binary.charAt(i);

            if (c == '1') {
                count++;
            } else if (zeroPos == -1) {
                zeroPos = i;
                count++;
            } else {

                // Resetting variables, and checking for max
                i = zeroPos;
                zeroPos = -1;

                max = Math.max(count, max);
                count = 0;
            }
        }

        // Do an extra max check in case the binary string
        // doesn't end in zeros (Which would result in the count
        // never being checked if it were the max)
        return Math.max(count, max);
    }
}
