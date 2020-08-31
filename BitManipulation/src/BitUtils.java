public class BitUtils {

    /**
     * Don't let anyone instantiate this class
     */
    private BitUtils() {
    }

    public static boolean getBit(int bits, int location) {
        return (bits & (1 << location)) != 0;
    }

    public static int setBit(int bits, int location, boolean is1) {
        int value = is1 ? 1 : 0;
        int mask = ~(1 << location); // Mask used to clear the bit at the location
        return (bits & mask) | (value << location);
    }

    /**
     * Converts the given integer <code>i</code> to binary,
     * then either cuts off or adds onto the binary string
     * based on how many <code>bits</code> are needed
     *
     * @see Integer#toBinaryString(int)
     *
     * @param i Integer to translate to binary
     * @param bits How many bits to show
     * @return Binary String
     */
    public static String toBinary(int i, int bits) {
        String binary = Integer.toBinaryString(i);

        // If the binary string contains more bits than defined,
        // then return a substring containing only the asked for bits
        if (binary.length() > bits) {
            return binary.substring(binary.length() - bits);
        }

        // Not enough bits are in the binary string, so we are
        // going to add zeroes until we have the desired amount
        StringBuilder builder = new StringBuilder(bits);
        int bound = bits - binary.length();
        while (builder.length() < bound) {
            builder.append(0);
        }

        return builder.append(binary).toString();
    }
}
