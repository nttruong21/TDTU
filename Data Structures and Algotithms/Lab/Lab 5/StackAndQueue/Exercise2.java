package StackAndQueue;

/**
 * @author Nguyen The Truong
 */

import java.util.Scanner;

public class Exercise2 {

    // Check palidrome number using stack
    public static boolean isPalidromeUseStack(int num) {
        String str = String.valueOf(num);
        int mid = str.length()/2;
        Stack<Integer> myStack = new Stack<Integer>();
        Queue<Integer> myQueue = new Queue<Integer>();
        for(int i = 0; i <= mid; i++) {
            myQueue.enQueue(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        for(int i = mid+1; i < str.length(); i++) {
            myStack.push(Integer.parseInt(String.valueOf(str.charAt(i))));
        }
        while(!myStack.isEmpty()) {
            int num1 = myStack.pop();
            int num2 = myQueue.deQueue();
            if(num1 != num2) 
                return false;
        }
        return true;
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        do {
            System.out.print("Enter number to check: ");
            num = sc.nextInt();
        } while(num < 1);
        System.out.println(num + " is a palidrome number? " + isPalidromeUseStack(num));
    }
}
