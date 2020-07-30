import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list
 * Follow Up: How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDups {

    public static void main(String[] args) {

        // This is just demonstrating the functionality of the SinglyList class
        // I wrote. I figured I shouldn't be using java.util.LinkedList. (Especially
        // since that implementation is a doubly list, and some questions asked for a singly)
        SinglyList<String> list = new SinglyList<>("First");
        list.add("Second");
        list.add("Third");
        list.add("Fourth");

        System.out.println(list.toString());

        list.remove("Third");
        System.out.println(list.toString());

        list.add("Fifth");
        list.remove("First");
        System.out.println(list.toString());

        // This is where testing for this assignment begins
        list.add("First1");
        list.add("First1");
        list.add("Dupe2");
        list.add("Dupe2");

        System.out.println(list);
        removeDups(list);
        System.out.println(list);
    }

    public static <T> void removeDups(SinglyList<T> list) {

        // This is a buffer containing any element from list.
        // To avoid using this buffer (follow up), we would need
        // to use the runner method (Having two pointers move
        // through the linked list). This can easily be accomplished
        // through a nested loop.
        //
        // That implementation would be O(n^2) because for every element
        // in the list, you have to search through every element in the
        // list again for duplicates, making this implementation of O(n)
        // more optimal for use
        Set<T> cache = new HashSet<>();

        SinglyList.Node<T> current = list.first;
        do {
            if (!cache.add(current.data)) {
                list.remove(current.data);
            }
        } while ((current = current.next) != null);
    }
}
