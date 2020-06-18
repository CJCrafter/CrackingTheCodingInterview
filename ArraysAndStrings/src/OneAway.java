/**
 * There are three types of edits that can be performed on strings: insert
 * a character, remove a character, or replace a character. Given two
 * strings, write a function to check if they are one edit (or zero edits) away
 */
public class OneAway {

    public static void main(String[] args) {
        test("pale", "ple");   // true
        test("pales", "pale"); // true
        test("pale", "bale");  // true
        test("pale", "bake");  // false

        System.out.println();

        test("pale", "pale");  // true
        test("hi", "hello");   // false
        test("test", "test2"); // true
        test("mike", "ikes");  // false
        test("bale", "sale");  // true
        test("pale", "ale");   // true
    }

    public static void test(String str, String other) {
        boolean isOneAway = isOneAway(str, other);

        System.out.println(str + ", " + other + " -> " + isOneAway);
    }

    public static boolean isOneAway(String str, String other) {

        if (str.length() == other.length()) {
            return isOneEditReplace(str, other);
        } else if (str.length() + 1 == other.length()) {
            return isOneEditInsert(str, other);
        } else if (str.length() - 1 == other.length()) {
            return isOneEditRemove(str, other);
        } else {
            return false;
        }
    }

    /**
     * Determines if 0 or 1 characters are replaced from <code>str</code>
     * to <code>other</code>
     *
     * @param str Base string
     * @param other string to compare against
     * @return true if there are 0 or 1 differences
     */
    private static boolean isOneEditReplace(String str, String other) {

        boolean isDifferent = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != other.charAt(i)) {
                if (isDifferent) return false;
                else isDifferent = true;
            }
        }

        // This will occur if there are [0, 1] edits
        return true;
    }

    /**
     * Determines if one character was added to <code>str1</code>
     * to get to <code>str2</code>
     *
     * @param str1 Base string
     * @param str2 String with the added character
     * @return true if one character was added to <code>str1</code>
     */
    private static boolean isOneEditInsert(String str1, String str2) {

        int index1 = 0, index2 = 0;

        // Trace along both strings
        while (index1 < str1.length() && index2 < str2.length()) {
            char c1 = str1.charAt(index1);
            char c2 = str2.charAt(index2);

            // "successful" trace
            if (c1 == c2) {
                index1++;
                index2++;
            } else {

                // At this point, we've found different characters.
                // This means that the inserted character is in
                // the middle of str2.
                // So if we haven't already made the adjustment to
                // index2 before, make the adjustment. Otherwise,
                // there is more than one edit
                if (index1 == index2) {

                    // Only increment the second index, because the
                    // second string is the longer string
                    index2++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Determines if <code>other</code> has 1 character removed from
     * <code>str</code>
     *
     * @param str Base string
     * @param other String with 1 character removed
     * @return true if one character was removed from <code>str</code>
     */
    private static boolean isOneEditRemove(String str, String other) {
        return isOneEditInsert(other, str);
    }
}
