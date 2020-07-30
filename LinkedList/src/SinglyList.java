import java.util.Iterator;
import java.util.function.Consumer;

public class SinglyList<E> implements LinkedList<E> {

    protected Node<E> first;

    public SinglyList() {
    }

    public SinglyList(E e) {
        first = new Node<>(e);
    }

    @Override
    public void add(E e) {
        if (first == null) {
            first = new Node<>(e);
            return;
        }

        first.appendToTail(e);
    }

    @Override
    public void remove(E e) {
        if (first.data.equals(e)) {
            first = first.next;
            return;
        }

        Node<E> previous = first;
        Node<E> node = first.next;
        do {
            if (node.data.equals(e)) {
                previous.next = node.next;
                return;
            }

            previous = node;
            node = node.next;
        } while (node != null);
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        if (first == null) {
            return;
        }

        Node<E> node = first;
        do {
            action.accept(node.data);
        } while ((node = node.next) != null);

    }

    @Override
    public Iterator<E> iterator() {
        return new SinglyIterator<>(first);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        forEach(data -> builder.append(data.toString()).append(", "));

        // Remove the extra ", " at the end
        builder.setLength(builder.length() - 2);
        return builder.append("]").toString();
    }

    protected static final class Node<E> {

        protected Node<E> next = null;
        protected E data;

        private Node(E data) {
            this.data = data;
        }

        void appendToTail(E data) {
            Node<E> node = new Node<>(data);
            Node<E> n = this;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
    }

    private static class SinglyIterator<E> implements Iterator<E> {

        private Node<E> current;

        private SinglyIterator(Node<E> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public E next() {
            return (current = current.next).data;
        }
    }
}
