/**
 * You are given 2 32-bit numbers, N and M, and two bit positions,
 * i and j. Write a method to insert M into N such that M starts
 * at bit j and ends at bit i, You can assume that the bits j
 * through i have enough space ti fit all of M. That is, if
 * M = 10011, you can assume there are at least 5 bits between j
 * and i. You would not, for example, have j = 3 and i = 2, because
 * M could not fully hit between bit 3 and bit 2.
 *
 * Example:
 * Input:  N = 10000000000, M = 10011, i = 2, j = 6
 * Output: N = 10001001100
 */
public class Insertion {

    public static void main(String[] args) {
        int n = Integer.parseInt("10000000000", 2);
        int m = Integer.parseInt("10011", 2);

        System.out.println(Integer.toBinaryString(insert(n, m, 6, 2)));
    }

    /**
     * Implementation of the defined algorithm
     *
     * @param n The "base" bits, or the bits that will hold <code>m</code>
     * @param m The bits being added to <code>n</code>
     * @param start The starting position, j (inclusive)
     * @param end The ending position, i (inclusive)
     * @return <code>n</code> with <code>m</code> inserted
     */
    public static int insert(int n, int m, int start, int end) {
        return clear(n, start, end) | (m << end);
    }

    public static int clear(int n, int start, int end) {

        // We want a mask looking something like 11100011
        return n & (((1 << start + 1) - 1) ^ (-1 << (end)));
    }
}
