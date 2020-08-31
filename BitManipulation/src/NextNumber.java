/**
 * Given a positive integer, print the next smallest and the next largest number that
 * have the same number of 1 bits in their binary representation
 *
 * Bigger Logic:
 *
 * A zero will become a one, and a one will become a zero. Getting a large number means
 * getting the index of the least significant one, and tracing to the left until we find
 * an open 0, then moving all the ones in that range all the way to the right
 *
 * In:  00101100
 * Out: 00110001
 *
 *
 * Smaller Logic:
 *
 * A zero will become a one, and a one will become a zero. Getting a smaller number
 * means getting the index of the least significant bit that has a zero to the right
 * of it (So the bit can be moved to the right). There should be no other shifting
 * needed
 *
 * In: 00101011
 * Out: 00100111
 */
public class NextNumber {

    public static void main(String[] args) {
        int num = Integer.parseInt("00101100", 2);
        int big = getNextBigger(num);
        int small = getNextSmaller(num);

        System.out.println("num: " + num + " (00101100)");
        System.out.println("big: " + big + " (" + BitUtils.toBinary(big, 8) + ")");
        System.out.println("sml: " + small + " (" + BitUtils.toBinary(small, 8) + ")");
    }

    public static int getNextBigger(int bits) {

        boolean on = false;
        for (int i = 0; i < Integer.SIZE; i++) {

            // If the previous iteration found a 1, then we
            // need to check if the current iteration is
            // a good place to move that bit to
            if (on) {
                boolean canFlip = !BitUtils.getBit(bits, i);
                if (canFlip) {
                    bits = BitUtils.setBit(bits, i, true);
                    break;
                } else {

                    bits = BitUtils.setBit(bits, i, false);

                    // If we can't flip, than we know that this bit is a 1
                    // and we need to move the bit as far to the right as
                    // we can to make sure we get the smallest number
                    for (int j = 0; j < Integer.SIZE; j++) {
                        if (!BitUtils.getBit(bits, j)) {
                            bits = BitUtils.setBit(bits, j, true);
                            break;
                        }
                    }
                }

            } else if ((on = BitUtils.getBit(bits, i))) {
                bits = BitUtils.setBit(bits, i, false);
            }
        }

        return bits;
    }

    public static int getNextSmaller(int bits) {


        boolean hasSpace = false;
        for (int i = 0; i < Integer.SIZE; i++) {
            boolean on = BitUtils.getBit(bits, i);

            if (hasSpace) {
                if (on) {
                    bits = BitUtils.setBit(bits, i - 1, true);
                    bits = BitUtils.setBit(bits, i, false);
                    break;
                }
            } else {
                hasSpace = !on;
            }
        }

        return bits;
    }

}
