/**
 * Implement a method to perform basic string compression using the counts
 * of repeated characters. For example, the string aabcccccaaa would become
 * a2b1c5a3. If the "compressed" string would not become smaller than the
 * original string, your method should return the original string. You can
 * assume that the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {

    public static void main(String[] args) {
        test("hi");
        test("echoecho");
        test("aabcccccaaa");
        test("abcddddd");
        test("abcdddddd");
    }

    public static void test(String str) {
        System.out.println(str + " -> " + compress(str));
    }

    public static String compress(String str) {
        StringBuilder compressed = new StringBuilder();

        int index = 0;
        while (index < str.length()) {
            char c = str.charAt(index);
            int count;

            // Trace the string until the character changes
            for (count = 1; index + count < str.length(); count++) {
                if (str.charAt(index + count) != c) {
                    break;
                }
            }

            compressed.append(c).append(count);
            index += count;
        }

        return compressed.length() < str.length() ? compressed.toString() : str;
    }
}
