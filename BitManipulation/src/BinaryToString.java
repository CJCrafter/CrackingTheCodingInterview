/**
 * Given a real number between 0 and 1 (e.g., 0.72) that is passed
 * in as a double, print the binary representation. If the number
 * cannot be represented accurately in binary with at most 32
 * characters, print "ERROR"
 */
public class BinaryToString {

    public static void main(String[] args) {
        System.out.println(binaryToString(0.72, 32)); // Error
        System.out.println(binaryToString(0.25, 32)); // 01
    }

    /**
     * Converts the give <code>num</code> to a binary
     * <code>String</code> with a length less than
     * <code>precision</code>
     *
     * @param num A double number (0, 1)
     * @return Binary representation of that number
     */
    public static String binaryToString(double num, int precision) {
        StringBuilder binary = new StringBuilder();
        while (num > 0 && binary.length() < precision) {

            // Shifting bits to the left by 1
            num *= 2;

            if (num >= 1) {
                binary.append(1);
                num--;
            } else {
                binary.append(0);
            }
        }

        if (binary.length() >= precision) {

            // I should be throwing an exception here, but the problem
            // just wants me to print "ERROR"
            return "ERROR";
        }

        return binary.toString();
    }
}
