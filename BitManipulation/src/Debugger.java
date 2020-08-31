/**
 * Explain what the following code does: ((n & (n - 1)) == 0)
 *
 * Returns true if none of the bits in (n) and (n - 1) are the same...
 *
 * Returns true if there is only 1 bit turned on
 */
public class Debugger {

    public static void main(String[] args) {
        System.out.println(test(1));
        System.out.println(test(2));
        System.out.println(test(3));
        System.out.println(test(7));
        System.out.println(test(33));
        System.out.println(test(-1));
        System.out.println(test(54));
        System.out.println(test(36));
        System.out.println(test(4));
        System.out.println(test(8));

        System.out.println(BitUtils.toBinary(62, 8));
        System.out.println(BitUtils.toBinary(61, 8));
    }

    public static boolean test(int n) {
        return ((n & (n - 1)) == 0);
    }
}
