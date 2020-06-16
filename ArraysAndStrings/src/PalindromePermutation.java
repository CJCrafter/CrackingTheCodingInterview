import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards. A
 * permutation is a rearrangement of letters. The palindrome does not need to be
 * limited to just dictionary words.
 *
 * (TIP: Strip away all non alphabetical characters)
 *
 * todo add an implementation using an array of integers containing the counts of each character
 * (avoid using regex ^)
 */
public class PalindromePermutation {

    // Matches groups of non lowercase alphabetical characters
    public static final Pattern pattern = Pattern.compile("[^a-z]+");

    public static void main(String[] args) {
        test("Tact Coa");
        test("Racecra");
        test("I see a cat");
        test("Not");
        test("lol");
        test("string");
        test("lljjrrrrt");
    }

    public static void test(String str) {

        String temp = str.toLowerCase();
        Matcher matcher = pattern.matcher(temp);

        StringBuilder builder = new StringBuilder();
        int previousIndex = 0;
        while (matcher.find()) {
            builder.append(temp, previousIndex, matcher.start());
            previousIndex = matcher.end();
        }
        builder.append(temp, previousIndex, str.length());

        String toTest = builder.toString();
        boolean isPalindrome = isPalindrome(toTest);
        System.out.println(str + " is" + (isPalindrome ? "" : " not") + " a permutation of a palindrome");
    }

    /**
     * This algorithm finds if a string has an even
     * number of every character, only allowing for 1
     * odd amount of characters. This effectively finds
     * if the string is a permutation of a palindrome
     *
     * @param str The string to test
     * @return true if the string is a permutation of a palindrome
     */
    public static boolean isPalindrome(String str) {

        int length = str.length();
        Set<Character> alreadyChecked = new HashSet<>(length);
        boolean foundOdd = false;

        for (int i = 0; i < length; i++) {

            // Check to make sure we didn't already check this character
            char c = str.charAt(i);
            if (!alreadyChecked.add(c)) {
                continue;
            }

            // Determine whether or not there is an odd number of this character
            // in the String
            int count = (int )str.chars().filter(character -> character == c).count();
            boolean isOdd = count % 2 == 1;

            if (isOdd) {
                if (foundOdd) return false;
                else foundOdd = true;
            }
        }

        return true;
    }
}
