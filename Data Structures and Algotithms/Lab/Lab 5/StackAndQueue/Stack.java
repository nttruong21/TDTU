package StackAndQueue;
/**
 * @author Nguyen The Truong
 */

import java.util.NoSuchElementException;

public class Stack<E> {
    private Node<E> top;
    private int numNode;

    public Stack() {
        this.top = null;
        this.numNode = 0;
    }

    public void setTop(Node<E> top) {
        this.top = top;
    }

    public Node<E> getTop() {
        return this.top;
    }

    public int getNumNode() {
        return this.numNode;
    }

    // Push() method
    public void push(E item) {
        top = new Node<E>(item, top);
        numNode ++;
    }

    // Pop() method
    public E pop() throws NoSuchElementException {
        if(numNode == 0) {
            throw new NoSuchElementException("Can not get the top element from an empty stack!");
        }
        else {
            E data = top.getData();
            top = top.getNext();
            numNode--;
            return data;
        }
    }

    // Peek() method
    public E peek() throws NoSuchElementException {
        if(numNode == 0) {
            throw new NoSuchElementException("Can not get the top element from an empty stack!");
        }
        return top.getData();
    }

    // Check stack is empty?
    public boolean isEmpty() {
        return (numNode == 0);
    }
}
