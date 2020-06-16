import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Implement an algorithm to determine if a string has all unique
 * characters. What if you cannot use additional data structures?
 */
public class IsUnique {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        // Gets all methods in this class that are to be tested.
        // Using the annotation fixes the issue of compiler-added
        // (Which are still present in Class#getDeclaredMethods) and
        // avoids testing methods in the super class
        Set<Method> methods = Arrays.stream(IsUnique.class.getMethods())
                .filter(method -> method.isAnnotationPresent(Testable.class))
                .collect(Collectors.toSet());

        for (Method method : methods) {

            System.out.println("Testing method " + method.toGenericString());

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
    @Testable
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
    @Testable
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

    /**
     * Implementation of the defined algorithm utilizing
     * java 8's streams and lambda expressions
     *
     * @param str The string to test against
     * @return true if all the characters are unique
     */
    @Testable
    public static boolean isUniqueStream(String str) {

        for (char c : str.toCharArray()) {

            // Count the number of characters found
            long count = str.chars().filter(character -> character == c).count();
            if (count != 1L) {
                return false;
            }
        }
        return true;
    }

    /**
     * Methods annotated by <code>Testable</code> are tested.
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    private @interface Testable {
    }
}
