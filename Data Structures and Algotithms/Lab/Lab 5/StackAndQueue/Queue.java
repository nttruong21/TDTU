package StackAndQueue;

/**
 * @author Nguyen The Truong
 */

 import java.util.NoSuchElementException;

public class Queue<E> {
    private Node<E> front;
    private Node<E> rent;
    private int numNode;

    public Queue() {
        this.front = null;
        this.rent = null;
        this.numNode = 0;
    }

    public Node<E> getFront() {
        return this.front;
    }

    public Node<E> getRent() {
        return this.rent;
    }

    public void setFront(Node<E> item) {
        this.front = item;
    }

    public void setRent(Node<E> item) {
        this.rent = item;
    }

    public boolean isEmpty() {
        return (numNode == 0);
    }

    public void enQueue(E item) {
        if(isEmpty()) {
            rent = new Node<E>(item, rent);
            front = rent;
            numNode++;
        }
        else {
            Node<E> temp = new Node<E>(item);
            rent.setNext(temp);
            rent = temp;
            numNode++;
        }
    }

    public E deQueue() throws NoSuchElementException {
        if(isEmpty()) {
            throw new NoSuchElementException("Can not get the front element from an empty queue!");
        }
        else {
            E data = front.getData();
            front = front.getNext();
            return data;
        }
    }
}
