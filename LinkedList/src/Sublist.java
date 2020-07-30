/**
 * Return Kth to Last: Implement an algorithm to find
 * the kth to last element of a singly list
 */
public class Sublist {

    public static void main(String[] args) {
        SinglyList<String> list = new SinglyList<>("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");
        list.add("Fifth");
        list.add("Sixth");
        list.add("Seventh");
        list.add("Eighth");

        System.out.println(list);
        SinglyList<String> sublist = sublist(list, 2);
        System.out.println(sublist);
    }

    /**
     * Creates a sublist in the given list starting (inclusively)
     * at <code>split</code>. If <code>split</code> is out of bounds,
     * an empty SinglyList will be returned
     *
     * @param list Which list to take from
     * @param split Variable defined by <code>K</code> in the problem
     * @param <T> The type of the list
     * @return The list starting at <code>split</code>
     */
    public static <T> SinglyList<T> sublist(SinglyList<T> list, int split) {

        SinglyList<T> temp = new SinglyList<>();

        int count = 0;
        SinglyList.Node<T> current = list.first;
        do {
            if (count++ >= split) {
                temp.add(current.data);
            }
        } while ((current = current.next) != null);

        return temp;
    }
}
