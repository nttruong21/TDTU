/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TDTU STUDENT
 */
public class Node {
    private int data;
    private Node next;
    
    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
    
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
    
    public Node() {
        this.next = null;
    }
    
    public int getData() {
        return this.data;
    }
    
    public Node getNext() {
        return this.next;
    }
    
    public void setNext(Node next) {
        this.next = next;
    }
}
