import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings, write a method to determine if one is a permutation of the other
 */
public class SinglePermutation {

    public static void main(String[] args) {
        test("test", "etst"); // true
        test("hello", "world"); // false
        test("rat", "tar"); // true
        test("jello", "oljel"); // true
        test("java", "jvaa"); // true
        test("6 char", "a lot more"); // false
    }

    private static void test(String str1, String str2) {
        boolean isPermutation = isPermutation(str1, str2);
        System.out.println("\"" + str1 + "\" is" + (isPermutation ? "" : " not") + " a permutation of \"" + str2 + "\"");
    }

    /**
     * Implementation of the defined method utilising java's
     * Map api.
     *
     * @see Map
     *
     * @param str1 The first string
     * @param str2 The second string
     * @return if <code>str1</code> is a permutation of <code>str2</code>
     */
    private static boolean isPermutation(String str1, String str2) {

        // Strings are different sizes, cannot be a permutation
        if (str1.length() != str2.length()) {
            return false;
        }

        Map<Character, Integer> characterCounter1 = new HashMap<>(26);
        for (char c : str1.toCharArray()) {

            // Get the counter for the current character
            int count = characterCounter1.getOrDefault(c, 0);
            characterCounter1.put(c, ++count);
        }

        Map<Character, Integer> characterCounter2 = new HashMap<>(26);
        for (char c : str2.toCharArray()) {

            // Get the counter for the current character
            int count = characterCounter2.getOrDefault(c, 0);
            characterCounter2.put(c, ++count);
        }

        return characterCounter1.equals(characterCounter2);
    }
}
