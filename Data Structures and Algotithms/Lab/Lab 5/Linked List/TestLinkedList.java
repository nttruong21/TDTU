/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TDTU STUDENT
 */
public class TestLinkedList {
    public static void main(String[] args) {
        IntLinkedList list = new IntLinkedList();
        list.addFirst(21);
        list.addLast(100);
        list.addFirst(-5);
        list.addFirst(3);
        list.print();
        list.removeAt(2);
        list.print();
        System.out.println("Total odd number: " + list.countOdd());
        System.out.println("Position of 21 in linked list: " + list.searchKey(21));
        System.out.println("Linked list is sorted? " + list.checkSorted());
    }
}
