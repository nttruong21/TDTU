public class Node<E> {
    private E data;
    private Node<E> next;

    public Node(E item) {
        this.data = item;
        this.next = null;
    }

    public Node(E item, Node<E> next) {
        this.data = item;
        this.next = next;
    }

    public void setData(E item) {
        this.data = item;
    }

    public E getData() {
        return this.data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public int compareTo(E data) {
        return ((Node<E>) this.getData()).compareTo(data);
    }
}
