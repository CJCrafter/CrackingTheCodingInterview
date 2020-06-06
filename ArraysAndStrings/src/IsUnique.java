import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 *
 * For simplicity, all methods in this class should take
 * a string parameter and return a boolean
 */
public class IsUnique {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = IsUnique.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.getName().equals("main")) continue;

            System.out.println("Testing method " + method.getName());
            System.out.println("\t\"test\": " + method.invoke(null, "test")); // false
            System.out.println("\t\"hello\": " + method.invoke(null, "hello")); // false
            System.out.println("\t\"hey\": " + method.invoke(null, "hey")); // true
            System.out.println("\t\"Test with three\": " + method.invoke(null, "Test with three")); // false

        }
    }

    /**
     * Implementation of the defined algorithm utilizing
     * java's Collections Library
     *
     * @see java.util.Set#contains(Object)
     *
     * @param str The string to test against
     * @return true if all the characters are unique
     */
    public static boolean isUniqueSet(String str) {
        Set<Character> characters = new HashSet<>();

        // Attempt to add all characters from the str to the set
        for (char c : str.toCharArray()) {

            // If the character added is already in the set, the
            // set is not unique
            if (!characters.add(c)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Implementation of the defined algorithm utilizing no
     * other data structure
     *
     * @param str The string to test against
     * @return true if all the characters are unique
     */
    public static boolean isUniqueChallenge(String str) {

        // Iterate through every character
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);

            // Iterate through every character
            for (int j = 0; j < length; j++) {
                char duplicate = str.charAt(j);

                // Check if the 2 characters are found at different indexes AND
                // the 2 characters are equal
                if (i != j && duplicate == c) {
                    return false;
                }
            }
        }

        // No duplicate characters were found, so the string
        // is known to have all unique characters
        return true;
    }


}
