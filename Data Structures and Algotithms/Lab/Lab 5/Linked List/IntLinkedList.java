/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TDTU STUDENT
 */
public class IntLinkedList {
    private Node head;
    
    public IntLinkedList() {
        this.head = null;
    }
    
    public void addFirst(int data) {
        head = new Node(data, head);
    }
    
    public boolean addLast(int data) {
        if(head == null) {
            addFirst(data);
            return true;
        }
        Node temp = new Node(data);
        Node curr = head;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }
        temp.setNext(curr.getNext());
        curr.setNext(temp);
        return true;
    }
    
    public boolean removeAt(int position) {
        int numNode = 0;
        for(Node temp = head; temp != null; temp = temp.getNext()) {
            numNode ++;
        }
        if(position > numNode) {
            return false;
        }
        else {
            Node del = head;
            Node curr = null;
            for(int i = 1; i < position; i++) {
                curr = del;
                del = del.getNext();
            }
            curr.setNext(del.getNext());
            return true;
        }
    }
    
    public int countOdd() {
        int count = 0;
        for(Node temp = head; temp != null; temp = temp.getNext()) {
            if(temp.getData() % 2 != 0) {
                count ++;
            }
        }
        return count;
    }
    
    public int searchKey(int key) {
        int position = 1;
        for(Node temp = head; temp != null; temp = temp.getNext()) {
            if(temp.getData() == key) {
                return position;
            }
            position ++;
        }
        return -1;
    }
    
    public boolean checkSorted() {
        Node beforeNode = head;
        Node afterNode = head.getNext();
        while(afterNode.getNext() != null) {
            if(beforeNode.getData() < afterNode.getData() && afterNode.getData() > afterNode.getNext().getData()) {
                return false;
            }
            if(beforeNode.getData() > afterNode.getData() && afterNode.getData() < afterNode.getNext().getData()) {
                return false;
            }
            beforeNode = beforeNode.getNext();
            afterNode = afterNode.getNext();
        }
        
        return true;
    }
    
    public void print() {
        System.out.print("Int Linked List: " + head.getData());
        for(Node temp = head.getNext(); temp != null; temp = temp.getNext()) {
            System.out.print(" -> " + temp.getData());
        }
        System.out.println();
    }
}
