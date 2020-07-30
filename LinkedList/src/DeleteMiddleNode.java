/**
 * Implement an algorithm to delete a node in the middle
 * (i.e., any node but the first and last node, not
 * necessarily the exact middle) of a singly list, given
 * only access to that node
 */
public class DeleteMiddleNode {

    public static void main(String[] args) {
        SinglyList<Integer> list = new SinglyList<>(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        // Going to delete the second node, in this case
        SinglyList.Node<Integer> second = list.first.next;
        System.out.println(list);
        deleteNode(second);
        System.out.println(list);
    }

    public static <T> void deleteNode(SinglyList.Node<T> node) {

        SinglyList.Node<T> previous = null;
        SinglyList.Node<T> current = node;

        // While there is still data in the list...
        while (current.next != null) {

            // Set the current data to the next data, and update
            // previous and current
            current.data = current.next.data;
            previous = current;
            current = current.next;
        }

        // Remove the last element in the list
        if (previous == null) {
            throw new IllegalArgumentException("Given node was not in the middle!");
        }

        // Forget about the last element in the list, effectively deleting it
        previous.next = null;
    }
}
