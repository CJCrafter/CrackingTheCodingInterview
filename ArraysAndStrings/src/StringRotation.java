/**
 * Assume you have a method <code>isSubstring</code> which checks
 * if one word is a substring of another. Given two strings,
 * write code to check if s2 is a rotation of s1 using only one
 * call to isSubstring (e.g.,"waterbottle" is a rotation of "erbottlewat")
 */
public class StringRotation {

    public static void main(String[] args) {
        System.out.println(isRotation("erbottlewat", "waterbottle")); // true
        System.out.println(isRotation("water", "awter")); // false
    }

    public static boolean isRotation(String s1, String s2) {

        // Concatenate 2 strings together. Going back to the waterbottle
        // example, now we have: "erbottlewaterbottlewat"
        s1 = s1.concat(s1);

        return isSubstring(s1, s2);
    }

    private static boolean isSubstring(String string, String sub) {
        return string.contains(sub);
    }
}
