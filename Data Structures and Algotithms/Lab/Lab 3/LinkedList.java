import java.util.NoSuchElementException;
public class LinkedList<E> {
    private Node<E> head;
    private int numNode;

    public LinkedList() {
        head = null;
        numNode = 0;
    }

    public void addFirst(E item) {
        head = new Node<E>(item, head);
        numNode ++;
    }

    public Node<E> getHead() {
        return head;
    }

    public void removeFirst() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException("Can not remove first element from an empty linked list!");
        }
        else {
            head = head.getNext();
            numNode--;
        }
    }

    public boolean isEmpty() {
        return (numNode == 0);
    }

    public void printList() {
        System.out.print(" Linked list:\t" + head.getData());
        for (Node<E> temp = head.getNext(); temp != null; temp = temp.getNext()) {
            System.out.print(" -> " + temp.getData());
        }
        System.out.println();
    }

    public void addSortedList(E item) {
        if(isEmpty()) {
            addFirst(item);
        }
        else if(head.compareTo(item) >= 0) {
            addFirst(item);
        }
        else {
            Node<E> temp = new Node<E>(item);
            for(Node<E> curr = head; curr != null; curr = curr.getNext()) {
                if(curr.getNext().compareTo(item) >= 0) {
                    temp.setNext(curr.getNext());
                    curr.setNext(temp);
                    break;
                }
            }
        }
    }
}
