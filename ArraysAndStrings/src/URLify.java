/**
 * Write a method to rpelace all SPACEs in a string with '%20'. You
 * may assume that the string has sufficient SPACE at the end to hold
 * the actual characters, and that you are given the "true" length of
 * the string. (Note: If implementing in java, please use a character
 * array so that you can perform this operation in place.)
 *
 * Example:
 *   Input:     "Mr John Smith      ", 13
 *   Output:    "Mr%20John%20Smith"
 */
public class URLify {

    // The number of elements the characters '%', '2', and '0'
    // will fill up an array
    public static final int SPACE = "%20".length();

    public static void main(String[] args) {
        test("Mr John Smith");
        test("how to fix my issue stack overflow");
        test("three words here");
        test("why am I looking this up");
        test("house");
        test("youtube");
    }

    /**
     * Test method that automatically finds the actual and logical size
     * needed for a character array defined by the issue (changes the string
     * to an array and adds extra space at the end for shifting)
     *
     * @param str The string to adapt
     */
    public static void test(String str) {

        // Adapts the string into a character array with extra space
        int count = (int) str.chars().filter(c -> c == ' ').count();
        int logicalSize = str.length();
        char[] characters = new char[logicalSize + count * SPACE];

        // Copy the characters from the string over to the character array
        for (int i = 0; i < logicalSize; i++) {
            characters[i] = str.charAt(i);
        }

        System.out.println("\tInput: \t" + new String(characters));
        changeToURL(characters, logicalSize);
        System.out.println("\tOutput:\t" + new String(characters));
        System.out.println();
    }

    public static void changeToURL(char[] str, int length) {

        // Counter representing the number of times we found a space
        int counter = 0;

        // It's important to use the actual size of the array here
        // instead of the logical size, since we are shifting elements
        // around
        for (int i = 0; i < str.length; i++) {
            char c = str[i];

            if (c == ' ') {

                remove(str, i + 1);
                shift(str, i, length + counter * SPACE, SPACE);
                for (int j = i; j < i + SPACE; j++) {
                    str[j] = "%20".charAt(j - i);
                }

                counter++;
            }
        }
    }

    /**
     * Removes the character at the given index and shifts
     * all elements up the array 1 to fill in the gap
     *
     * Note: The length of the array does not change
     *
     * @param arr Array to modify
     * @param index Index to remove
     */
    public static void remove(char[] arr, int index) {
        shift(arr, index, arr.length, -1);
    }

    /**
     * Shifts all values in the given array
     *
     * @param arr The array to shift
     * @param index The starting point of values to shift
     * @param length The ending point of values to shift
     * @param amount How far to shift those values down
     */
    public static void shift(char[] arr, int index, int length, int amount) {

        // Copy all necessary values then remove them
        // from the base array (giving as a "clear" spot
        // where the characters were shifted)
        char[] copied = new char[length - index];
        for (int i = index; i < length; i++) {
            copied[i - index] = arr[i];
            arr[i] = '\u0000'; // Default character 'null'
        }

        // Copy the characters in the copied array back
        // into the base array,
        for (int i = 0; i < copied.length; i++) {
            arr[index + i + amount] = copied[i];
        }
    }
}
